<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<script type="text/javascript">


	$(document).ready(function() {
		
		$('#n1').validarCampo('0123456789');
		$('#n2').validarCampo('0123456789');
		

		//metodo para registrarse como usuario normal 
		$("#sumar").click(function(e) {
			e.preventDefault();
			$.ajax({			
				
				url : "${pageContext.request.contextPath}/operaciones",
				type : "POST",
				data : JSON.stringify($("#form").serializeObject()),
				contentType : "application/json",
				success : function(result) {
							console.log("Result=>"+result.estado);
							
							if (result.estado == "ok") {
								$('#rpta1').val("");
								
							} else if(result.estado == "vacios") {
							
								$('#usuario').val("");
								$('#clave').val("");
								$('#rclave').val("");
								//jAlert('Error el usuario y la clave no pueden ser vacios', 'Error');
								alertify.error('Error el usuario y la clave no pueden ser vacios');
							}else if(result.estado == "correo"){
								
								$('#email').val("");
								//jAlert('Error ingrese un correo valido', 'Error');
								alertify.error('Error ingrese un correo valido');
							}else if (result.estado == "clave"){
								
								$('#clave').val("");
								$('#rclave').val("");
								//jAlert('Error las contrase&ntilde;as no coinciden', 'Error');
								alertify.error('Error las contrase&ntilde;as no coinciden');
							}else if (result.estado == "ruc"){
								
								$('#ruc').val("");
								//jAlert('Error el RUC debe tener 11 caracteres', 'Error');
								alertify.error('Error el RUC debe tener 11 caracteres');
							}else if(result.estado == "dni"){
								$('#dni').val("");
								//jAlert('Error el DNI no debe estar vacio y debe tener 8 caracteres', 'Error');
								alertify.error('Error el DNI no debe estar vacio y debe tener 8 caracteres');
							}else{

								$('#usuario').val("");
								$('#clave').val("");
								$('#rclave').val("");
								//jAlert('Error el usuario ya existe', 'Registro');
								alertify.error('Error el usuario ya existe');

							}

				}, error : function(a, b, c) {
					console.log("Ocurrio un error " + a.status + " " + b);
				}
				
			});
			
		});
		
	});
</script>

<body>
	<center>
		<h1>Calculadora fatal</h1>
	</center>
		<form action="#" id="form">
	<table align="center">
		<tr>
			<td>N1<input type="text"> 
			N2<input type="text"> </td>
		</tr>
		<tr>
		<td><input type="button"> Sumar
		<input type="button" > Restar
		<input type="button"> Multiplicar
		<input type="button"> Dividir</td>
		</tr>
		<tr>
		<td>Resultado:<input type="text" readonly="readonly" > </td>
		</tr>
		
		
	</table>
	</form>
</body>
</html>