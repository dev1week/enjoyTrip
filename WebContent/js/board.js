const writeBtn = document.querySelector(".writeBtn");

function printBoard(){
    const table = document.querySelector(".table-body");
    let logInfo = JSON.parse(localStorage.getItem("log"));

    
   
    console.log(logInfo);
    logInfo.forEach(log => {
        // console.log(log)
        const trEl = document.createElement("tr");

        const tNum = document.createElement("td");
        tNum.innerText = log.logNum;
        const tTitle = document.createElement("td");
        tTitle.innerText = log.logTitle;
        const tDate = document.createElement("td");
        tDate.innerText = log.logDate;
        const tCount = document.createElement("td");
        tCount.innerText = 0;
        const tWriter = document.createElement("td");
        tWriter.innerText = log.userId;

        trEl.appendChild(tNum);
        trEl.appendChild(tTitle);
        trEl.appendChild(tDate);
        trEl.appendChild(tCount);
        trEl.appendChild(tWriter);
        table.appendChild(trEl);
    });
}


function clickWriteBtn(){
    writeBtn.addEventListener("click", (event) => {
        event.preventDefault();
        console.log("test");
        location.href="localhost:8080/board?action=mvAdd";
    })
}

function success(){
    let writeBtn = document.querySelector(".writeBtn");
    let nav1 = document.querySelector(".nav1");
    let nav2 = document.querySelector(".nav2");

    let status = localStorage.getItem("status");
    if(status === "true"){
        nav1.classList.add("hide");
        nav2.classList.remove("hide");
        writeBtn.classList.remove("hide");
    }else{
        nav1.classList.remove("hide");
        nav2.classList.add("hide");
        writeBtn.classList.add("hide");
    }
}

// function clickNavlog(){
//     navlog.addEventListener("click" , ()=>{

//         console.log("click")
//         location.replace("board.html");
//     })
// }


success();
clickWriteBtn();
printBoard();