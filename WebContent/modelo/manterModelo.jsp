<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Modelo"%>
<%@page import="py.edu.fpune.posgrado.entity.Marca"%>
<%@page import="py.edu.fpune.posgrado.session.SessionMarca"%>
<%@page import="py.edu.fpune.posgrado.session.SessionModelo"%>
<%
	Modelo modelo = (Modelo) request.getAttribute("object");
	if (modelo == null) {
		modelo = new Modelo();
	}
	
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Consultar Modelo</title>
	
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
			else if (document.getElementById("marca").value == "") {
				alert("Campo obrigatório!");
				document.getElementById("marca").focus();
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
	<div class="titulo">Consultar Modelo</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Modelo"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Código:</div>
			<div class="divField"><input value="<%=(modelo.getIdModelo() != null) ? modelo.getIdModelo() : ""%>" class="inputText" type="text" id="idModelo" name="idModelo" readonly/></div>
			<div class="divLabel">Descripción:</div>
			<div class="divField"><input value="<%=(modelo.getDescripcion() != null) ? modelo.getDescripcion() : ""%>" class="inputText" type="text" id="descripcion" name="descripcion" style="width:320px;" /></div>
			
			<div class="divLabel">Marca:</div>
			<div class="divField">
				<select id="marca" name="marca">
					<option value="" >Seleccione</option>
					<% 
					SessionMarca sessionMarca = new SessionMarca();
					Marca marca = new Marca();
					Object list[] = sessionMarca.find(marca);
					
					for(int i =0; i<list.length; i++){
						marca = (Marca) list[i];
						//out.print( marca+"<br>" );
					%>
					<option value="<%= marca.getIdMarca() 
						%>" <% 
							if(modelo.getMarca() != null && modelo.getMarca().getIdMarca()==marca.getIdMarca()){
								out.print("selected");
							}
							%>><%= marca.getDescripcion() %></option>
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