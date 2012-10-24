<%@ page isELIgnored ="false" pageEncoding="UTF-8" %> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<?xml version='1.0' encoding='UTF-8'?>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <title>Diego A. Turchak - Jonatan K&ouml;lbl</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>

  <body class="preview" data-spy="scroll" data-target=".subnav" data-offset="50">
	<div id="header" class="page-header">
        <div class="container">
            <div id="logo">
            	<h1>Trabajo Pr&aacute;ctico nÂº2</h1>
            </div>
            <div id="complement-header"><h1>Turchak Diego A. - Jonatan K&ouml;lbl <br /> Trabajo Pr&aacute;ctico nn&deg;2</h1></div>
        </div>
    </div>
	<div id="modals" class="modal hide fade in" style="display:none;">
		<div class="modal-header">
        	<a class="close" data-dismiss="modal">x</a>
        	<h1>VENTA</h1>
		</div>  
        <div class="modal-body"> 
        	<div id="isRobotSale" class=""></div> 
		  <table class="table table-bordered table-striped">
			<thead>
			  <tr>
				<th>Atributos</th>
				<th>valor</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td></td>
				<td></td>
			  </tr>
			  <tr>
				<td></td>
				<td></td>
			  </tr>
			</tbody>
		  </table>
        </div>
        <div class="modal-footer">  
			<a class="btn btn-info btn-large" href="#"><i class="icon-random icon-white"></i> Aceptar</a>
			<a id="confirmarVenta" class="btn btn-info btn-large closemodal" href="#"><i class="icon-random icon-white"></i> Cancelar</a>
		</div>
	</div>
	
	<div id="modals-fight" class="modal hide fade in" style="display:none;">
		<div class="modal-header">
        	<a class="close" data-dismiss="modal">x</a>
        	<h1></h1>
		</div>  
        <div class="modal-body">
			<div class="vsrobots"></div>
        </div>
        <div class="modal-footer">  
			<a class="btn btn-success btn-large" id="luchar" href="#"><i class="icon-random icon-white"></i>Inicia la lucha</a>
			<a class="btn btn-warning btn-large closemodal" href="#"><i class="icon-random icon-white"></i>Estas arrepentido?</a>
		</div>
	</div>
	<div id="modals-message" class="modal hide fade in" style="display:none;">
		<div class="modal-header">
        	<a class="close" data-dismiss="modal">x</a>
        	<h1>Tienes un mensaje del Sistema.</h1>
		</div>  
        <div class="modal-body">
			<div class="messageuser">
				<p class="message"></p>
				<p align="right" style="">
					<img width="79" height="100" alt="91-mechw2.gif (10947 bytes)" src="img/robot-2.gif">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<img width="73" height="100" alt="91-robw2.gif (15645 bytes)" src="img/robot-1.gif">
				</p>
			</div>
        </div>
        <div class="modal-footer"> 
			<p align="center" class="text-info"><strong>Recuerda que puedes ser miembro exclusivo de Robots, y obtener estos nuevos androides.</strong><br /><button id="membership-suscribe" class="btn btn-warning">Suscribite</button></p>
		</div>
	</div>

