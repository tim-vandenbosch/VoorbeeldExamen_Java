<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Gelieve te bevestigen</title>


</head>
<body>
<h1>Gelieve te bevestigen</h1>
<p>Beste mijnheer/mevrouw ${boeking.naam} , gelieve uw boeking voor ${boeking.dag} om ${boeking.uur} te bevestigen.</p>
<h3>Uw gegevens: ${boeking.naam}</h3>
<p>Straat: ${boeking.straat}    </p>
<p>Stad:  ${boeking.stad}   </p>

<form action="/examen/Confirm" method="POST">
    <input type="submit" value="Reserveer!">
</form>
</body>
</html>
