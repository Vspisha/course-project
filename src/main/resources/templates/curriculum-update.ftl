<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Update Curriculum</title>

</head>
<body>

<h1>Update Curriculum </h1>
<div>
    <form name="curriculum" action="" method="POST">
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">ID</label>
            <input class="form-control" type="text" id="exampleInputEmail1" disabled
                   readonly <@spring.formInput "form.id" "" "text"/>

        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Name</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.name" "" "text"/>
        </div>

        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Student</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.student" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Subject</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.subject" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputEmail1" class="form-label">Mark</label>
            <input type="text" class="form-control" id="exampleInputEmail1"
                   aria-describedby="emailHelp" <@spring.formInput "form.mark" "" "text"/>
        </div>
        <div class="mb-3" style="width: 50%">
            <label for="exampleInputPassword1" class="form-label">Description</label>
            <input type="text" class="form-control"
                   id="exampleInputPassword1" <@spring.formInput "form.description" "" "text"/>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>


</body>
</html>