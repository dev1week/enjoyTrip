const logTitle = document.querySelector(".logTitle");
const logText = document.querySelector(".logText");
const completeBtn = document.querySelector(".completeBtn");

// 글번호, 제목, 작성일, 작성자


function getLogDate(){
    const date = new Date();
    return date.getFullYear();
}

let number = 1;
let logData = []
function saveLog(){
    let temp = JSON.parse(localStorage.getItem("user"));
    let logs = JSON.parse(localStorage.getItem("log"));
    
    if(logs !== null){
        logs.forEach(logInfo => {
            const logObj = {
                logNum : number++,
                logTitle : logInfo.logTitle ,
                logDate : logInfo.logData,
                userId : logInfo.userId,
                logText : logInfo.logText,
            };
    
            logData.push(logObj);
        });
    }
    const logObj = {
        logNum : number++,
        logTitle : logTitle.value,
        logDate : getLogDate(),
        userId : temp.userId,
        logText : logText.value,
    };
    logData.push(logObj);
    localStorage.setItem("log", JSON.stringify(logData));
}   

function clickCompleteBtn(){
    completeBtn.addEventListener("click",() => {
        saveLog();
        opener.location.reload();
        self.close();
    })
}

clickCompleteBtn();