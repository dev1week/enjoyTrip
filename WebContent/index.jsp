<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/styles.css" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
    <nav>
      <div class="nav1">
        <span class="logo navlogo"><a href="index.html">여행하 개'</a></span>
        <div>
          <span class="navplan">나의 여행계획</span>
          <span class="navlog"><a href="board.html">여행기록</a></span>
        </div>
      </div>

      <div class="nav2 hide">
        <span class="navTitle navlogo"><a href="index.html">여행하 개'</a></span>
        <div>
          <span class="navplan">나의 여행계획</span>
          <span class="navlog"><a href="board.html">여행기록</a></span>
          <span class="myPage">마이페이지</span>
          <span class="logout">로그아웃</span>
        </div>
      </div>
    </nav>

    

    <section id="hero">
      <img src="./images/title.png" alt="" srcset="" class="title">


      <div class="card loginCard" style="width: 300px;" id="login">
        <div class="card-header cardHeader">반려견과 함께 여행을 떠나보세요</div>
        <div class="card-body loginCard-body">
          <d class="input-group mb-3">
            <input type="text" class="form-control idSpace" placeholder="아이디" />
          </d iv>
          <div class="input-group mb-3">
            <input
              type="password"
              class="form-control pwSpace"
              placeholder="비밀번호"
            />
          </div>

          <div class="subTxt">
            <p class="findPwBtn">비밀번호 찾기</p>
            <p class="signUpBtn">회원가입</p>
          </div>
   
          <button class="button loginBtn">로그인</button>
        </div>
      </div>


      <div class="card profileCard">
        <div class="card-header cardHeader">반려견과 함께 여행을 떠나보세요</div>
        <div class="card-body profile">
          <img src="./images/icon/person.png" alt="">
          <button class="btn btn-outline-primary makePlanBtn">여행계획 만들기</button>
        </div>
      </div>
    </section>



    <section class="weather-container">
      <div class="weathers">
      
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>

          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
          <div class="card" style="width: 10rem">
            <img src="./images/weathers/sunny.png" class="card-img-top" alt="..." id="weather-icon"/>
            <div class="card-body">
              <p class="card-text">
                  <h5>07. 01 (월)</h5>
                  <h6> 27°C</h6>
              </p>
            </div>
          </div>
        
        </div>
    </section>

    <footer>
      <ul class="footer-list">
        <li><a href="#">개인정보 처리방침</a></li>
        <li><a href="#">이용 약관</a></li>
        <li><a href="#">오시는 길</a></li>
        <li>&copy; SSAFY</li>
      </ul>
    </footer>

  <script src="./js/index.js"></script>
  </body>
</html>
