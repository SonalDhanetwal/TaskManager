<!doctype html>
<%@ taglib prefix="c"
  uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt"
    uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Task Manager | Home</title>

    <link rel="stylesheet" href="static/css/bootstrap.min.css"
    integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
    crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="static/css/style.css">

   <!--[if lt IE 9]>
      <script src="static/js/html5shiv.min.js"></script>
      <script src="static/js/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

        <div role = "navigation">
            <div class = "navbar navbar-inverse">
                <a href = "home" class = "navbar-brand">Tasks Details</a>
                <div class = "navbar-collapse collapse">
                    <ul class = "nav navbar-nav">
                        <li><a href = "new-task">New Tasks</a></li>
                        <li><a href = "all-tasks">All Tasks</a></li>
                    </ul>
                 </div>
            </div>
        </div>
        <c:choose>
            <c:when test="${mode == 'MODE_HOME'}">
                <div role = "container" id = "homeDiv">
                    <div class = "jumbotron text-center" style="background-color:lightblue">
                                <h1>Welcome to Task Manager</h1>
                                <hr>
                            </div>
                </div>
            </c:when>
            <c:when test="${mode == 'MODE_TASKS'}">
                <div role = "container" id = "taskDiv" style="background-color:pink">
                     <div class = "text-center">
                         <h3>My Tasks</h3>
                         <hr>
                         <div class = "table-responsive">
                            <table class = "table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Task Name</th>
                                        <th>Description</th>
                                        <th>Date Created</th>
                                        <th>Finished</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="task" items="${tasks}">
                                        <tr>
                                            <td>${task.id}</td>
                                            <td>${task.tsk_name}</td>
                                            <td>${task.tsk_desc}</td>
                                            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${task.tsk_date}"/>
                                            </td>
                                            <td>${task.tsk_finish}</td>
                                            <td><a href="update-task?id=${task.id}">
                                                <span class="glyphicon glyphicon-pencil"></span></a></td>
                                            <td><a href="delete-task?id=${task.id}">
                                                <span class= "glyphicon glyphicon-trash"></span></a></td>
                                        </tr>
                                     </c:forEach>
                                </tbody>
                         </div>
                     </div>
                </div>

            </c:when>
            <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
            <div class = "container" id = "formDiv">
                    <div class = "text-center" style="background-color:lightblue">
                                <h3>Manage Tasks</h3>
                                <hr>
                                <form class="form-horizontal" method="POST" action="save-task">
                                    <input type="hidden" name="id" value="${task.id}"/>
                                    <div class="form-group">
                                    <label class="control-label col-md-3">Name</label>
                                    <div class="col-md-7">
                                    <input type="text" class="form-control" name="tsk_name"
                                    value="${task.tsk_name}"/>
                                    </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Description</label>
                                        <div class="col-md-7">
                                            <input type="text" class="form-control" name="tsk_desc"
                                            value="${task.tsk_desc}"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label col-md-3">Finished</label>
                                        <div class="col-md-7">
                                            <input type="radio" class="col-sm-1" name="tsk_finish" value="true"/>
                                            <div class="col-md-3">Yes</div>
                                            <input type="radio" class="col-sm-1" name="tsk_finish" value="false" checked/>
                                            <div class="col-md-3">No</div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <input type = "submit" class = "btn btn-primary" value="Save"/>
                                    </div>
                                </form>
                            </div>
                    </div>
            </c:when>
        </c:choose>


    <script src="static/js/jquery-1.12.4.min.js"
    integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
    crossorigin="anonymous"></script>

    <script src="static/js/bootstrap.min.js"
    integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
    crossorigin="anonymous"></script>
  </body>
</html>