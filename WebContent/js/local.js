import {data} from "./data.js"

console.log(data);

function clickLocalCard(){
  const localCards = document.querySelectorAll(".localCard");
  
    localCards.forEach(localCard => {
      localCard.addEventListener("click", (event)=>{
        let target = event.target.parentNode.className;
        let localNum = target.split(" ")[1];
        
        console.log(localNum)
        console.log(data[localNum]);

        if(data[localNum] !== undefined){
          localStorage.setItem("local" ,JSON.stringify(data[localNum]) );
          location.replace("planning.html")
        }
      })
    }); 
}

clickLocalCard();

