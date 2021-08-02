<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Student</title>
</head>
<body>
<h1>Table of student</h1>
<hr>
<a href="/gui/student/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table table-bordered border-primary">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Patronymic</th>
            <th>Adress</th>
            <th>TelefonNumner</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list students as student>
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.patronymic}</td>
                <td>${student.adress}</td>
                <td>${student.telefonNumber}</td>
                <td>${student.description}</td>
                <td>${student.createdAt}</td>
                <td>${student.updatedAt}</td>
                <td><a href="/gui/student/update/${student.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/student/delete/${student.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>


            </tr>
        </#list>
    </table>
</div>

</body>
</html>