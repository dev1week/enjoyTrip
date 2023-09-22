
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
    	console.log("click");
        if(checkFill()){
            let joinForm = document.querySelector("#joinForm")
            let root = document.getElementById("root").value;
            const url = `${root}/member`;
            console.log(url);
            joinForm.setAttribute("action", url);
            joinForm.submit();
            opener.location.reload();
            self.close();
        }else{
            alert("빈 칸이 존재합니다.");
        }
    })
}


clickJoinBtn();