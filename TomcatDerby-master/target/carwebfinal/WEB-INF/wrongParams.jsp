<%@ taglib prefix = "ex" uri = "./security.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Wrong parameters</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <h2>Wrong parameters specified</h2>

       <jsp:include page= "inc-common-menu.jsp" />
		<ex:security id = "securityTest" />  

    </body>
</html>

