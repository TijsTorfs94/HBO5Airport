<%-- 
    Document   : LoginPage
    Created on : 26-apr-2017, 9:30:53
    Author     : steve
--%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:siteTemplate title="Home">
    <jsp:attribute name="head">
        
    </jsp:attribute>
    <jsp:attribute name="content">
        <div class="container">
            
            <table style="margin:25%">
            <tr>
                <td><p>Username</p></td>
                <td><input type="text" name="Username"/></td>
            </tr>
            <tr>
                <td><p>Paswoord</p></td>
                <td><input type="text" name="Paswoord"/></td>
            </tr>
            <tr>
                <!--Deze button moet nog gecentrrerd worden in de code-->
                <td colspan="2" style=""><input type="submit" name="LOGIN"/> </td>
            </tr>
            
            
            
            
        </table>
        </div>
    </jsp:attribute>
  
</template:siteTemplate>