<%@page import="py.edu.fpune.posgrado.entity.Funcionario"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Funcionario"%>
<%@page import="py.edu.fpune.posgrado.session.SessionFuncionario"%>
<%
	//Funcionario
	Funcionario funcionario = (Funcionario) request.getAttribute("object");
	if (funcionario == null) {
		funcionario = new Funcionario();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Editar Funcionario</title>
	
	<script type="text/javascript">
	
		function clean() {
			document.getElementById("newAction").value = "cleanNew";
			document.getElementById("form").submit();
		}

		function removeRecord(id) {
			if (confirm("Confirma el borrado?")) {
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
	<div class="titulo">Editar Funcionario</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Funcionario"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(funcionario.getId() != null) ? funcionario.getId() : ""%>" class="inputText" type="text" id="id" name="id" readonly/></div>
			<div class="divLabel">Nombre:</div>
			<div class="divField"><input value="<%=(funcionario.getNombre() != null) ? funcionario.getNombre() : ""%>" class="inputText" type="text" id="nombre" name="nombre" style="width:320px;" /></div>
			<div class="divLabel">CI/RUC:</div>
			<div class="divField"><input value="<%=(funcionario.getRuc() != null) ? funcionario.getRuc() : ""%>" class="inputText" type="text" id="ruc" name="ruc" style="width:320px;" /></div>
			<div class="divLabel">Ciudad:</div>
			<div class="divField"><input value="<%=(funcionario.getCiudad() != null) ? funcionario.getCiudad() : ""%>" class="inputText" type="text" id="ciudad" name="ciudad" style="width:320px;" /></div>
			<div class="divLabel">Barrio:</div>
			<div class="divField"><input value="<%=(funcionario.getBarrio() != null) ? funcionario.getBarrio() : ""%>" class="inputText" type="text" id="barrio" name="barrio" style="width:320px;" /></div>
			<div class="divLabel">Direccion:</div>
			<div class="divField"><input value="<%=(funcionario.getDireccion() != null) ? funcionario.getDireccion() : ""%>" class="inputText" type="text" id="direccion" name="direccion" style="width:320px;" /></div>
			<div class="divLabel">Fecha Nac.:</div>
			<div class="divField"><input value="<%=(funcionario.getFechaNacimiento() != null) ? funcionario.getFechaNacimiento() : ""%>" class="inputText" type="text" id="fechaNacimiento" name="fechaNacimiento" style="width:320px;" /></div>
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