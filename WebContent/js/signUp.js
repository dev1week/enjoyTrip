// signUp start
const userId = document.querySelector("#userId");
const userPw = document.querySelector("#userPw");
const userName = document.querySelector("#userName");
const userEmail = document.querySelector("#userEmail");
const joinBtn = document.querySelector(".joinBtn");

const checkFill = (id, pw, name, email) => {
    if(id === '' || pw === '' || name === '' || email === ''){
        return false;
    }
    return true;
}


function clickJoinBtn(){
    joinBtn.addEventListener("click", ()=>{
        let id = userId.value;
        let pw = userPw.value;
        let name = userName.value;
        let email = userEmail.value;
        if(checkFill()){
            const userObj = {
                userId : id,
                userPw : pw,
                userName : name,
                userEmail : email,
            }
    
            localStorage.setItem("user", JSON.stringify(userObj));
            opener.location.reload();
            self.close();
        }else{
            alert("빈 칸이 존재합니다.");
        }
    })
}


clickJoinBtn();