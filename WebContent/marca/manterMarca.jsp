<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Marca"%>
<%@page import="py.edu.fpune.posgrado.session.SessionMarca"%>
<%
	Marca marca = (Marca) request.getAttribute("object");
	if (marca == null) {
		marca = new Marca();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar Marca</title>
	
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
	<div class="titulo">Consultar Marca</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Marca"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(marca.getIdMarca() != null) ? marca.getIdMarca() : ""%>" class="inputText" type="text" id="idMarca" name="idMarca" readonly/></div>
			<div class="divLabel">Descripción:</div>
			<div class="divField"><input value="<%=(marca.getDescripcion() != null) ? marca.getDescripcion() : ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>
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