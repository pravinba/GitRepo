<html>
<head>
<title>Welcome to Fruits Picker</title>
</head>
<body>
<h1>Pick any fruit you like</h1>
<br/>
<form action=/favourite_fruit method="POST">
<#list fruits as fruit>
<p> 
<input type="radio" name="fruit" value="${fruit}">${fruit}</input>
</p>
</#list>
<input type="submit" value="Submit">
</form>
</body>
</html>