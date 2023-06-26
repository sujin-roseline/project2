<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="gourmetcss/gourmet.css">
</head>
<body>

	<h2>구루메 인덱스 페이지</h2>
	<form action="GourmetSearchC" method="post">
		<select name="select">
			<option value="name">상호</option>
			<option value="location">위치</option>
		</select> 
			<input name="input"></input>
		<button>search</button>


	</form>
	<hr>
	<div style="display: flex;">
		<div>
			<jsp:include page="${contentPage }"></jsp:include></div>
		<div>
			<jsp:include page="${mapPage }"></jsp:include></div>

	</div>


</body>
</html>