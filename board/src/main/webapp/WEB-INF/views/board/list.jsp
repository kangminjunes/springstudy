<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<style>
  .board {
    width: 300px;
    border: 1px solid gray;
    cursor: pointer;
  }
</style>
</head>
<body>

<script>
  $(function(){
    fnAddResult();
    $('.board').click((ev) => {
      // 클릭한 대상 : 이벤트 대상 (이벤트 객체의 target 속성)
      let boardNo = $(ev.currentTarget).data('board_no');
      location.href = '${contextPath}/detail.do?boardNo=' + boardNo;
    });
  });

  function fnAddResult(){
    var addResult = '${addResult}';
    if(addResult !== ''){
      if(addResult === '1'){
        alert('정보가 등록되었습니다.');
      } else {
        alert('정보 등록이 실패했습니다.');
      }
    }
  }
  
  const removeResult = '${removeResult}';  // '', '1', '0'
  if(removeResult !== ''){
  	if(removeResult === '1'){
  		alert('삭제 성공');
  	} else {
  		alert('삭제 실패');
  	}
  }
</script>

<div>
  <a href="${contextPath}/board/write.do">새연락처등록</a>
</div>

<h1>목록보기</h1>

<h3>전체개수 : ${total}</h3>
<c:forEach items="${boardList}" var="board">
  <div class="board" data-board_no="${board.boardNo}">
    <div>${board.boardNo}</div>
    <div>${board.title}</div>
  </div>
</c:forEach>

<div class="paging">${paging}</div>

</body>
</html>
