<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Producto"%>
<%@page import="py.edu.fpune.posgrado.session.SessionProducto"%>
<%
	Producto producto = (Producto) request.getAttribute("object");
	if (producto == null) {
		producto = new Producto();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar Producto</title>
	
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
			if (document.getElementById("nombre").value == "") {
				alert("Campo obrigatório!");
				document.getElementById("nombre").focus();
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
	<div class="titulo">Consultar Producto</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Producto"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(producto.getId() != null) ? producto.getId() : ""%>" class="inputText" type="text" id="id" name="id" readonly/></div>
			<div class="divLabel">Descripcion:</div>
			<div class="divField"><input value="<%=(producto.getDescripcion() != null) ? producto.getDescripcion(): ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>
			<div class="divLabel">Cantidad:</div>
			<div class="divField"><input value="<%=(producto.getCantidad() != null) ? producto.getCantidad() : ""%>" class="inputText" type="text" id="cantidad" name="cantidad" style="width:320px;" /></div>
			<div class="divLabel">Valor:</div>
			<div class="divField"><input value="<%=(producto.getValor() != null) ? producto.getValor() : ""%>" class="inputText" type="text" id="valor" name="valor" style="width:320px;" /></div>
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