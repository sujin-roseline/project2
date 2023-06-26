<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="gourmetcss/gourmet.css">
<script type="text/javascript" src="gourmetjs/gourmet.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=85af9840b8713b35481bb6ab8c998933&libraries=services"></script>
</head>
</head>
<body>

	<div class="container">
		<!-- gourmetResult의 전체 container -->
		<div class="sj-viewcontainer" style="display: flex;">
			<!-- 결과와 지도를 묶는 div -->
			<div class="sj-result">
				<!-- 결과 뷰잉 div -->
				<c:forEach var="g" items="${gourmetInfos }">
					<div style="border: 1px solid black; width: 300px">
						<br>${g.name }<br>
						<br><span style="display: none;">${g.id }</span><br>
						${g.tel }<br> ${g.addr }<br> <br> ${g.menu }<br>


						<input id="addr" name="addr" hidden="" value="${g.addr}">
						<input name="input" hidden="" value="${select}"> <input
							name="select" hidden="" value="${input}">

						<button onclick="mapMake('${g.addr }','${g.name }','${g.img }')">Map</button>
						
						<form action="GourmetReviewC">
						<input name="inputId" hidden="" value="${g.id }">
						<button>Review</button>
						</form>
						
						
						
						<button onclick="sjOpenReview()">Review</button>

						
					</div>
				</c:forEach>
			</div>
			<!-- 결과 뷰잉 페이지 div 끝 -->

			<div>
				<!-- 지도 뷰잉 페이지 div -->
				<!-- 지도를 표시할 div 입니다 -->
				<div id="map" style="width: 950px; height: 500px; margin-right: auto"></div>
				<img id="markerImage" src="" style="width: 0px; height: 0px; display: none;">
			</div>
			<!-- 지도 뷰잉 페이지 div 끝-->
		</div>
		<!-- 결과와 지도를 묶는 div 끝 -->


		<!-- 리뷰 모달창 -->
		<div id="sjReview" class="sj-review">
			<div class="sj-review-content">
				<span onclick="sjCloseReview()" class="sj-close">&times;</span>
				<h2>Review</h2>
				<button onclick="sjOpenReviewWrite()">Write</button>
				<p>
					<table>
						<tr>
							<td>이미지</td>
						</tr>
						<tr>
							<td>제목</td>
						</tr>
						<tr>
							<td>작성자</td>
						</tr>
						<tr>
							<td>평점</td>
						</tr>
						<tr>
							<td>내용</td>
						</tr>
						<tr>
							<td><button onclick>Modify</button></td><td><button>Delete</button></td>
						</tr>
					</table>
				</p>
			</div>
		</div>
		<!-- 리뷰 모달창 끝 -->

		<!-- 리뷰 작성 모달 창 -->
		<div id="sjReviewWrite" class="sj-review-write">
			<div class="sj-review-content-write">
				<span onclick="sjCloseReviewWrite()" class="sj-close">&times;</span>
				<h2>리뷰를 작성해주세요!</h2>
				<p>
				
				<table>
				<form>
					<tr>
						<td>평점</td>
						<td><select name=sj-reviewGrade>
								<option>★</option>
								<option>★★</option>
								<option>★★★</option>
								<option>★★★★</option>
								<option>★★★★★</option>
						</select></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="sj-r_text" rows="10" cols="70"></textarea></td>
					</tr>
					<tr>
						<td>추천메뉴</td>
						<td><textarea name="sj-r_text" rows="10" cols="70"></textarea></td>
					</tr>
					<tr>
						<td>사진</td>
						<td><input name="sj-r_pic" type="file"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input name="sj-r_pw"></td>
					</tr>
					<tr>
						<td><button onclick="GourmetReviewRegC">등록하기</button></td>
					</tr>
				</form>
				</table>

				</p>
				
			</div>
		</div>


	</div>
	<!-- container div 끝 -->

	</div>



</body>
</html>

