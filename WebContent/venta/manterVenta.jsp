<%@page import="py.edu.fpune.posgrado.entity.Venta"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Venta"%>
<%@page import="py.edu.fpune.posgrado.session.SessionVenta"%>
<%
	Venta venta = (Venta) request.getAttribute("object");
	if (venta == null) {
		venta = new Venta();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="registroProducto">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar Venta</title>
	
	<script type="text/javascript" src="./js/angular.js"> </script>
	
	<script type="text/javascript"> 
angular.module("registroProducto",[]); 
angular.module("registroProducto").controller("productoController",function( $scope,$http){ 
 	$scope.hola="Hola Angular Js"; 
 
	var cargarProductos=function(){
		$http.get("http://localhost:8080/lightsoft/productos.json").success(
		function(data,status){
			$scope.productos=data;
		
		}		
		
		);
		
		
	};
	
console.log("Ingrese en Angular");

}); 
 
</script> 
	
	<script type="text/javascript">
	
		function clean() {
			document.getElementById("newAction").value = "cleanNew";
			document.getElementById("form").submit();
		}

		function removeRecord(id) {
			if (confirm("Confirma a Exclusão?")) {
				document.getElementById("newAction").value = "remove";
				document.getElementById("form").submit();
			}
		}
		
		function validate() {
			if (document.getElementById("descripcion").value == "") {
				alert("Campo obrigatório!");
				document.getElementById("descripcion").focus();
				return false;
			}
			if (document.getElementById("fecha").value == "") {
				alert("Campo obligatorio!");
				document.getElementById("fecha").focus();
				return false;
			}else{
				console.log(document.getElementById("fecha").value);
				document.getElementById("fecha").value ==new Date(document.getElementById("fecha").value)
				console.log(document.getElementById("fecha").value);
			}
			return true;
		}
		
		function save() {
			if (validate()) {
				document.getElementById("newAction").value = "save";
				console.log(document.getElementById("form"));
				document.getElementById("form").submit();
			}
		}
		
		function goFind() {
			document.getElementById("newAction").value = "goFind";
			document.getElementById("form").submit();
		}
		
		function message() {
<%
	if (message != null) {
%>
		alert('<%=message.replace("\n"," ").replace("'","\"")%>');
<%
	}
%>
		}
	</script>	
</head>
<body onload="message();" ng-controller="productoController">
	<div class="titulo">Consultar Venta</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Venta"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Fecha:</div>
			<div class="divField"><input value="<%=(venta.getFecha()!= null) ? venta.getFecha(): ""%>" class="inputText" type="date" id="fecha" name="fecha" style="width:320px;" /></div>
			
			<div class="divLabel">Vehículo:</div>
			<div class="divField"><input value="<%=(venta.getVehiculo().getIdVehiculo() != null) ? venta.getVehiculo().getIdVehiculo() : ""%>" class="inputText" type="text" id="idVehiculo" name="idVehiculo" readonly/></div>			<div class="divLabel">Descripción:</div>
			<div class="divField"><input value="<%=(venta.getDescripcion()!= null) ? venta.getDescripcion() : ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>
				<div class="divLabel">Total Productos:</div>
			<div class="divField"><input value="<%=(venta.getTotalProd() != 0) ? venta.getTotalProd() : ""%>" class="inputText" type="number" id="totalProd" name="totalProd" style="width:320px;" /></div>
		<div class="divLabel">Total Servicios:</div>
			<div class="divField"><input value="<%=(venta.getTotalServ() != 0) ? venta.getTotalServ() : ""%>" class="inputText" type="number" id="totalServ" name="totalServ" style="width:320px;" /></div>
		
		<div class="divLabel">Vehiculo:</div>
			<div class="divField"><input value="<%=(venta.getVehiculo() != null) ? venta.getVehiculo().getIdVehiculo() : ""%>" class="inputText" type="number" id="vehiculo" name="vehiculo" style="width:320px;" /></div>
		
		<input value="<%=(venta.getVentaDetProductos() != null) ? venta.getVentaDetProductos() : ""%>" class="inputText" type="text" id="jsonServicioProducto" name="jsonServicioProducto" style="width:320px;" />
		
		</form>
		<div class="divButtons">
			<input type="button" class="button" value="Salvar" onclick="save();" />
			<input type="button" class="button" value="Limpiar" onclick="clean();" />
			<input type="button" class="button" value="Borrar" onclick="removeRecord();" />
			<input type="button" class="button" value="Volver" onclick="goFind();" />
		</div>
	</div>
	
	
	<div ng-bind="hola"></div>
	<table>
        <thead>
          <tr>
              <th ></th>
              <th>Item Name</th>
              <th>Item Price</th>
          </tr>
        </thead>

        <tbody>
          <tr >
            <td>Alvin</td>
            <td>Eclair</td>
            <td>$0.87</td>
          </tr>
          
        </tbody>
      </table>
	
	
	
	
	
</body>



</html>