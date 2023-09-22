let draggables = document.querySelectorAll(".draggable");
let containers = document.querySelectorAll("#box");


function getDragAfterElement(container, x, y) {
  const draggableElements = [
    ...container.querySelectorAll(".draggable:not(.dragging)"),
  ];

  return draggableElements.reduce(
    (closest, child) => {
      const box = child.getBoundingClientRect();
      const offsetX = x - box.left - box.width / 2;
      // console.log(offset);
      if (offsetX < 0 && offsetX > closest.offset) {
        return { offset: offsetX, element: child };
      } else {
        return closest;
      }
    },
    { offset: Number.NEGATIVE_INFINITY },
  ).element;
}


let temp = JSON.parse(localStorage.getItem("local"));
const localX = temp.x;
const localY = temp.y

//지도 관련 로직 
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
  mapOption = {
    center: new kakao.maps.LatLng(localX, localY),
    // center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
    level: 3 // 지도의 확대 레벨
  };
// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);




// "검색" 버튼에 클릭 이벤트 리스너를 추가합니다.
const searchButton = document.getElementById('btn-search');
searchButton.addEventListener('click', onPressSearch);

// 클릭 이벤트가 발생할 때 실행될 함수입니다.
function onPressSearch() {
  console.log('검색 버튼이 클릭되었습니다.');
  let baseUrl = `https://apis.data.go.kr/B551011/KorService1/`;
  let contentTypeId = document.getElementById("search-content-id").value;
  let radius = document.getElementById("search-distance").value;
  let mapX = map.getCenter().La;
  let mapY = map.getCenter().Ma;

  ;

  let queryString = `https://apis.data.go.kr/B551011/KorService1/locationBasedList1?numOfRows=5&pageNo=1&MobileOS=IOS&MobileApp=1&arrange=O&_type=json&mapX=${mapX}&mapY=${mapY}&radius=${radius}&contentTypeId=${contentTypeId}&serviceKey=8VkwuSU3F1o%2FviEluFALoOmMEtpxA9gGNJfpNx10B5SOl7oACYgQnWPMGBFw5XD3Mr9U3IZ1W0mIh0jBXOGlDA%3D%3D`

  console.log(queryString);
  fetch(queryString)
    .then((response) => response.json())
    .then((data) => makeList(data));
}
var positions;
function makeList(data) {

  let trips = data.response.body.items.item;
  var resultBox = document.querySelector(".resultBox");




  positions = [];
  let candidateBox = document.querySelector(".candidateBox");
  console.log('c', candidateBox);
  // candidateBox의 자식 요소 중에서 클래스가 "draggable"인 요소를 모두 선택합니다.
  let draggableElements = candidateBox.querySelectorAll(".draggable");

  // 선택된 각각의 요소를 반복하면서 제거합니다.
  draggableElements.forEach((element) => {
    if (candidateBox.contains(element)) {
      console.log(element);
      candidateBox.removeChild(element);
    }
  });

  trips.forEach((area) => {
    console.log(area);
    // 새로운 <div> 요소 생성
    let test = document.createElement("div");

    // 클래스, ID, 드래그 가능 속성 설정
    test.classList.add("draggable");
    test.id = "card";
    test.draggable = true;

    // 내부 HTML 내용 추가
    test.innerHTML = `
        <div class="detail">
          <h5>${area.title}</h5>
          <h6>${area.tel}</h6>
          <h6>${area.addr1}</h6>
        </div>
        <img class="thumbnail" src="${area.firstimage}" />
      `;



    // 위도와 경도 데이터 속성 추가
    test.setAttribute("data-latitude", area.mapx);
    test.setAttribute("data-longitude", area.mapy);

    // 생성한 요소를 삽입할 부모 요소 선택
    let candidateBox = document.querySelector(".candidateBox");

    // 생성한 요소를 부모 요소에 추가
    candidateBox.appendChild(test);

    let markerInfo = {
      title: area.title,
      latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
    };
    positions.push(markerInfo);
  })

  //드래그 가능한 객체를 갱신합니다. 
  draggables = document.querySelectorAll(".draggable");



  //모든 그래그 가능한 객체에 대해 드래그 시작할 경우 이벤트 리스너 추가
  draggables.forEach(draggable => {
    draggable.addEventListener("dragstart", () => {
      draggable.classList.add("dragging");
    });


    //모든 드래그 가능한 객체에 대해 드래그 끝날 경우 아벤트 리스너 추가
    draggable.addEventListener("dragend", () => {
      draggable.classList.remove("dragging");
    });
  });


  //#box를 들고 있는 모든 객체를 들고 온다. 
  containers = document.querySelectorAll("#box");
  //#box를 들고 있는 모든 객체에 대해 뒤에 넣어줄지 앞에 넣어줄지 정해준다. 
  containers.forEach(container => {
    container.addEventListener("dragover", e => {
      e.preventDefault();
      const afterElement = getDragAfterElement(container, e.clientX, e.clientY);
      const draggable = document.querySelector(".dragging");
      //뒷 객체가 없을 경우 바로 자식으로 넣는다. 
      if (afterElement === undefined) {
        container.appendChild(draggable);
      } else {
        //뒷 객체가 있을 경우 뒷 객체 전에 넣어준다. 
        container.insertBefore(draggable, afterElement);

      }

      var result = []
      const resultBoxes = document.getElementsByClassName("resultBox");
      const firstResultBox = resultBoxes[0];

      const detailElements = firstResultBox.querySelectorAll(".detail");

      detailElements.forEach(detailElement => {
        const h5Text = detailElement.querySelector("h5").textContent;
        const h6Texts = detailElement.querySelectorAll("h6");
        const h6TextArray = Array.from(h6Texts).map(h6 => h6.textContent);

        result.push({ title: h5Text, address: h6TextArray[1] })
      });
      localStorage.setItem('myRoute', JSON.stringify(result));
    });
  });


  displayMarker();

}

var markers = [];
function displayMarker() {
  markers = [];
  // 마커 이미지의 이미지 주소입니다
  var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

  for (var i = 0; i < positions.length; i++) {
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      map: map, // 마커를 표시할 지도
      position: positions[i].latlng, // 마커를 표시할 위치
      title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      image: markerImage, // 마커 이미지
    });
    markers.push(marker);
    setMarkers(map);
  }

  // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
  map.setCenter(positions[0].latlng);
  map.setLevel(7);
}
function setMarkers(map) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}


const doneBtn = document.querySelector(".doneBtn");

doneBtn.addEventListener("click", ()=>{
  location.replace("plan.html");
})