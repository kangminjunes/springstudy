<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

  <h1>상세보기</h1>
  
  <form id="frm_detail" method="post" action="${contextPath}/modify.do">
    <div>게시글 번호 : ${board.boardNo}</div>
    <div>작성자 : ${board.writer}</div>
    <div>제목 : <input type="text" name="title" value="${board.title}" required></div>
    <div>내용 : <input type="text" name="contents" value="${board.contents}"></div>
    <div>작성일 : ${board.createdAt}</div>
    <div>수정일 : ${board.modifiedAt == null ? '없음' : board.modifiedAt}</div>
    <input type="hidden" name="boardNo" value="${board.boardNo}">
    <button type="submit" id="btn_modify">수정</button>
    <button type="button" id="btn_remove">삭제</button>
  </form>


  <script>
    var frmDetail = $('#frm_detail');

    // 수정
    $('#btn_modify').click(() => {
      frmDetail.submit();
    });

    const modifyResult = '${modifyResult}';  // '', '1', '0'
    if (modifyResult !== '') {
      if (modifyResult === '1') {
        alert('수정 성공');
      } else {
        alert('수정 실패');
      }
    }
    
    $('#btn_remove').click(() => {
    	if(confirm('삭제할까요?')){
    		frmDetail.attr('action', '${contextPath}/remove.do');
    		frmDetail.submit();
    	}
    })


  </script>

</body>
</html>
