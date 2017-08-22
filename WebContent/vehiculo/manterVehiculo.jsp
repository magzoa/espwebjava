<%@page import="py.edu.fpune.posgrado.entity.Marca"%>
<%@page import="py.edu.fpune.posgrado.session.SessionMarca"%>
<%@page import="py.edu.fpune.posgrado.entity.Cliente"%>
<%@page import="py.edu.fpune.posgrado.session.SessionCliente"%>
<%@page import="py.edu.fpune.posgrado.session.SessionModelo"%>
<%@page import="py.edu.fpune.posgrado.entity.Modelo"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Vehiculo"%>
<%@page import="py.edu.fpune.posgrado.session.SessionVehiculo"%>
<%
	Vehiculo vehiculo = (Vehiculo) request.getAttribute("object");
	if (vehiculo == null) {
		vehiculo = new Vehiculo();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Mantener Vehículo</title>
	
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
			var placa 	= document.getElementById("placa").value;
			var color 	= document.getElementById("color").value;
			var anho	= document.getElementById("anho").value;
			var modelo 	= document.getElementById("modelo").value;
			var cliente = document.getElementById("cliente").value;
			
			if (
					document.getElementById("placa").value 	== "" || 
					document.getElementById("color").value 	== "" || 
					document.getElementById("anho").value 	== "" || 
					document.getElementById("modelo").value == "" || 
					document.getElementById("cliente").value== "" 
					) {
				alert("Todos Campos obrigatórios!");
				if( placa == null || placa.length == 0 || /^\s+$/.test(placa) ) {
					document.getElementById("placa").style.border = "thick solid red";
				} else { document.getElementById("placa").style.border = "none" }
				if( cor == null || cor.length == 0 || /^\s+$/.test(cor) ) {
					document.getElementById("color").style.border = "thick solid red";
				} else { document.getElementById("color").style.border = "none" }
				if( ano == null || ano.length == 0 || /^\s+$/.test(ano) ) {
					document.getElementById("anho").style.border = "thick solid red";
				} else { document.getElementById("anho").style.border = "none" }
				
				if( modelo == null || modelo.length == 0 || /^\s+$/.test(modelo) ) {
					document.getElementById("modelo").style.border = "thick solid red";
				} else { document.getElementById("modelo").style.border = "none" }
				if( cliente == null || cliente.length == 0 || /^\s+$/.test(cliente) ) {
					document.getElementById("cliente").style.border = "thick solid red";
				} else { document.getElementById("cliente").style.border = "none" }

				//document.getElementById("descripcion").focus();
				return false;
			}
			return true;
		}
		
		function save() {
			if (validate()) {
				document.getElementById("newAction").value = "save";
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

<body onload="message();">
	<div class="titulo">Mantener Vehículo</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Vehiculo"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(vehiculo.getIdVehiculo() != null) ? vehiculo.getIdVehiculo() : ""%>" class="inputText" type="text" id="idVehiculo" name="idVehiculo" readonly/></div>
			<div class="divLabel">Placa:</div>
			<div class="divField"><input value="<%=(vehiculo.getPlaca() != null) ? vehiculo.getPlaca() : ""%>" class="inputText" type="text" id="placa" name="placa" style="width:320px;" /></div>
			<div class="divLabel">Color:</div>
			<div class="divField"><input value="<%=(vehiculo.getColor() != null) ? vehiculo.getColor() : ""%>" class="inputText" type="text" id="color" name="color" style="width:320px;" /></div>
			<div class="divLabel">Año:</div>
			<div class="divField"><input value="<%=(vehiculo.getAnho() != null) ? vehiculo.getAnho() : ""%>" class="inputText" type="text" id="anho" name="anho" style="width:320px;" /></div>

			<div class="divLabel">Modelo:</div>
			<div class="divField">
				<select id="modelo" name="modelo">
					<option value="" >Seleccione</option>
					<% 
					SessionModelo sessionModelo = new SessionModelo();
					Modelo modelo = new Modelo();
					Object list[] = sessionModelo.find(modelo);
					
					for(int i =0; i<list.length; i++){
						modelo = (Modelo) list[i];
						//out.print( marca+"<br>" );
					%>
					<option value="<%= modelo.getIdModelo() 
						%>" <% 
							if(vehiculo.getModelo() != null && vehiculo.getModelo().getIdModelo()==modelo.getIdModelo()){
								out.print("selected");
							}
							%>><%= modelo.getDescripcion() %></option>
					<%
					}
					%>
				</select>
			</div>
			<div class="divLabel">Cliente:</div>
			<div class="divField">
				<select id="cliente" name="cliente">
					<option value="" >Seleccione</option>
					<% 
					SessionCliente sessionCliente = new SessionCliente();
					Cliente cliente = new Cliente();
					list = sessionCliente.find(cliente);
					
					//out.print( list.length );
					for(int i =0; i<list.length; i++){
						cliente = (Cliente) list[i];
						//out.print( marca+"<br>" );
					%>
					<option value="<%= cliente.getId() 
						%>" <% 
							if(vehiculo.getCliente() != null && vehiculo.getCliente().getId()==cliente.getId()){
								out.print("selected");
							}
							%>><%= cliente.getNombre() %></option>
					<%
					}
					%>
				</select>
			</div>
		
		</form>               
		<div class="divButtons">
			<input type="button" class="button" value="Salvar" onclick="save();" />
			<input type="button" class="button" value="Limpiar" onclick="clean();" />
			<input type="button" class="button" value="Borrar" onclick="removeRecord();" />
			<input type="button" class="button" value="Volver" onclick="goFind();" />
		</div>
	</div>
</body>
</html>