airportApp=(function(){
	return {
		getAirportByName:function(name,callback){
			console.log(name);
			$.ajax({
			    type: "GET",  
			    url: "airport/" + name ,
			    success: callback,
			    error: function(XMLHttpRequest, textStatus, errorThrown) { 
			        alert("Status: " + textStatus); alert("Error: " + errorThrown); 
			    }       
			});
		}
	}
})();