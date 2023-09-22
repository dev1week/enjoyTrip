const nmSpace = document.querySelector("#userName");
const emailSpace = document.querySelector("#userEmail");
const newPW = document.querySelector(".newPW");
const findBtn = document.querySelector(".findBtn");
const changeBtn = document.querySelector(".changeBtn");


function clickChangeBtn(){
    changeBtn.addEventListener("click", () => {
        let userInfo = JSON.parse(localStorage.getItem("user"));

        const userObj = {
            userId : userInfo.userId,
            userPw : newPW.value,
            userName : userInfo.userName,
            userEmail : userInfo.userEmail,
        }

        localStorage.setItem("user", JSON.stringify(userObj));
        opener.location.reload();
        self.close();
    })
}


function clickFindBtn(){
    findBtn.addEventListener("click", () => {
        let userInfo = JSON.parse(localStorage.getItem("user"));
        if(nmSpace.value === userInfo.userName && emailSpace.value === userInfo.userEmail){
            let typeInfoSpace = document.querySelector(".typeInfoSpace");
            let findPWSpace = document.querySelector(".findPWSpace");
            typeInfoSpace.classList.add("hide");
            findPWSpace.classList.remove("hide");
        }else{
            alert("존재하지 않는 회원정보입니다.");
        }
    })
}

clickFindBtn()
clickChangeBtn();