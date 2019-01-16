<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <form action="/login/process" method="post">
        <div>
            Email: <input name="email" type="email">
        </div>
        <div>
            Password: <input name="password" type="password">
        </div>
        <br>
        <input type="submit">
    </form>
    <div>
    <#if error??>
        <p>Bad credentials</p>
    </#if>
    </div>
</body>
</html>