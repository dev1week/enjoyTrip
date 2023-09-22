// 로그인
const loginBtn = document.querySelector(".loginBtn");
const signUpBtn = document.querySelector(".signUpBtn");
const loginCard = document.querySelector(".loginCard");
const profileCard = document.querySelector(".profileCard");
const logoutBtn = document.querySelector(".logout");
const makePlanBtn = document.querySelector(".makePlanBtn");
const findPwBtn = document.querySelector(".findPwBtn");
const myPageBtn = document.querySelector(".myPage");

let check;
function success(){
    let nav1 = document.querySelector(".nav1");
    let nav2 = document.querySelector(".nav2");

    let status = localStorage.getItem("status");
    if(status === "true"){
        nav1.classList.add("hide");
        nav2.classList.remove("hide");
        loginCard.style.display = "none";
        profileCard.style.display = "block"
    }else{
        nav1.classList.remove("hide");
        nav2.classList.add("hide");
        loginCard.style.display = "block";
        profileCard.style.display = "none"
    }
}

function login(){
    let id = document.querySelector(".idSpace");
    let pw = document.querySelector(".pwSpace");
    
    let user = JSON.parse(localStorage.getItem("user"));

    if(user === null){
        id.value = "";
        pw.value = "";
        alert("회원가입");
    }else{
        if(user.userId === id.value  && user.userPw === pw.value){
            check = true;
            localStorage.setItem("status", check);
            success();
        }else{
            id.value = "";
            pw.value = "";
            alert("다시 입력해주세요");
        }
    }
}




// 클릭 이벤트
function clickLoginBtn(){
    loginBtn.addEventListener("click", (event) => {
        login();
        event.preventDefault();
        localStorage.setItem("status", check);
        success();
    });
}

function clickSignUpBtn(){
    // 회원가입 
    signUpBtn.addEventListener("click", (event) => {
        event.preventDefault();
        window.open("signUp.html","_blank", "width=500px, height= 500px");
    })
}
// login end



function clickMakePlanBtn() {
    makePlanBtn.addEventListener("click", () => {
        location.replace("local.html");
    })
}

function clickLogoutBtn(){
    logoutBtn.addEventListener("click", ()=>{
        check = false;
        localStorage.setItem("status", check);
        location.reload();
    })
}


function clickMypage(){
    myPageBtn.addEventListener("click", ()=>{
        let status = localStorage.getItem("status");
        if(status === null || status === "false"){
            alert("로그인해주세요");
        }else{
            location.replace("myPage.html");
        }
    })
}

function clickFindPwBtn(){
    findPwBtn.addEventListener("click", (event)=>{
        event.preventDefault();
        window.open("findPW.html","_blank", "width=500px, height= 500px");
    })
}

function clickNavlog(){
    let navlog = document.querySelector(".navlog");
    
    navlog.addEventListener("click" , ()=>{

        console.log("click")
        location.replace("board.html");
    })
}
function clickNavplan(){
    const navplan = document.querySelector(".navplan");
    
    navplan.addEventListener("click" , ()=>{
        console.log("hi")
        let status = localStorage.getItem("status");
        if(status === null || status === "false"){
            alert("로그인해주세요");
        }else{
            location.replace("plan.html");
        }
    })
}



function init(){
    success();
    

    // click events
    clickLoginBtn();
    clickSignUpBtn();
    clickMakePlanBtn();
    clickLogoutBtn();
    clickMypage();
    clickFindPwBtn();
    clickNavlog();
}
clickNavplan();

init();