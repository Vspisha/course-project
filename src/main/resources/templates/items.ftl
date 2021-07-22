<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Item</title>
</head>
<body>
<h1>Table of items</h1>
<hr>
<a href="/gui/item/create"><input type="button" class="btn btn-success" value="Create" ></a>
<hr>
<div style="width: 70%">
    <table class="table table-bordered border-primary">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.desc}</td>
                <td>${item.createdAt}</td>
                <td>${item.updatedAt}</td>
                <td><a href="/gui/item/update/${item.id}"><input type="button" class="btn btn-dark" value="Edit"></a></td>
                <td><a href="/gui/item/delete/${item.id}"><input type="button" class="btn btn-danger" value="Delete"></a></td>


            </tr>
        </#list>
    </table>
</div>



</body>
</html>