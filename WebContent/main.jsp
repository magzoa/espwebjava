<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="./css/styles.css">
	<title>Sistema de Control</title>
	
	<script type="text/javascript">
	
		function execute(entityName,newAction) {
			document.getElementById("newAction").value = newAction;
			document.getElementById("entityName").value = entityName;
			document.getElementById("form").submit();
		}
	
	</script>
</head>
<body>
	<form id="form" name="form" method="post" action="dispatcher" target="main">
		<input type="hidden" id="newAction" name="newAction" />
		<input type="hidden" id="entityName" name="entityName" />
	</form>
	<div class="divMainTitulo">
		Sistema de Control - POSTGRADO
	</div>
	<div class="divMenu">
		<div class="titulo">MENU</div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Marca','goFind');">Marca</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Modelo','goFind');">Modelo</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Funcionario','goFind');">Funcionario.</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Vehiculo','goFind');">Vehiculo.</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Cliente','goFind');">Cliente</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Servicio','goFind');">Servicio</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Producto','goFind');">Producto</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('OrdenServicio','goFind');">Orden Servicio</a></div>
		<div class="menuItem"><a class="linkMenu" href="javascript:execute('Venta','goFind');">Venta</a></div>
	</div>
	<div class="divMain">
		<iframe class="iframeMain" name="main" frameborder="1" style="border: 1px solid; border-color:#ff0000"></iframe>
	</div>
</body>
</html>