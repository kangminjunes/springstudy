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
<script>
  
  $(function(){
    fnAddResult();
    fnDeleteResult();
  })
  
  function fnAddResult(){
    var addResult = '${addResult}';
    if(addResult !== ''){
      if(addResult === '1'){
        alert('연락처가 등록되었습니다.');
      } else {
      alert('연락처 등록이 실패했습니다.');
      }
    }
  }
  
  function fnDeleteResult(){
    var deleteResult = '${deleteResult}';
    if(deleteResult !== ''){
      if(deleteResult === '1'){
        alert('연락처가 삭제되었습니다.');
      } else {
      alert('연락처 삭제가 실패했습니다.');
      }
    }
  }
  
</script>
</head>
<body>

  <div>
    <h3>연락처관리</h3>
    <div>
      <a href="${contextPath}/contact/write.do">새연락처등록</a>
    </div>
    <table border="1">
      <thead>
        <tr>
          <td>번호</td>
          <td>이름</td>
          <td>전화번호</td>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${contactList}" var="c">
          <tr>
            <td>${c.contact_no}</td>
            <td><a href="${contextPath}/contact/detail.do?contact_no=${c.contact_no}">${c.name}</a></td>
            <td>${c.tel}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>

</body>
</html>