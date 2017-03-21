<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-2" />
    <link rel="stylesheet" href="style.css" type="text/css" />Szymon Zoltowski s12904
</head>
<center>
<h1>Credit Calc</h1><br><br>
</center>
<form action="tabela" method="POST">
<table>
    <tr>
        <td>
            Kwota kredytu:
        </td>
        <td>
            Ilość rat:
        </td>
        <td>
            Oprocentowanie:
        </td>
        <td>
            Rodzaj rat:
        </td>
        <td>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" name="formValueOfCredit"/>
        </td>
        <td>
            <input type="text" name="formNumberOfInstalments"/>
        </td>
        <td>
            <input type="text" name="formInterest"/>
        </td>
        <td>
            <input type="radio" name="typeOfInstalments" value="malejace" checked/>Malejaca</br>
            <input type="radio" name="typeOfInstalments" value="rowne"/>Stala
        </td>
        <td>
            <input type="submit" name="submit" value="Oblicz" ><br>
            <input type="submit" name="generate" value="Wygeneruj PDF">
        </td>
    </tr>

</table>
</form>
    <% if (request.getParameter("submit") != null) out.println("Wczytano dane...");%>

</body>
</html>