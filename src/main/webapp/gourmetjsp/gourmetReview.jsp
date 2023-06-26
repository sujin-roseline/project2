<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="GourmetReviewC">
<table>
	<tr>
		<td>Review</td>
	</tr>
	<tr>
		<td>평점</td>
		<td><select name=sj-reviewGrade> 
				<option>★</option>
				<option>★★</option>
				<option>★★★</option>
				<option>★★★★</option>
				<option>★★★★★</option>
			</select> 
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea name="sj-r_text" rows="10" cols="100"></textarea></td>
	</tr>
	<tr>
		<td>추천메뉴</td>
		<td><textarea name="sj-r_text" rows="10" cols="100"></textarea></td>
	</tr>
	<tr>
		<td>사진</td>
		<td><input name="sj-r_pic" type="file"></td>
	</tr>
</table>
</form>

</body>
</html>