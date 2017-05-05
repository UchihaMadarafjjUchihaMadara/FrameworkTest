/**
 * 
 */

$(document).on("click", "#submit1", function(){
	var username = $("#inputUsername1").val();
	var password = $("#inputPassword1").val();
	
	$.ajax({
		url: "http://localhost:8080/login.do",
		type: "POST",
		data: {
			"username": username,
			"password": password
		},
		success: function(result){
			var json = jQuery.parseJSON(result);
			if(json['code'] == 10000){
				window.location.href = "/index";
			} else {
				alert(json['msg']);
			}
		},
		error: function(){
			
		}
	});
});