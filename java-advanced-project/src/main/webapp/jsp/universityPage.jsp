<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cabinet</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body class="security-app">
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
            <a class="nav-link" href="/marks?userName=${pageContext.request.userPrincipal.name}">My marks</a>
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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css" integrity="sha256-2XFplPlrFClt0bIdPgpz8H7ojnk10H69xRqd9+uTShA=" crossorigin="anonymous" />

    <div class="container-xl px-4 mt-4">
        <hr class="mt-0 mb-4">
        <!-- Payment methods card-->
        <div class="card card-header-actions mb-4">
            <div class="d-flex justify-content-between">
                <div class="card-header">
                    University Info
                </div>
                <div class="card-header">
                    <a href="/offers?id=${data.id}">Offers</a>
                </div>
            </div>
            <div class="card-body px-0">
                <!-- University info card 1 -->
                <div class="d-flex align-items-center justify-content-between px-4">
                    <div class="d-flex align-items-center">
                        <div class="ms-4">
                            <div class="small">Name</div>
                            <div class="text-xs text-muted">${data.name}</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- University info card 2 -->
                <div class="d-flex align-items-center justify-content-between px-4">
                    <div class="d-flex align-items-center">
                        <div class="ms-4">
                            <div class="small">Description</div>
                            <div class="text-xs text-muted">${data.description}</div>
                        </div>
                    </div>
                </div>
                <hr>
                <!-- University info card 3 -->
                <div class="d-flex align-items-center justify-content-between px-4">
                    <div class="d-flex align-items-center">
                        <div class="ms-4">
                            <div class="small">Count of students</div>
                            <div class="text-xs text-muted">${data.countOfStudents}</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Billing history card-->
        <div class="card mb-4">
        <div class="d-flex justify-content-between">
            <div class="card-header">Available Faculties</div>
            <div class="card-header"><a href="/addFaculty?universityId=${data.id}">Add faculties</a></div>
        </div>
            <div class="card-body p-0">
                <!-- Billing history table-->
                <div class="table-responsive table-billing-history">
                    <table class="table mb-0">
                        <thead>
                            <tr>
                                <th class="border-gray-200" scope="col">№</th>
                                <th class="border-gray-200" scope="col">Name</th>
                                <th class="border-gray-200" scope="col">Minimal Points</th>
                                <th class="border-gray-200" scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${faculty}" var="currentFaculty">
                            <tr>
                                <td>${currentFaculty.id}</td>
                                <td>${currentFaculty.name}</td>
                                <td>${currentFaculty.minimalPoints}</td>
                                <td><a href="/sendMarks?email=${pageContext.request.userPrincipal.name}&universityId=${data.id}&facultyId=${currentFaculty.id}&minPoints=${currentFaculty.minimalPoints}">Send Marks</a></td>
                                <c:if test="${param.error == true}">
                                    <div class="alert-danger">Your summary mark is less than required!</div>
                                </c:if>
                                <c:if test="${param.alreadyExists == true}">
                                    <div class="alert-danger">Your offer to be applied to this university has been already sent!</div>
                                </c:if>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>