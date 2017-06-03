<html>
<head>
    <title>Favorite Fruit</title>
</head>
<body>
    <form action="/favorite_fruit" method="post">
        <p>What's your favorite fruit?</p>
        <#list fruits as fruit>
            <p>
                <input type="radio" name="fruit" value="${fruit}"> ${fruit}
            </p>
        </#list>
        <input type="submit" value="Submit">
    </form>
</body>
</html>