<%-- 
    Document   : editItem
    Created on : Nov 3, 2022, 10:52:48 PM
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
                <h4><em>Edit</em> Item</h4>
            </div>
            <div class="row">
                <form method="post" action="edit" id="input">
                    <table id="editTable" class="row">
                        <tr>    
                            <td class="col-lg-3">Item Name:</td>
                            <td class="col-lg-9"><input type="text" name="itemName" value="${itemName}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Edition:</td>
                            <td class="col-lg-9"><select name="itemEdition">
                                    <option value="assets/images.premium.webp">Premium</option>
                                    <option value="assets/images.exclusive.webp">Exclusive</option>
                                </select>
                            </td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Price:</td>
                            <td class="col-lg-9"><input type="text" name="itemPrice"  value="${itemPrice}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Stock:</td>
                            <td class="col-lg-9"><input type="text" name="itemStock"  value="${itemStock}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Description</td>
                            <td class="col-lg-9"><input type="text" name="itemDes"  value="${itemDes}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Image:</td>
                            <td class="col-lg-9"><input type="text" name="itemImg"  value="${itemImg}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Video:</td>
                            <td class="col-lg-9"><input type="text" name="itemVid"  value="${itemVid}"></td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Gun Type:</td>
                            <td class="col-lg-9"><select name="itemGunId">
                                    <c:forEach items="${gList}" var = "item">
                                        <option value="${item.getGunId()}">${item.getGunName()}</option>
                                    </c:forEach>
                                </select>
                            </td>   
                        </tr>
                        <tr>    
                            <td class="col-lg-3">Item Collection:</td>
                            <td class="col-lg-9"><select name="itemBundleId">
                                    <c:forEach items="${list}" var = "item">
                                        <option value="${item.getId()}">${item.getName()}</option>
                                    </c:forEach>
                                </select></td>   
                        </tr>
                    </table>
                    <div class="row">
                        <div class="col-lg-6"><input type="submit" name="itemAdd" value="Add"></div>
                        <div class="col-lg-6"><input type="submit" name="itemCancel" value="Cancel"></div>                     
                    </div>

                </form>
            </div>
        </div>
    </body>
</html>
