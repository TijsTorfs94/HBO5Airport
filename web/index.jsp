<%-- 
    HBO5 Programeren 4
    Document   : index
    Created on : 23-apr-2017, 17:33:50
    Author     : steve
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>


<% request.setAttribute("Login", session.getAttribute("Login")); %>

<template:siteTemplate title="Home" status="${Login}">


    <jsp:attribute name="head">
        
    </jsp:attribute>
    
    <jsp:attribute name="content">
      
        <p>${Login}</p>
        
        
        
        <a href="zoektest.jsp">zoek</a>
       

    </jsp:attribute>
    

</template:siteTemplate>

