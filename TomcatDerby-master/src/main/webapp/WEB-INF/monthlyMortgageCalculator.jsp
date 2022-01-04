<%@ taglib prefix = "ex" uri = "./security.tld" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>    
    <title>Car Loan</title>
   <link rel="stylesheet" href="./css/format.css">
</head>
<body> 
<jsp:include page ="inc-common-menu.jsp" />
<ex:security id = "securityTest" />
  <div class="divBody">
    
    <form method = "post" action = "./carLoan"> 
    S: Scenario <input type="text" value="${scene}" name = "scene"/>
    L: Loan Amount <input type="text" value="${financeAmount}" name = "financeAmount"/>
    I: Interest Rate <input class="interest" type="text" value="${interestRate}" name = "interestRate"/> % 
    M: Monthly Payments <input type="submit" class="calculate" value="calculate" />
    </form> 
    <hr />
    <h1>Loan Scenarios / Car Payments</h1>
    <c:forEach items="${loanList}" var='loan'>
    <div class='divScenario'>
               <span>S:</span><c:out value="${loan.scene}"/> <br />
               <span>L:</span>$<c:out value="${loan.financeAmount}"/><br />
               <span>M:</span>$<c:out value="${loan.getMonthlyPaymentTwoDecimalpt()}"/><br />
               <img class="moneyimg" src="${loan.getImage()}" />
            </div>
   </c:forEach>  
        </div>
         
		
</body>
</html>