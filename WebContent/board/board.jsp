<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Happy House</title>
    <link rel="stylesheet" href="./css/styles.css" />
    <link
      href="//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css"
      rel="stylesheet"
      type="text/css"
    />
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
          <span class="navplan"><a href="">나의 여행계획</a></span>
          <span class="navlog"><a href="board.html">여행기록</a></span>
        </div>
      </div>

      <div class="nav2 hide">
        <span class="navTitle navlogo"><a href="index.html">여행하 개'</a></span>
        <div>
          <span class="navplan"><a href="">나의 여행계획</a></span>
          <span class="navlog"><a href="board.html">여행기록</a></span>
          <span class="myPage">마이페이지</span>
          <span class="logout">로그아웃</span>
        </div>
      </div>
    </nav>

   
  <div class="table-content"> 
    <div class="tc tc1">
        <p class="tableTitle">여행 기록</p>

        <div class="logBtns">
          <input type="button" value="글쓰기" class="writeBtn">
          <div>
            <input type="text" placeholder="검색">
            <input type="button" value="검색">
          </div>
        </div>


        <table class="table">

            <tr>
                <th class="logNum"   >글번호</th>
                <th class="logTitle" >제목</th>
                <th class="logDate"  >작성일</th> 
                <th class="logCount" >조회수</th> 
                <th class="logWriter">작성자 </th>
            </tr>
            <tbody class="table-body">
              <tr>
                <td class="logNum"   >01</td>
                <td class="logTitle" >내가 가고싶다 여행</td>
                <td class="logDate"  >2023.09.08</td>
                <td class="logCount" >183</td>
                <td class="logWriter">김싸피</td>
            </tr>
  
            </tbody>
        </table>
    </div>
    <script src="./js/board.js"></script>
  </body>
</html>