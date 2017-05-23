<%-- 
    HBO5 Programeren 4
    Document   : index
    Created on : 23-apr-2017, 17:33:50
    Author     : steve
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:siteTemplate title="Inkomend" status="login">
    <jsp:attribute name="head">
    </jsp:attribute>
    <jsp:attribute name="content">
      
        <section class="tour section-wrapper tablecontainer">
            <!--for demo wrap-->
            <h1 class="tour section-wrapper container">Inkomende vluchten</h1>
            <select name="Luchthaven" class="col-md-offset-1">
             
                <option value="1">Brussels Airport</option>
                <option value="2">Schiphol</option>
                <option value="3">Charles de Gaulle</option>
                <option value="4">Heathrow</option>
                <option value="5">Tegel</option>
                <option value="6">Goteborg City Airport</option>
                <option value="7">Venice VCE</option>
                <option value="8">Abu Dhabi</option>
                <option value="9">Sri Guru Ram DassJee</option>
            </select>
            <template:TableTemplate>
                <jsp:attribute name="tableHeader">
                    <tr>
                        <th>Vluchtnummer</th>
                        <th>Vliegtuig</th>
                        <th>Vertrek</th>
                        <th>Aankomst</th>
                        <th>Aankomsttijd</th>
                    </tr>
                </jsp:attribute>
                <jsp:attribute name="tableBody">
                  
                </jsp:attribute>
            </template:TableTemplate>
            </section>
        
    </jsp:attribute>
  
</template:siteTemplate>

