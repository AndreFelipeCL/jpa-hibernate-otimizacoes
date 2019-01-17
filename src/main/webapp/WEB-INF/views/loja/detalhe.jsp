<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="../template/top.jsp" />
<div class="col-sm-8">
	<div class="panel panel-default">
		<div class="panel-heading">${loja.nome}</div>
		<div class="panel-body">
			<div class="container">
				<h3>${loja.id}</h3>
				<h3>${loja.nome}</h3>
			</div>
		</div>
	</div>
</div>
<c:import url="../template/down.jsp" />
