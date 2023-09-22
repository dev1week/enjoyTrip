<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/styles.css">
  </head>
  <body>
    <div class="container">
        <p class="joinP">회원가입</p>

        <div class="typeContainer">
            <div>
                <label for="userId">
                    <p>아이디</p>
                    <input type="text" name="" id="userId">
                </label>
            </div>
            <div>
                <label for="userPw">
                    <p>비밀번호</p>
                    <input type="text" name="" id="userPw">
                </label>
            </div>
            <div>
                <label for="userName">
                    <p>이름</p>
                    <input type="text" name="" id="userName">
                </label>
            </div>
            <div>
                <label for="userEmail">
                    <p>이메일</p>
                    <input type="text" name="" id="userEmail">
                </label>
            </div>
        </div>
        
        <input type="button" value="가입하기" class="joinBtn">
    </div>

    <script src="./js/signUp.js"></script>
  </body>
</html>
