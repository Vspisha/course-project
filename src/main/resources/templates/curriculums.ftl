<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Curriculum</title>
</head>
<body>
<h1>Table of Curriculum </h1>
<hr>
<a href="/gui/curriculum/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table table-bordered border-primary">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Student</th>
            <th>Subject</th>
            <th>Mark</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list curriculums as curriculum>
            <tr>
                <td>${curriculum.id}</td>
                <td>${curriculum.name}</td>
                <td>${curriculum.student}</td>
                <td>${curriculum.subject}</td>
                <td>${curriculum.mark}</td>
                <td>${curriculum.description}</td>
                <td>${curriculum.createdAt}</td>
                <td>${curriculum.updatedAt}</td>
                <td><a href="/gui/curriculum/update/${curriculum.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/curriculum/delete/${curriculum.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>