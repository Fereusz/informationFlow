<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 09.12.2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Information Flow</title>
    <%-- Elementy dotyczące treści strony --%>

    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<jsp:include page="media/header.jsp"/>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Witaj na stronie Marcina
            </h1>
            <h2 class="subtitle">
                Witaj w projekcie <strong>Information Flow</strong>.
                <br/>Przykladowy tekst
            </h2>

        </div>
    </div>
</section>
<jsp:include page="media/footer.jsp"/>
</body>
</html>