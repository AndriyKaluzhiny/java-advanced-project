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
    <script
                  src="https://code.jquery.com/jquery-3.6.3.min.js"
                  integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
                  crossorigin="anonymous"></script>

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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Login</title>

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
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="marks">My marks</a>
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
                  <form:form action="/addProcessing" class="form-example" method="GET">
                        <h1><spring:message code="addUniversity.title" /></h1>
                        <!-- Input fields -->
                        <div class="form-group">
                            <label for="name"><spring:message code="addUniversity.universityName" /></label>
                                <input type="text" class="form-control username" id="name" placeholder="Name ..." name="name"></input>
                        </div>
                        <div class="form-group">
                            <label for="description"><spring:message code="addUniversity.desc" /></label>

                                <input type="text" class="form-control username" id="description" placeholder="Description..." name="description"></input>

                        </div>


                        <button type="submit" class="btn btn-primary btn-customized mt-4" ><spring:message code="addUniversity.button" /></button>


                    </form:form>
                  <!-- Form end -->
              </div>
          </div>
      </div>

    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>