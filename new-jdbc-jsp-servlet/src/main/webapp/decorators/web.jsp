<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ"/></title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value= 'template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value= 'template/web/shop-homepage.css' />"
	rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@include file="/common/web/header.jsp"%>
	<!-- header -->

	<!-- Page Content -->
	<div class="container">
		<dec:body />
	</div>
	<!-- Page Content -->

	<!-- footer -->
	<%@include file="/common/web/footer.jsp"%>
	<!-- footer -->

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>