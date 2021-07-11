<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring CRUD Operation</title>

<link href="<c:url value="/assets/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/assets/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js" />"></script>

</head>
<body>

	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Spring MVC + Hibernate + JSP + MySQL + CRUD
				</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Add Customer</div>
				</div>
				<div class="panel-body">

					<form:form action="saveCustomer" cssClass="form-horizontal"
						
						method="post" modelAttribute="customer">

						<!-- need to associate this data with customer id -->
						<form:hidden path="id" />

						<div class="form-group">
							<label for="fName" class="col-md-3 control-label">First
								Name</label>
							<div class="col-md-9">
								<form:input path="fName" cssClass="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="lName" class="col-md-3 control-label">Last
								Name</label>
							<div class="col-md-9">
								<form:input path="lName" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Email</label>
							<div class="col-md-9">
								<form:input path="email" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
							</div>
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>