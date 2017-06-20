<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adres</title>
</head>
<body>
<form method="POST" action="/examen/Address">
    <label for="naam">Naam</label><input type="text" id="naam" name="naam"/>
    <label for="straat">Straat</label><input type="text" id="straat" name="straat"/>
    <label for="stad">Stad</label><input type="text" id="stad" name="stad"/>
    <input type="submit" value="Verzenden"/>
</form>
</body>
</html>
