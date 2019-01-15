<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html>

<head>

    <meta charset="UTF-8">
    <title>New user</title>
</head>
<body>
<div>
    <@sf.form action="/users/new" method="post" modelAttribute="user">
        <div>
            <@sf.label path="name">Name</@sf.label>
            <@sf.input path="name"/>
            <@sf.errors path="name"/>
        </div>
        <br>
        <div>
            <@sf.label path="surname">Surname</@sf.label>
            <@sf.input path="surname"/>
            <@sf.errors path="surname"/>
        </div>
        <br>
        <div>
            <@sf.label path="email">Email</@sf.label>
            <@sf.input path="email"/>
            <@sf.errors path="email"/>
        </div>
        <br>
        <div>
            <@sf.label path="password">Password</@sf.label>
            <@sf.input path="password"/>
            <@sf.errors path="password"/>
        </div>
        <br>
        <input type="submit" value="Create">
    </@sf.form>
</div>
</body>
</html>