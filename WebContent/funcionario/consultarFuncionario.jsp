<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Funcionario"%>
<%@page import="py.edu.fpune.posgrado.session.SessionFuncionario"%>
<%
	//Funcionario
	Funcionario funcionarioFilter = (Funcionario) request.getSession().getAttribute("filterFuncionario");
	if (funcionarioFilter == null) {
		funcionarioFilter = new Funcionario();
	}
	Object list[] = (Object[]) request.getAttribute("list");
	if (list == null) {
		list = new Object[0];
	}
	
	String message =  (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar Funcionario</title>
	
	<script type="text/javascript">
	
		function clean() {
			document.getElementById("newAction").value = "cleanFind";
			document.getElementById("form").submit();
		}
	
		function detail(id) {
			document.getElementById("id").value = id;
			document.getElementById("newAction").value = "detail";
			document.getElementById("form").submit();
		}

		function removeRecord(id) {
			if (confirm("Confirma a Exclusión?")) {
				document.getElementById("id").value = id;
				document.getElementById("newAction").value = "remove";
				document.getElementById("form").submit();
			}
		}
		
		function find() {
			document.getElementById("newAction").value = "find";
			document.getElementById("form").submit();
		}
		
		function goNew() {
			document.getElementById("newAction").value = "goNew";
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
	<div class="titulo">Consultar Funcionario</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Funcionario" />
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(funcionarioFilter.getId() != null) ? funcionarioFilter.getId() : ""%>" class="inputText" type="text" id="id" name="id" /></div>
			<div class="divLabel">Nombre:</div>
			<div class="divField"><input value="<%=(funcionarioFilter.getNombre() != null) ? funcionarioFilter.getNombre() : ""%>" class="inputText" type="text" id="nombre" name="nombre" style="width:320px;" /></div>
		</form>
		<div class="divButtons">
			<input type="button" class="button" value="Consultar" onclick="find();" />
			<input type="button" class="button" value="Limpiar" onclick="clean();" />
			<input type="button" class="button" value="Nuevo" onclick="goNew();" />
		</div>
	</div>
	<div class="divTable">
		<table class="table" cellpadding="0" cellspacing="0">
			<tr>
				<th style="width:50px;">Código</th>
				<th>Nombre</th>
				<th style="width:50px;">&nbsp;</th>
			</tr>
<%
	for(int i=0; i<list.length; i++) {
		Funcionario func = (Funcionario) list[i];
%> 	
			<tr>
				<td><%=func.getId()%></td>
				<td><%=func.getNombre()%></td>
				<td style="text-align:center">
					<img class="image" src="./img/miniDetail.gif" onclick="detail(<%=func.getId()%>);" />
					<img class="image" src="./img/miniRemove.gif" onclick="removeRecord(<%=func.getId()%>);" />
				</td>
			</tr>
<%
	}
%>
		</table>
	</div>
</body>
</html>