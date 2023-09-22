
const mylogSpace = document.querySelector(".mylog-space");


function success(){
    let nav1 = document.querySelector(".nav1");
    let nav2 = document.querySelector(".nav2");

    let status = localStorage.getItem("status");
    if(status === "true"){
        nav1.classList.add("hide");
        nav2.classList.remove("hide");
    }else{
        nav1.classList.remove("hide");
        nav2.classList.add("hide");
    }
}


function printMyLog() {

    let myRoute = JSON.parse(localStorage.getItem("myRoute"));

    if(myRoute === null){
        temp += `<p>여행 계획이 없습니다.</p>`
        mylogSpace.innerHTML = temp;
    }else{

        let temp = '';
        myRoute.forEach(route => {
            if(route !== undefined){
    
                temp += `
                    <div class="routeCard">
                        <p>${route.title}</p>
                        <p>${route.address}</p>
                    </div>
                `
                
            }
    
            console.log(temp)
        });

        mylogSpace.innerHTML = temp;
    }
}

success();
printMyLog();