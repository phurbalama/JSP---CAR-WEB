<%@ taglib prefix = "ex" uri = "./security.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Groups</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
              integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
              crossorigin="anonymous">  

        <style>
        		
        
            .money { text-align: right }
			   
			body {
			  margin: 0;
			  font-family: Arial, Helvetica, sans-serif;
			}
			
					  th{
					  background-color: grey;
					  padding:5px;
					  border:1px solid black;
					  }
					   td {
									border-collapse: collapse;
									padding:5px;
								  	border: 1px solid black;
								}
			
			            
        </style>
    </head>
    <body>
    <jsp:include page= "inc-common-menu.jsp" />
	
        
        <div align="center">
      
        <br/><h2>${groupID} Groups </h2>
        <br/>
        <div id="topnav">
			  <a href="group?action=AB">AB</a>
			  <a href="group?action=DC">DC</a>
			  <a href="group?action=EF">EF</a>
			  <a href="group?action=GG">GG</a>
			  <a href="group?action=HK">HK</a>
			  <a href="group?action=LM">LM</a>
			  <a href="group?action=NN">MN</a>
			  <a href="group?action=OP">OP</a>
			  <a href="group?action=QR">QR</a>
			  <a href="group?action=ST">ST</a>
			  <a href="group?action=UV">UV</a>
			  <a href="group?action=WX">WX</a>
		</div>
        <table>
            <thead>
                <tr>
                    <th>Group</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Month</th>
                    <th>Price Paid</th>
                    <th>Vendor Price</th>
                    <th>Income</th>
                </tr>
            </thead>
			<tbody>
            <c:forEach items="${GroupList}" var='group'>
                <tr>
                    <td>
                        <c:out value="${group.groupId}"/>
                    </td>
                    <td>
                        <c:out value="${group.name}"/>
                    </td>
                    <td>
                        <c:out value="${group.cityId}"/>
                    </td>
                    <td>
                        <c:out value="${group.purchaseMonth}"/>
                    </td>  
                    <td class="money">
                        $<c:out value="${group.pricePaid}"/>
                    </td>      
                    <td class="money">
                        $<c:out value="${group.vendorPrice}"/>
                    </td>    
                    <td class="money">
                        $<c:out value="${group.income}"/>
                    </td>             
                </tr>
            </c:forEach>   
            </tbody>
            
        
   		 <jsp:include page= "inc-common-menu.jsp" />
		<ex:security id = "securityTest" />
		<tfoot>
		<tr>
        	<td style="border:0px"colspan='6' ><span style="float:right;">Average Profit:</span></td>
        	<td style="border:0px"colspan='7' >${average}</td>
       	</tr>
       	<tr>
        	<td style="border:0px"colspan='6' ><span style="float:right;">Total:</span></td>
        	<td style="border:0px"colspan='7' >${total}</td>
       	</tr>
        	
        	</tfoot>
	</table>
	</div>
    </body>
</html>

