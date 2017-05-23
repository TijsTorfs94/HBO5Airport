<%-- 
    HBO5 Programeren 4
    Document   : index
    Created on : 23-apr-2017, 17:33:50
    Author     : steve
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="template" tagdir="/WEB-INF/tags" %>

<template:siteTemplate title="Uitgaand" status="login">
    <jsp:attribute name="head">
        
    </jsp:attribute>
    <jsp:attribute name="content">
      
        <section class="tour section-wrapper tablecontainer">
            <!--for demo wrap-->
            <h1 class="tour section-wrapper container">Uitgaande vluchten</h1>
            <select name="Luchthaven">
                <option value="Bru">Brussels Airport</option>
                <option value="Schip">Schiphol</option>
                <option value="Charle">Charles de Gaulle</option>
                <option value="Heath">Heathrow</option>
                <option value="Teg">Tegel</option>
                <option value="Gote">Goteborg City Airport</option>
                <option value="Ven">Venice VCE</option>
                <option value="Abu">Abu Dhabi</option>
                <option value="Sri">Sri Guru Ram DassJee</option>
            </select>
              <table cellpadding="0" cellspacing="0" border="0" class="tablecontainer">
                <thead>  
                    <tr>
                        <th>Vluchtnummer</th>
                        <th>Vliegtuig</th>
                        <th>Vertrek</th>
                        <th>Vertrektijd</th>
                        <th>Aankomst</th>
                        <th>Aankomsttijd</th>
                    </tr>
                </thead>
                    <tbody>
                  <tr>
                    <td>AAC</td>
                    <td>AUSTRALIAN</td>
                    <td>$1.38</td>
                    <td>+2.01</td>
                    <td>-0.36%</td>
                  </tr>
                  <tr>
                    <td>AAD</td>
                    <td>AUSENCO</td>
                    <td>$2.38</td>
                    <td>-0.01</td>
                    <td>-1.36%</td>
                  </tr>
                  <tr>
                    <td>AAX</td>
                    <td>ADELAIDE</td>
                    <td>$3.22</td>
                    <td>+0.01</td>
                    <td>+1.36%</td>
                  </tr>
                  <tr>
                    <td>XXD</td>
                    <td>ADITYA BIRLA</td>
                    <td>$1.02</td>
                    <td>-1.01</td>
                    <td>+2.36%</td>
                  </tr>
                  
                </tbody>
              </table>
          </section>
        
    </jsp:attribute>
  
</template:siteTemplate>

