<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en" class="h-100">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script
      src="https://code.jquery.com/jquery-3.6.3.min.js"
      integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
      crossorigin="anonymous"></script>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title><spring:message code="login.pageTitle" /></title>

    <script type="text/javascript">
    	$(document).ready(function() {
    		var selItem = localStorage.getItem("locales");
    		$('#locales').val(selItem ? selItem : 'en');
    		$("#locales").change(function() {
    			var selectedOption = $('#locales').val();
    			if (selectedOption) {
    				window.location.replace('?lang=' + selectedOption);
    				localStorage.setItem("locales", selectedOption);
    			}
    		});
    	});
    </script>

  </head>
  <body class="h-100">

  <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Project</a>
  </nav>

    <div class="container h-100">
      <div class="row h-100 justify-content-center align-items-center">
          <div class="col-10 col-md-8 col-lg-6">
              <!-- Form -->
              <form class="form-example" action="<c:url value='/security_check' />" method="POST">
                    <h1><spring:message code="login.title" /></h1>
                    <!-- Input fields -->
                    <div class="form-group">
                        <label for="username"><spring:message code="login.email" /></label>
                        <input type="text" class="form-control username" id="username" placeholder="Username..." name="userName">
                    </div>
                    <div class="form-group">
                        <label for="password"><spring:message code="login.password" /></label>
                        <input type="password" class="form-control password" id="password" placeholder="Password..." name="password">
                    </div>



                    <span class="form-check-label"><spring:message code="login.createAccountText" /><a href="/sign-in?lang=${lang}"><spring:message code="login.createAccountLink" /></a></span>

                    <button type="submit" class="btn btn-primary btn-customized mt-4" ><spring:message code="login.loginButton" /></button>

                    <c:if test="${param.error ne null}">
                    	<div class="alert-danger"><spring:message code="login.invalidUserNameOrPasswordException" /></div>
                   	</c:if>
                    <c:if test="${param.logout ne null}">
                    	<div class="alert-normal"><spring:message code="login.logoutMsg" /></div>
                    </c:if>

                    <input type="hidden" name="${_csrf.parameterName}"
                    			value="${_csrf.token}" />
                </form>
              <!-- Form end -->

              <div>
              	    <fieldset>
              			<label><spring:message code="login.choose_language" /></label> <select
              				id="locales">
              				<option value="en"><spring:message code='login.english'/></option>
              				<option value="ua"><spring:message code='login.ukrainian'/></option>

              				</select>
              		</fieldset>
              </div>
          </div>
      </div>
  </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>