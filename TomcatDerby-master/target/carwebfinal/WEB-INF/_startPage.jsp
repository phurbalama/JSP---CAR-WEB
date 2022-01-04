<%@ taglib prefix = "ex" uri = "./security.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        
        <h2>Home page</h2>
        
        <p>Available actions:</p>
        
        <ul>
            <li><a href="cars?action=listcars">Show all cars</a></li>
            <li><a href="cities?action=cities">View All Cities</a></li>
            <li><a href="cities?action=citychart">View Pie Chart</a></li>
            <li><a href="group?action=AB">Group</a></li>
            <li><a href="carLoan?action=carLoan">Car Loan</a></li>
        </ul>
        
        
         <jsp:include page= "inc-common-menu.jsp" />
         <ex:security id = "securityTest" />
    </body>
</html>

