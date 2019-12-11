<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 11.12.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
html>
<head>
    <title>Please add new feedback</title>
    <%-- Elementy dotyczące treści strony --%>
    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">

<jsp:include page="../media/header.jsp"/>

<section class="section">
    <div></div>
    <div class="container">
        <%--        <div class="hero-body">--%>
        <h1 class="title">
            Fund Add
        </h1>
        <h2 class="subtitle">
            Please add feedback from client
        </h2>
    </div>
    <div></div>
</section>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form:form method="post" modelAttribute="feedbackDTO">
                    <div class="field">
                        <form:label path="content" cssClass="label">Write feedback</form:label>
                        <div class="control has-icons-left">
                            <form:textarea path="content" cssClass="input" required="true" style="height:100px;width:100"></form:textarea>
                            <span class="icon is-small is-left"></span>
                            <p class="help"></p>
                        </div>
                    </div>
                    <div class="field">
                        <form:label path="fundId" cssClass="label">Select fund</form:label>
                        <div class="control has-icons-left">
                            <form:select path="fundId" items="${funds}" itemLabel="name" itemValue="id" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"></span>
                            <p class="help"></p>
                        </div>
                        <div class="field is-grouped">
                    <div class="field">
                        <form:label path="fundManagerId" cssClass="label">Select PM</form:label>
                        <div class="control has-icons-left">
                            <form:select path="fundManagerId" items="${managers}" itemLabel="fullName"  itemValue="id" cssClass="input" required="true"/>
                            <span class="icon is-small is-left"></span>
                            <p class="help"></p>
                        </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <button class="button is-success is-link" type="submit">Add Feedback
                            </button>
                        </div>
                        <div class="control">
                            <button class="button is-text" type="reset">Discard</button>
                        </div>
                    </div>
                    <form:errors path="*"/>
                    <sec:csrfInput/>
                </form:form>
            </div>
            <div class="column">
            </div>
        </div>
    </div>
</section>
<jsp:include page="../media/footer.jsp"/>
</body>
</html>
