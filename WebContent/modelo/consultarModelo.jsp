<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Modelo"%>
<%@page import="py.edu.fpune.posgrado.session.SessionModelo"%>
<%
	Modelo modeloFilter = (Modelo) request.getSession().getAttribute("filterModelo");
	if (modeloFilter == null) {
		modeloFilter = new Modelo();
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
	<title>Consultar Modelo</title>
	
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
			if (confirm("Confirma la Exclusión?")) {
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
	<div class="titulo">Consultar Modelo</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Modelo" />
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(modeloFilter.getIdModelo() != null) ? modeloFilter.getIdModelo() : ""%>" class="inputText" type="text" id="idModelo" name="idModelo" /></div>
			<div class="divLabel">Descripción:</div>
			<div class="divField"><input value="<%=(modeloFilter.getDescripcion() != null) ? modeloFilter.getDescripcion() : ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>


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
				<th>Descripción</th>
				<th>Marca</th>
				<th style="width:50px;">&nbsp;</th>
			</tr>
<%
	for(int i=0; i<list.length; i++) {
		Modelo modelo = (Modelo) list[i];
%> 	
			<tr>
				<td><%=modelo.getIdModelo()%></td>
				<td><%=modelo.getDescripcion()%></td>
				<td><%=modelo.getMarca().getDescripcion()%></td>
				<td style="text-align:center">
					<img class="image" src="./img/miniDetail.gif" onclick="detail(<%=modelo.getIdModelo()%>);" />
					<img class="image" src="./img/miniRemove.gif" onclick="removeRecord(<%=modelo.getIdModelo()%>);" />
					
				</td>
			</tr>
<%
	}
%>
		</table>
	</div>
</body>
</html>