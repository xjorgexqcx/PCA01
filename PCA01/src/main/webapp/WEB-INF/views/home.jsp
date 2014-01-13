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
		$(".operacion").click(function(e) {
			e.preventDefault();
			$.ajax({			
				
				url : "${pageContext.request.contextPath}/operaciones",
				type : "POST",
				data : "a="+$("#n1").val("")+"&b="+$("#n2").val()+"&operacion="+$(this).attr("id"),
				success : function(result) {
					$("#resultado").val(result);					

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
		<td><input type="button" id="sumar" class="operacion"> Sumar
		<input type="button" id="restar" class="operacion"> Restar
		<input type="button" id="multiplicar" class="operacion"> Multiplicar
		<input type="button" id="dividir" class="operacion"> Dividir</td>
		</tr>
		<tr>
		<td>Resultado:<input id="resultado" type="text" readonly="readonly" > </td>
		</tr>
		
		
	</table>
	</form>
</body>
</html>