<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-2" />
</head>
<center><h1>Credit Calc beta</h1></center><br><br>

<center>
<form action="credit" method="post" name="formula">
<table>
    <tr>
        <td>
            Kwota kredytu:
        </td>
        <td>
            Ilosc rat:
        </td>
        <td>
            Oprocentowanie:
        </td>
        <td>
            Oplata stala:
        </td>
        <td>
            Rodzaj rat:
        </td>
        <td>
        </td>
    </tr>
    <tr>
        <td>
            <input type="text" id="formValueOfCredit" name="formValueOfCredit"/>
        </td>
        <td>
            <input type="text" id="formNumberOfInstalments" name="formNumberOfInstalments"/>
        </td>
        <td>
            <input type="text" id="formInterest" name="formInterest"/>
        </td>
        <td>
            <input type="text" id="formFixedFee" name="formFixedFee"/>
        </td>
        <td>
            <input type="radio" id="typeOfInstalmentsMalejace" name="typeOfInstalments" checked/>Malejaca</br>
            <input type="radio" id="typeOfInstalmentsStale" name="typeOfInstalments"/>Stala
        </td>
        <td>
            <input type="submit" value="Oblicz" >
        </td>
    </tr>

</table>
</form>
</center>
</body>
</html>