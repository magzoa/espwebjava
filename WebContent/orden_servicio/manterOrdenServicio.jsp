<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.OrdenServicio"%>
<%@page import="py.edu.fpune.posgrado.session.SessionOrdenServicio"%>
<%
	OrdenServicio ordenServicio = (OrdenServicio) request.getAttribute("object");
	if (ordenServicio == null) {
		ordenServicio = new OrdenServicio();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar OrdenServicio</title>
	
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
	<div class="titulo">Consultar OrdenServicio</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="OrdenServicio"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(ordenServicio.getIdOrdenServicio() != null) ? ordenServicio.getIdOrdenServicio() : ""%>" class="inputText" type="text" id="idOrdenServicio" name="idOrdenServicio" readonly/></div>
			<div class="divLabel">Descripción:</div>
			<div class="divField"><input value="<%=(ordenServicio.getDescripcion() != null) ? ordenServicio.getDescripcion() : ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>
		<div class="divLabel">Fecha:</div>
			<div class="divField"><input value="<%=(ordenServicio.getFecha() != null) ? ordenServicio.getFecha() : ""%>" class="inputText" type="text" id="fecha" name="fecha" style="width:320px;" /></div>
		<div class="divLabel">Total Productos:</div>
			<div class="divField"><input value="<%=(ordenServicio.getTotalProd() != 0) ? ordenServicio.getTotalProd() : ""%>" class="inputText" type="number" id="total_prod" name="total_prod" style="width:320px;" /></div>
		<div class="divLabel">Total Servicios:</div>
			<div class="divField"><input value="<%=(ordenServicio.getTotalServ() != 0) ? ordenServicio.getTotalServ() : ""%>" class="inputText" type="number" id="total_serv" name="total_serv" style="width:320px;" /></div>
		
		
		
		
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