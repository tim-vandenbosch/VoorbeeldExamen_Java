<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Boek tafel jsp</title>
</head>
<body>
    <h1>Restaurant:   ${restaurantnaam}        </h1>

    <p>Op welke dag en uur wenst u een tafel te boeken?</p>
    <p>
        Opgelet! Ons restaurant is héél exclusief en heeft maar 1 tafeltje ter beschikking.
        Een tafeltje kan enkel gereserveerd worden voor 1 uur. bvb. 10:00 , 11:00 , 19:00
        We tonen hier op voorhand niét of ons tafeltje al dan niet vrij is, dat controleren we nl. in het systeem.
    </p>

    <form method="POST" action="/examen/BoekTafel">
        <label for="dag">Dag(formaat: DD-MM-YYYY)</label>
        <input id="dag" name="dag" type="date" step="1" min="2016-01-01">
        <label for="uur">Uur(formaat: HH:MM)</label>
        <input id="uur" name="uur" type="time" min="9:00" max="22:00" step="3600">
        <input type="submit" value="Reserveer tafel"/>
    </form>
</body>
</html>
