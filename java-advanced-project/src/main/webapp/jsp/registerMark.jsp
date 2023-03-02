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

    <title>Register mark</title>

  </head>
  <body class="h-100">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">Project</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/marks">My marks <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/universities">Universities</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#"></a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="/login?logout">Log Out</a>
          </li>
        </ul>
      </div>
    </nav>



    <div class="container h-100">
          <div class="row h-100 justify-content-center align-items-center">
              <div class="col-10 col-md-8 col-lg-6">
                  <!-- Form -->
                  <form:form modelAttribute="markForm" class="form-example" action="/save" method="GET">
                        <h1>Please, enter information about your mark!</h1>
                        <!-- Input fields -->
                        <div class="form-group">
                            <label for="subjectName">Subject name: </label>
                             <spring:bind path="name">
                                <form:input path="name" type="text" class="form-control username" id="subjectName" placeholder="Subject Name..." name="subjectName"></form:input>
                             </spring:bind>
                        </div>
                        <div class="form-group">
                            <label for="points">Mark:</label>
                            <spring:bind path="points">
                                <form:input path="points" type="text" class="form-control username" id="points" placeholder="Your points..." name="points"></form:input>
                            </spring:bind>
                        </div>

                        <c:if test="${param.error == true}">
                            <div class="alert-danger">Your mark mus`nt be more than 200 or less than 0!</div>
                        </c:if>

                        <input type="hidden" value="${pageContext.request.userPrincipal.name}" id="userName" name="userName"></input>


                        <button type="submit" class="btn btn-primary btn-customized mt-4">Save</button>


                    </form:form>
                  <!-- Form end -->
              </div>
          </div>
      </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>