<div class="navbar navbar-fixed-top">
   <div class="navbar-inner">
     <div class="container">
       <a class="brand" href="../">Diego A. Turchak- Jonatan K&ouml;lbl</a>
       <div class="nav-collapse" id="main-menu">
       </div>
     </div>
   </div>
  </div>

  <div class="container">
	<section class="micuenta">
		<div class="page-header">
			<h1>${player.nombre}</h1>
		</div>
		<div class="saldo"><strong>Saldo</strong> : $&nbsp; ${player.dinero}</div>
	</section>
    <section class="misrobots">
      <div class="page-header">
        <h1>MIS ROBOTS</h1>
      </div>
	  <div class="selectionRobot"></div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Poder</th>
						<th>Nivel De Deterioro</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${player != null}">
						<h2>Respuestas:</h2>
						<c:forEach items="${player.misRobots}" var="robot"
							varStatus="status">
							<tr id="${robot.id}" class="${status.count}">
								<td>${robot.nombreRobot}</td>
								<td>${robot.poder}</td>
								<td>${robot.nivelDeDeterioro}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</section>
    <a id="vender" data-toggle="modal"  class="btn btn-warning btn-large" href="#"><i class="icon-shopping-cart icon-white"></i> Vender</a>

    <section class="contrincantes">
      <div class="page-header">
        <h1>Contrincantes</h1>
      </div>
	  <div class="selectionRobot"></div>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Poder</th>
						<th>Nivel De Deterioro</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${player != null}">
						<h2>Respuestas:</h2>
						<c:forEach items="${player.misContrincantes}" var="robot"
							varStatus="status">
							<tr id="${robot.id}">
								<td>${robot.nombreRobot}</td>
								<td>${robot.poder}</td>
								<td>${robot.nivelDeDeterioro}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</section>
    <a class="btn btn-info btn-large" id="competir" href="#"><i class="icon-random icon-white"></i> Competir</a>
    

  </div><!-- /container -->
		    <hr>
			<footer>
				<div class="container">
					<p align="center"><img width="37" height="75" alt="&copy; UNQ TPI 2012" src="img/robot-footer.gif">&copy; UNQ TPI 2012 </p>
				</div>
			</footer>


    <!-- Le javascript
    ================================================== -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="./js/bootstrap_modal.js"></script>
  	<script type="text/javascript">
		$("#vender").click(function(e){
			if(choiceRobotForSale()){
				$("#modals").modal();
				$("#isRobotSale").attr("class",$(".misrobots tr.selectedRobot").attr("id"));
			}
			else{
				populateMessage("NO has elegido ning&uacute;n robot para la venta!");
			}
		})
		$("#comprar").click(function(e){
			if(userChoiceForBuy()){
				$("#").modal();
			}
		})
		
		$("#confirmarVenta").click(function(e){
			$.ajax({
				type : "POST",
				url : "venta",
				data : "id="+$("#isRobotSale").attr("class"),
				success : function(){
					populateMessage("NO has elegido ning&uacute;n robot para la venta!");
				}
			});	
		})
		
		$("#competir").click(function(e){
			if(userChoiceRobots()){
				$("#modals-fight").modal();
			}
			else{
				populateMessage("Debes elegir 2 robots para la gran pelea!!!");
			}
		})
		$(".closemodal").click(function(e){
			e.preventDefault();
			$("#modals").modal("hide");
			$("#modals-fight").modal("hide");
		})
		
		function choiceRobotForSale(){
			return $(".misrobots tr.selectedRobot").length>0;
		}
		function choiceRobotForBuy(){
			return $(".");
		}
		function userChoiceRobots(){
			var puedeCompetir = true;
			if(!($(".contrincantes tr.selectedRobot").length>0&&$(".misrobots tr.selectedRobot").length>0)){
				puedeCompetir = false;
			}
			return puedeCompetir;
		}
		function sendDataForCompetition(){
			$.ajax({
				type : "POST",
				url : "competition",
				data : "usuario=42&contrincante="+$(".contrincantes tr.selectedRobot").attr("id")+"&mirobot="+$(".misrobots tr.selectedRobot").attr("id"),
				success : function(){
					populateMessage("La respuesta it's comming!!!");
				}
			});
		}
		function loadRobotForSale(){
				
		}
		
		function populateMessage(aMessage){
			$("#modals-message .modal-body .messageuser .message").html(aMessage);
			$("#modals-message").modal();
		}
		$("#luchar").click(function(e){
			e.preventDefault();
			if(userChoiceRobots()){
				sendDataForCompetition();
			}
			else{ alert("Debes Elegir los Robots!!!");$('#modals-fight').modal("hide");}
		})
		function selectedRobot(someRobot){
			if($(this).hasClass("selectRobot")){
				$(this).removeClass("selectedRobot");
				$("img").remove(".selected"+$(this).attr("id"));
				$(this).children().css({"background-color":"white","color":"#333"});
			}else{
				$(this).addClass("selectedRobot");
				$(this).children().first().prepend('<img class="selected'+$(this).attr("id")+'" width="27" height="45" alt="" src="img/selected-robot.gif">');
				$(this).children().css({"background-color":"#5BB707","color":"white"});
			}
		}
		
		$("tbody tr").click(function(e){
			var collectionRobots = $(this).siblings();
			console.log(collectionRobots);
			if($(this).hasClass("selectedRobot")){
				$(this).removeClass("selectedRobot");
				$("img").remove(".selected"+$(this).attr("id"));
				$(this).children().css({"background-color":"white","color":"#333"});
			}else{
				$(this).siblings().each(function(item){
					console.log($(this).attr("id"));
					if($(this).hasClass("selectedRobot")){
						$(this).removeClass("selectedRobot");
						$("img").remove(".selected"+$(this).attr("id"));
						$(this).children().css({"background-color":"white","color":"#333"});
					}
				});
				$(this).addClass("selectedRobot");
				$(this).children().first().prepend('<img class="selected'+$(this).attr("id")+'" width="27" height="45" alt="" src="img/selected-robot.gif">');
				$(this).children().css({"background-color":"#5BB707","color":"white"});
			}
		})

	</script>
  </body>
</html>
