<%-- 
    HBO5 Programeren 4
    Document   : index
    Created on : 23-apr-2017, 17:33:50
    Author     : steve
--%>

<%@page import="hbo5.it.www.beans.Vlucht"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<head>
		<!-- meta -->
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale = 1.0, maximum-scale=1.0, user-scalable=no"/>
        <title>${title}</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/ionicons.min.css">
	<link rel="stylesheet" href="css/owl.carousel.css">
	<link rel="stylesheet" href="css/owl.theme.css">
	<link rel="stylesheet" href="css/flexslider.css" type="text/css">
        <link rel="stylesheet" href="css/main.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
      
</head>
    <body>
        
        <div>
        <nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp" title="HOME"><i class="ion-paper-airplane"></i> Java <span>travel</span></a>
			</div> <!-- /.navbar-header -->

	    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">vluchtoverzicht <span class="caret"></span></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="ZoekServlet">Inkomende vluchten</a></li>
                                            <li><a href="uitgaand.jsp">Uitgaande vluchten</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#"> Zoeken </a></li>   
                                    <li><a href="LoginPage.jsp"><i class="ion-person"></i>${status}</a></li>
				</ul> <!-- /.nav -->
		    </div><!-- /.navbar-collapse -->
	  	</div><!-- /.container -->
	</nav>
        </div>
        <section class="tour section-wrapper tablecontainer">
            <!--for demo wrap-->
            <h1 class="tour section-wrapper container">Inkomende vluchten</h1>
            <form action="ZoekServlet">
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
            <input type="submit" name="Zoeken" id="Zoeken" value="Zoeken">
            <table cellpadding="0" cellspacing="0" border="0" id="myTable" class="tablecontainer tablesorter">
                    <thead>              
                        <tr>
                            <th>Vluchtnummer</th>
                            <th>Vliegtuig</th>
                            <th>Vertrek</th>
                            <th>Aankomst</th>
                            <th>Aankomsttijd</th>
                        </tr>
                    </thead>
                <tbody>
            </section>
                <%ArrayList<Vlucht> resultaat = 
                (ArrayList<Vlucht>) request.getAttribute("vluchten");

		for (Vlucht vlucht: resultaat){%>
                <tr>
                    <td><%=vlucht.getCode()%></td>
                    <td><%=vlucht.getVliegtuig_id()%></td>
                    <td><%=vlucht.getVertrekluchthaven_id()%></td>
                    <td><%=vlucht.getAankomstluchthaven_id() %></td>
                    <td><%=vlucht.getAankomsttijd() %></td>
                </tr>
                
		<%}%>
            </tbody>
            </table>





       
       <footer>
           <p>Project gemaakt door team 2 (Steve Dekerf, Peter Haest and Tijs Torfs)</p>          
       </footer>
    </body>
</html>


      
        

