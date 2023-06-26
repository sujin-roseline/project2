function mapMake(place, name, img) {
	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(33.450701, 126.570667),
		level: 3
	};
	var map = new kakao.maps.Map(mapContainer, mapOption);

	var geocoder = new kakao.maps.services.Geocoder();

	geocoder.addressSearch(place, function(result, status) {
		if (status === kakao.maps.services.Status.OK) {
			console.log("검색 성공");
			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});
			// 마커이미지 표시							
			var markerImage = document.getElementById('markerImage');
			markerImage.src = img;
			markerImage.style.display = 'block';

			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;"><img src="' + markerImage.src + '" style="width:100%;height:auto;"><br>' + name + '</div>'
			});

			infowindow.open(map, marker);

			map.setCenter(coords);
		}
	});
}




/*리뷰 모달창*/
 function sjOpenReview() {
    var modal = document.getElementById("sjReview");
    modal.style.display = "block"; // 모달 창을 보이도록 설정
  }

  function sjCloseReview() {
    var modal = document.getElementById("sjReview");
    modal.style.display = "none"; // 모달 창을 숨김
  }

/*리뷰 작성 모달창*/
 function sjOpenReviewWrite() {
    var modal = document.getElementById("sjReviewWrite");
    modal.style.display = "block"; // 모달 창을 보이도록 설정
  }

  function sjCloseReviewWrite() {
    var modal = document.getElementById("sjReviewWrite");
    modal.style.display = "none"; // 모달 창을 숨김
  }










f