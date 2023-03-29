<%-- 
    Document   : skinTable
    Created on : Nov 3, 2022, 10:00:25 PM
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
                <h4><em>Item</em> List</h4>
                <a href="edit?mode=6" style="font-size: 23px;">Add more item</a>
            </div>
            <div class="row">
                <table id="editTable">
                    <tr>    
                        <td>Skin ID</td>
                        <td>Gun Name</td>
                        <td>Gun Type</td>
                        <td>Price</td>
                        <td>Stock</td>
                        <td>Image</td>  
                    </tr>
                        <c:forEach items="${sList}" var = "item">
                            <tr>
                                <td>${item.getItemId()}</td>
                                <td>${item.getName()}</td>      
                                <td>${item.getGunName()}</td> 
                                <td><i class="fa fa-dollar"></i> ${item.getPrice()}</td> 
                                <td><i class="fa fa-boxes-stacked"> ${item.getStock()}</td> 
                                <td><img src="${item.getImg()}" style="width: auto; height: 40px"></td>
                                <td><a href="edit?mode=4&mod=0&id=${item.getItemId()}">Update</td>
                                <td><a href="edit?mode=4&mod=1&id=${item.getItemId()}">Delete</td>
                            </tr>
                        </c:forEach>


                </table>
            </div>

        </div>
    </body>
</html>
