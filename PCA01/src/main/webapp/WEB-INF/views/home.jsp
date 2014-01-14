<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="js/validarCampo.js"></script>
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
				data : "a="+$("#n1").val()+"&b="+$("#n2").val()+"&operacion="+$(this).attr("id"),
				success : function(result) {
					$("#resultado").html(result);		
					console.log("Resultado:"+result);
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
		<td><input type="button" value="sumar" id="sumar" class="operacion">
		<input type="button" value="Restar" id="restar" class="operacion"> 
		<input type="button" value="Multiplicar" id="multiplicar" class="operacion"> 
		<input type="button" value="Dividir" id="dividir" class="operacion"></td>
		</tr>
		<tr>
		<td><div id="resultado" > </div></td>
		</tr>		
	</table>
	</form>
</body>
</html>