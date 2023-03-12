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
                    <a class="nav-link" href="/?lang=${param.lang}"><spring:message code="nav.home" /> <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="marks?userName=${pageContext.request.userPrincipal.name}&lang=${param.lang}"><spring:message code="nav.marks" /></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="/universities?lang=${param.lang}"><spring:message code="nav.universities" /></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link disabled" href="/login?logout&lang=${lang}"><spring:message code="nav.logout" /></a>
                  </li>
                </ul>
              </div>

              <div>
                <fieldset>
                    <label><spring:message code="login.choose_language" /></label>
                    <select id="locales">
                        <option value="en"><spring:message code='login.english'/></option>
                        <option value="ua"><spring:message code='login.ukrainian'/></option>
                    </select>
                </fieldset>
              </div>
            </nav>

    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">First</th>
          <th scope="col">Last</th>
          <th scope="col">Handle</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">1</th>
          <td>Mark</td>
          <td>Otto</td>
          <td>@mdo</td>
        </tr>
        <tr>
          <th scope="row">2</th>
          <td>Jacob</td>
          <td>Thornton</td>
          <td>@fat</td>
        </tr>
        <tr>
          <th scope="row">3</th>
          <td>Larry</td>
          <td>the Bird</td>
          <td>@twitter</td>
        </tr>
      </tbody>
    </table>


    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>