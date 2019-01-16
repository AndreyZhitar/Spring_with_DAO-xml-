<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
</head>
<body>
<div>
<#if users?has_content>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <#list users as user>
        <tr>
            <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            </tr>
        </tr>
        </#list>
    </table>
    <#else>
    <p>No users yet</p>
</#if>
</div>
<br>
<div>
    <a href="/users/new"><input type="submit" value="Add user"></a>

    <a href="/logout"><input type="submit" value="Exit"></a>
</div>
</body>
</html>