<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> --%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="../css/styles.css">
  </head>
  <body>

    <div class="container">
        <p class="joinP">회원가입</p>

        <div class="typeContainer">
       		<form method="post" action="" id="joinForm">
       		<input type="hidden" id="root" value="${root}">
	            <div>
	                <label for="userId">
	                    <p>아이디</p>
	                    <input type="text" name="userId" id="userId">
	                </label>
	            </div>
	            <div>
	                <label for="userPw">
	                    <p>비밀번호</p>
	                    <input type="text" name="userPw" id="userPw">
	                </label>
	            </div>
	            <div>
	                <label for="userName">
	                    <p>이름</p>
	                    <input type="text" name="userName" id="userName">
	                </label>
	            </div>
	            <div>
	                <label for="userEmail">
	                    <p>이메일</p>
	                    <input type="text" name="userEmail" id="userEmail">
	                </label>
	            </div>
            </form>
        </div>
        
        <input type="button" value="가입하기" class="joinBtn">
    </div>

    <script>

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
    
         if(checkFill()){
             let joinForm = document.querySelector("#joinForm")
             let root = document.getElementById("root").value;
             const url = `${root}/member?action=join`;
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
    </script>
  </body>
</html>
