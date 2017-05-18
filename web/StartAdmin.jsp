<%-- 
    Document   : StartAdmin
    Created on : 10-mei-2017, 11:21:24
    Author     : c1040604
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:siteTemplate title="Passagier" status="Uitloggen">
    <jsp:attribute name="head">
        
    </jsp:attribute>
  
    <jsp:attribute name="content">
      <div class="row">
        <div class="col-sm-2">
            <nav class="nav-sidebar">
                 <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Beheren van ... <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li class="active"><a href="#">luchthavens</a></li>
                                            <li class="active"><a href="#">luchtvaartmaatschappijen</a></li>
                                            <li class="active"><a href="#"></a>eigenaarsgegevens (leasemaatschappij)</li>
                                            <li class="active"><a href="#">bemanning en vluchtbemanning</a></li>
                                            <li class="active"><a href="#">passagiers</a></li>
                                            <li class="active"><a href="#">hangars en vliegtuigen in hangars</a></li>
                                        </ul>
                                    </li>
            </nav>
        </div>
    </div>  
      
      <p>Welkom </p>
    </jsp:attribute>

</template:siteTemplate>