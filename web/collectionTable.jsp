<%-- 
    Document   : collectionTable
    Created on : Nov 3, 2022, 9:49:09 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="top-streamers">
            <div class="heading-section" style="display: flex;
                                                justify-content: space-between;">
                <h4><em>Collection</em> List</h4>
                <a href="edit?mode=5" style="font-size: 23px;">Add more collection</a>
            </div>
            
            <div class="row">
                <table id="editTable">
                    <tr>    
                        <td>Code</td>
                        <td>Name</td>   
                        <td>Image</td>  
                    </tr>
                        <c:forEach items="${list}" var = "item">
                            <tr>
                                <td>${item.getId()}</td>
                                <td>${item.getName()}</td>                                
                                <td><img src="${item.getBackgrImg()}" style="width: 80px; height: auto"></td>
                                <td><a href="edit?mode=3&mod=0&id=${item.getId()}">Update</td>
                                <td><a href="edit?mode=3&mod=1&id=${item.getId()}">Delete</td>
                            </tr>
                        </c:forEach>
                </table>
            </div>

        </div>
    </body>
</html>
