// myPage
const idSpace = document.querySelector("#userId");
const pwSpace = document.querySelector("#userPw");
const nmSpace = document.querySelector("#userName");
const emailSpace = document.querySelector("#userEmail");

const modifyBtn = document.querySelector(".modifyBtn");
const leaveBtn = document.querySelector(".leaveBtn");
const doneBtn = document.querySelector(".doneBtn");


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




function printMyInfo(){
    let userInfo = JSON.parse(localStorage.getItem("user"));
    idSpace.value = userInfo.userId;
    pwSpace.value = userInfo.userPw;
    nmSpace.value = userInfo.userName;
    emailSpace.value = userInfo.userEmail;
}

function clickDoneBtn(){
    doneBtn.addEventListener("click", ()=>{
        let id = idSpace.value;
        let pw = pwSpace.value;
        let name = nmSpace.value;
        let email = emailSpace.value;
    
        const userObj = {
            userId : id,
            userPw : pw,
            userName : name,
            userEmail : email,
        }
    
        localStorage.setItem("user", JSON.stringify(userObj));
        
        idSpace.readOnly = true;
        pwSpace.readOnly = true;
        emailSpace.readOnly = true;

        
        modifyBtn.classList.remove("hide");
        leaveBtn.classList.remove("hide");
        doneBtn.classList.add("hide");
    })
}


function clickModifyBtn(){

    modifyBtn.addEventListener("click", (event) => {
        modifyBtn.classList.add("hide");
        leaveBtn.classList.add("hide");
        doneBtn.classList.remove("hide");
        
        idSpace.readOnly = false;
        pwSpace.readOnly = false;
        emailSpace.readOnly = false;

    });
}


function clickLeaveBtn(){
    leaveBtn.addEventListener("click", (event) => {
        localStorage.removeItem("user");
        check = false;
        localStorage.setItem("status", check);
        location.replace("index.html");
    });
}


printMyInfo();
clickLeaveBtn();
clickModifyBtn();
clickDoneBtn();
success();