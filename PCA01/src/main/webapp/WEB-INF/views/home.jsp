<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
</head>
<script type="text/javascript">


	$(document).ready(function() {
		//metodo para registrarse como usuario normal 
		$(".operacion").click(function(e) {
			e.preventDefault();
			$.ajax({			
				
				url : "${pageContext.request.contextPath}/operaciones",
				type : "POST",
				data : "a="+$("#n1").val()+"&b="+$("#n2").val()+"&operacion="+$(this).attr("id"),
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
			<td>N1<input type="text" id="n1"> 
			N2<input type="text" id="n2"> </td>
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