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
                  <form:form modelAttribute="userForm" class="form-example" method="post">
                        <h1>Please, Login</h1>
                        <!-- Input fields -->
                        <div class="form-group">
                            <label for="firstName">First Name:</label>
                            <spring:bind path="firstName">
                                <form:input path="firstName" type="text" class="form-control username" id="FirstName" placeholder="First Name..." name="firstName"></form:input>
                            </spring:bind>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name:</label>
                             <spring:bind path="lastName">
                                <form:input path="lastName" type="text" class="form-control username" id="LastName" placeholder="Last Name..." name="lastName"></form:input>
                             </spring:bind>
                        </div>
                        <div class="form-group">
                            <label for="username">Username:</label>

                            <spring:bind path="email">
                                <form:input path="email" type="text" class="form-control username" id="username" placeholder="Username..." name="userName"></form:input>
                            </spring:bind>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <spring:bind path="password">
                                <form:input path="password" type="password" class="form-control password" id="password" placeholder="Password..." name="password"></form:input>
                            </spring:bind>
                        </div>

                        <span class="form-check-label">Already have an account? <a href="/login">Login here!</a></span>

                        <button type="submit" class="btn btn-primary btn-customized mt-4" >sign up</button>


                    </form:form>
                  <!-- Form end -->
              </div>
          </div>
      </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>