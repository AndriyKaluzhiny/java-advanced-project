<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" class="h-100">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Login</title>

  </head>
  <body class="h-100">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand text-align-center" href="#">Project</a>
    </nav>
    <div class="container h-100">
          <div class="row h-100 justify-content-center align-items-center">
              <div class="col-10 col-md-8 col-lg-6">
                  <!-- Form -->
                  <form:form action="/sign-in_processing" enctype="multipart/form-data" class="form-example" method="post">
                        <h1><spring:message code="sign-in.title" /></h1>
                        <!-- Input fields -->
                        <div class="form-group">
                            <label for="firstName"><spring:message code="sign-in.firstName" /></label>
                            <input type="text" class="form-control username" id="FirstName" placeholder="First Name..." name="firstName"></input>
                        </div>
                        <div class="form-group">
                            <label for="lastName"><spring:message code="sign-in.lastName" /></label>
                            <input type="text" class="form-control username" id="LastName" placeholder="Last Name..." name="lastName"></input>
                        </div>
                        <div class="form-group">
                            <label for="email"><spring:message code="sign-in.email" /></label>
                            <input type="text" class="form-control username" id="username" placeholder="Email..." name="email"></input>
                        </div>
                        <div class="form-group">
                             <label for="password"><spring:message code="sign-in.password" /></label>
                             <input type="password" class="form-control username" id="password" placeholder="password..." name="password"></input>
                        </div>
                        <div class="form-group">
                            <label for="file"><spring:message code="sign-in.image" /></label>
                            <input type="file" class="form-control password" id="file" name="file"></input>
                        </div>

                        <input type="hidden" id="lang" name="lang" value="${lang}"  />

                        <span class="form-check-label"><spring:message code="sign-in.alreadyHaveAccountText" /><a href="/login?lang=${lang}"><spring:message code="sign-in.alreadyHaveAccountLink" /></</a></span>

                        <button type="submit" class="btn btn-primary btn-customized mt-4" ><spring:message code="sign-in.button" /></button>


                    </form:form>
                  <!-- Form end -->
              </div>
          </div>
      </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>