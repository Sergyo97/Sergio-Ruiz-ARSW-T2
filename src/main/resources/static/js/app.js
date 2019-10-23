app = (function () {
	var map;
	var marker;
	return {
		initMap: function () {
			map = new google.maps.Map(document.getElementById('map'), {
				//4.782808, -74.041624
				center: { lat: 4.782808, lng: -74.041624 },
				zoom: 16
			});
		},
		getAirportCity: function () {
			var city = $('#input').val();
			console.log(city)
			return airportApp.getAirportByName(city, function (city) {
				console.log(city);
				var x = JSON.parse(city);
				var table = $("#tableInfo");
				$("#tableInfo > tr").remove();
				table.append('<tr>' +
					"<td>" + x.main.airportId + "</td>" +
					"<td>" + x.main.name + "</td>" +
					"<td>" + x.main.city + "</td>" +
					"<td>" + x.main.cityId + "</td>" +
					"</tr>");
			})
		}
	}
})();