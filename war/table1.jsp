<html>
<head>

</head>
<body>
	<h1>This is an example of ajax</h1>
		<input type="text" id="name"> <input type="password" id="pwd">
		<input type="submit" value="ShowTable" id="submit">


	<p id="demo">hi everyone</p>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#submit").click(function() {
				var name = $("#name").val();

				var password = $('#pwd').val();
				var obj = {
					"name" : name,
					"password" : password
				};
				var x=JSON.stringify(obj);
				$.ajax({
					url : "/insert",
					type : 'POST',
					headers : {
						'Accept':'application/json',
						'Content-Type' : 'application/json'
					},
					data : x,
					contentType : "application/json",
				//	dataType : "Text",
					
					success : function(response) {
						var ans = response;
						debugger;
						/*    $('#demo').html(); */
						alert(ans.name);
					},
					error : function() {
						debugger;
						//   alert('Error while request..');
					}
				});
			});
		});
	</script>

</body>
</html>