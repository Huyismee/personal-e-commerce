<%-- 
    Document   : editCollection
    Created on : Nov 3, 2022, 10:16:45 PM
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
            <div class="heading-section">
                <h4><em>Edit</em> Collection</h4>
            </div>
            <div class="row">
                <form method="post" action="edit" id="input">
                    <table id="editTable" class="row">
                        <tr>    
                            <td class="col-lg-3">Collection ID:</td>
                            <td class="col-lg-9"><input type="text" name="colId" readonly value="${colId}"></td>   
                        </tr> 
                        <tr>    
                            <td class="col-lg-3">Collection Name:</td>
                            <td class="col-lg-9"><input type="text" name="colName"  value="${colName}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Collection Description:</td>
                            <td class="col-lg-9"><input type="text" name="colDes"  value="${colDes}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Collection Image:</td>
                            <td class="col-lg-9"><input type="text" name="colImg"  value="${colImg}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Collection Video: </td>
                            <td class="col-lg-9"><input type="text" name="colVid"  value="${colVid}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Collection Banner:</td>
                            <td class="col-lg-9"><input type="text" name="colBackgrImg"  value="${colBackgrImg}"></td>   
                        </tr>
                    </table>
                    <div class="row">
                        <div class="col-lg-6"><input type="submit" name="colUpdate" value="Update"></div>
                        <div class="col-lg-6"><input type="submit" name="cancelCol" value="Cancel"></div>                     
                    </div>

                </form>
            </div>

        </div>
    </body>
</html>
