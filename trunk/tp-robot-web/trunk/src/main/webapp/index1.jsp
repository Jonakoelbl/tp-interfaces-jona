<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Tp2 Sesi</title>
		<link rel="stylesheet" type="text/css" href="styles.css" />
		<script language="javascript"><!--
			var id;
			var ajaxRequest = createAjaxRequest();

			function createAjaxRequest() {
				if (typeof XMLHttpRequest != "undefined") {
					return new XMLHttpRequest();
				} 
				else if (window.ActiveXObject) {
					return new ActiveXObject("Microsoft.XMLHTTP");
				}
			}

			function venderRobot(anIdRobot) {
				// Sin un objeto que maneje el estado es complicado redirigir al siguiente o al anterior
				// si bien en el request tengo la lista de libros, no es fácil generar un único link que vaya 
				// cambiando con el libro seleccionado, porque esa lista está en el servidor, no en el cliente,
				// salvo que la reciba y la trabaje del lado de javascript.
 				//document.getElementById("linkAnterior").style.display = esPrimero ? "none" : "";
				//document.getElementById("linkSiguiente").style.display = esUltimo ? "none" : "";
				id = nuevoId;
				var url = "ventaRobots.jsp?id=" + adIdRobot;

				ajaxRequest.open("POST", url, true);
				ajaxRequest.onreadystatechange = mostrarVentana;
				ajaxRequest.send(null);
			}

			function updateLibro() {
			    if (ajaxRequest.readyState == 4) {
			        if (ajaxRequest.status == 200) {
						document.getElementById("modal").innerHTML = ajaxRequest.responseText;
			        }
			        else {
			        	alert("No se pudieron obtener los detalles del libro " + id + "\n" + 
			        	      "Por un error: " + ajaxRequest.status + ajaxRequest.statusText);
			        }
			    }
			}
			
			function mostrarVentana(){
			    if (ajaxRequest.readyState == 4) {
			    	var ventana = document.getElementById(‘modal’);
			        if (ajaxRequest.status == 200) {
			        	ventana.innerHTML = ajaxRequest.responseText;
			    		ventana.style.marginTop = “100px”;
			    		ventana.style.left = ((document.body.clientWidth-350) / 2) +  “px”;
			    		ventana.style.display = ‘block’;
					}
			    }
			}
			function ocultarVentana(){
			    var ventana = document.getElementById(‘modal’);
			    ventana.style.display = ‘none’;
			}	
			
		--></script>	
	</head>
	<body>
	<div id=”modal”>
	</div>
	<c:if test="${sessionScope.libros != null}" >
		<h2>Respuestas:</h2>
		<table>
			<tr>
				<th>#</th>
				<th>Nombre Robot</th>
				<th>Poder de Ataque</th>
				<th>Nivel de Deterioro</th>
			</tr>
			<c:forEach items="${sessionScope.robots}" var="robot" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><a href="detalles.jsp?nro=${status.index}">${robot.poderAtaque}</a></td>
			    	<td>${robot.nivelDeterioro}</td>
			    </tr>
			</c:forEach>
		</table>
	</c:if> 
	<div id="btn_sell"><a href="javascript:venderRobot(${status.index});return false;">Vender</a></div>
	</body>
</html>
