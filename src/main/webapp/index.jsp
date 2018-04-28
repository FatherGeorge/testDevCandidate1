<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Interface</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/myCss.css" rel="stylesheet">

    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="resources/js/myFunctions.js"></script>
</head>
<body>

<div class="container">
    <fmt:setLocale value="en_US"/>
    <h2>Example of interface</h2>

    <div class="wrapper">
        <table class="table">
            <thead>Filter</thead>
            <tbody>
            <tr>
                <td>PN</td>
                <td><input type="text" id="partNumber" name="pn"></td>
            </tr>
            <tr>
                <td>Part Name</td>
                <td><input type="text" id="partName" name="partName"></td>
            </tr>
            <tr>
                <td>Vendor</td>
                <td><input type="text" id="vendor" name="vendor"></td>
            </tr>
            <tr>
                <td>Qty</td>
                <td><input type="text" id="qty" name="qty"></td>
            </tr>
            <tr>
                <td>Shipped</td>
                <td>after<input type="date" placeholder="YYYY-MM-DD" id="shippedAfter" name="shippedAfter">&nbsp;before<input type="date" id="shippedBefore" placeholder="YYYY-MM-DD" name="shippedBefore"></td>
            </tr>
            <tr>
                <td>Received</td>
                <td>after<input type="date" placeholder="YYYY-MM-DD" id="receivedAfter" name="receivedAfter">&nbsp;before<input type="date" id="receivedBefore" placeholder="YYYY-MM-DD" name="receivedBefore"></td>
            </tr>
            </tbody>
        </table>
        <button class="btn btn-primary" type="button" onclick="displayParts(true, false, '')">Filter</button>
    </div>

    <br />

    <table id="partsList" class="table">
        <thead>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'partNumber')">PN</button></th>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'partName')">Part Name</button></th>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'vendor')">Vendor</button></th>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'quantity')">Qty</button></th>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'shipped')">Shipped</button></th>
        <th><button class="btn btn-primary" type="button" onclick="displayParts(false, true, 'received')">Received</button></th>
        </thead>
        <script>displayParts(false, false, "")</script>
    </table>

</div>

<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
