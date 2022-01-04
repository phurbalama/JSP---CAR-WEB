<%@ taglib prefix = "ex" uri = "./security.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Cars</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
              integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w"
              crossorigin="anonymous">  

        <style>
        .center
				{
					margin: 0 auto;
				}
            body { padding:1em }
            nav { margin-top: 2em }
            .money { text-align: right }
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
		<div align="center">
		
        <h2>All cars </h2>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>VendorPrice</th>
                    <th>Profit</th>
                </tr>
            </thead>
			<tbody>
            <c:forEach items="${carList}" var='car'>
                <tr>
                    <td>
                        <c:out value="${car.id}"/>
                    </td>
                    <td>
                        <c:out value="${car.name}"/>
                    </td>
                    <td class="money">
                        $<c:out value="${car.price}"/>
                    </td>    
                    <td class="money">
                        $<c:out value="${car.vendorPrice}"/>
                    </td>    
                    <td class="money">
                        $<c:out value="${car.profit}"/>
                    </td>             
                </tr>
            </c:forEach>   
            </tbody>
            
        <tfoot>
		<tr>
        	<td style="border:0px"colspan='4' ><span style="float:right;">Average Profit:</span></td>
        	<td style="border:0px"colspan='5' >${average}</td>
       	</tr>
       	<tr>
        	<td style="border:0px"colspan='4' ><span style="float:right;">Total:</span></td>
        	<td style="border:0px"colspan='5' >${total}</td>
       	</tr>
        	
        	</tfoot>
        	</table>
    
        <jsp:include page ="inc-common-menu.jsp" />
		<ex:security id = "securityTest" />
		</div>
    </body>
</html>

