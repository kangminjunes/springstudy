<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
</head>
<body>

<h1>작성화면</h1>

<div>
  <form id="frm_add" method="post" action="${contextPath}/add.do">
    <div><input type="text" name="writer" id="writer" placeholder="작성자"></div>
    <div><input type="text" name="title" id="title" placeholder="제목"></div>
    <div><input type="text" name="contents" id="contents" placeholder="내용"></div>
    <div><button type="submit">등록하기</button></div>
  </form>
</div>

<script>
  $('#frm_add').submit((ev) => {
    let title = $('#title');
    if(title.val() === ''){
      alert('제목은 필수입니다.');
      title.focus();
      ev.preventDefault();
      return;
    }
  });

  // 등록 결과에 따라 메시지 표시
  $(function(){
    fnAddResult();
  });

  function fnAddResult(){
    var addResult = '${addResult}';
    if(addResult !== ''){
      if(addResult === '1'){
        alert('정보가 성공적으로 등록되었습니다.');
      } else {
        alert('정보 등록에 실패했습니다.');
      }
    }
  }
</script>

</body>
</html>
