app = (function () {
	var map;
	var markers;
	return {
		initMap: function () {
			map = new google.maps.Map(document.getElementById('map'), {
				//4.782808, -74.041624
				center: { lat: 4.782808, lng: -74.041624 },
				zoom: 16
			});
		},
		getAirportCity: function () {
			var city = $('#city').val();
			console.log(city)
			axios.get("/airport", {
				params: {
					city: city
				}
			})
				.then(response => {
					mydata = response.data;
					console.log(mydata)
					$("#tableInfo tbody").empty();
					mydata.forEach(airport => {
						$('#tableInfo tbody').append(`
            <tr>
                <td>` + airport.airportId + `</td>    
                <td>` + airport.name + `</td>
                <td>` + airport.city + `</td>
                <td>` + airport.cityId + `</td>
            </tr>
		`)
						var latitud = airport.location.latitude
						var longitud = airport.location.longitude
						var cambiaaaa = new google.maps.LatLng(latitud, longitud);
						map.setCenter(cambiaaaa);
						var marker = new google.maps.Marker({
							position: cambiaaaa
						});
						marker.setMap(map);
					});
				})
				.catch(function (error) {
					console.log(error);
				})
		}
	}
})();