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

<h1>주말에 풀어보기</h1>

<div>
  <div>
    <select id="number" name="number" size="100">
      <option value="10">10</option>
      <option value="20">20</option>
      <option value="30">30</option>
      <option value="40">40</option>
      <option value="50">50</option>
      <option value="60">60</option>
      <option value="70">70</option>
      <option value="80">80</option>
      <option value="90">90</option>
      <option value="100">100</option>
    </select>  
  </div>
  <div>
    <input type="radio" name="select" value="Similarity" checked>유사도순
    <input type="radio" name="select" value="day" >날짜순
    <input type="radio" name="select" value="cheap" >낮은가격순
    <input type="radio" name="select" value="expensive">높은가격순
  </div>
  
</div>

</body>
</html>