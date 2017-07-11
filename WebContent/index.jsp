<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="py.edu.fpune.posgrado.entity.Marca"%>
<%@page import="py.edu.fpune.posgrado.session.SessionMarca"%>
<%
	String message = (String) request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>LOGIN</title>
	
	<script type="text/javascript">
		
		function validate() {
			if (document.getElementById("login").value == "") {
				alert("Campo obrigatório!");
				document.getElementById("login").focus();
				return false;
			}
			
			if (document.getElementById("password").value == "") {
				alert("Campo obrigatório!");
				document.getElementById("password").focus();
				return false;
			}
			return true;
		}
		
		function login() {
			document.getElementById("newAction").value = "login";
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
	<div class="titulo">LOGIN DO SISTEMA</div>
	<div class="divFields">
		<form id="form" name="form" method="post" action="dispatcher">
			<input type="hidden" id="newAction" name="newAction" />
			<input type="hidden" id="entityName" name="entityName" value="Usuario"/>
			<input type="hidden" id="id" name="id" />
			<div class="divLabel">Login:</div>
			<div class="divField"><input value="" class="inputText" type="text" id="login" name="login" style="width:150px;" /></div>
			<div class="divLabel">Password:</div>
			<div class="divField"><input value="" class="inputText" type="text" id="password" name="password" style="width:150px;" /></div>
		</form>
		<div class="divButtons">
			<input type="button" class="button" value="Login" onclick="login();" />
		</div>
	</div>
</body>
</html>