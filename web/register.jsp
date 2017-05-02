<%-- 
    Document   : register.jsp
    Created on : 2-mei-2017, 9:18:21
    Author     : steve
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:siteTemplate title="Home">
    <jsp:attribute name="head">
        
    </jsp:attribute>
    <jsp:attribute name="content">
      
        <form action="LoginServlet" method="post">
        <div class="container">
            
            <table style="margin:25%">
                
                 <tr>
                    <td><p>Voornaam</p></td>
                    <td><input type="text" name="Username"/></td>
                </tr>
                 <tr>
                    <td><p>Familienaam</p></td>
                    <td><input type="text" name="Username"/></td>
                </tr>
                 <tr>
                    <td><p>Username</p></td>
                    <td><input type="text" name="Username"/></td>
                </tr>
             
                <tr>
                    <td><p>Username</p></td>
                    <td><input type="text" name="Username"/></td>
                </tr>
                <tr>
                    <td><p>Paswoord</p></td>
                    <td><input type="text" name="Paswoord"/></td>
                </tr>
           
            <tr>
                <td colspan="2" style=""><input type="submit" name="login" value="login"/> </td>
            </tr>
            <tr>
                <td colspan="2" style=""><input type="submit" name="registreer" value="registreer"/></td> 
            </tr>
         
            
            
            
        </table>
        </div>
           </form>
        
        
        
        
    </jsp:attribute>
  
</template:siteTemplate>
