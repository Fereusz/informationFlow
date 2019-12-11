<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 10.12.2019
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
        <div class="container">
            <div class="navbar-menu">
                <div class="navbar-start">
                    <a class="navbar-item" href="/">
                        Home
                    </a>
                    <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>

                    <div class="navbar-item has-dropdown is-hoverable">
                        <a class="navbar-link">
                            More...
                        </a>

                        <div class="navbar-dropdown">
                            <a class="navbar-item">
                                Some link
                            </a>
                            <%-- Tutaj kolejne linki w menu dodatkowym --%>
                        </div>
                    </div>
                </div>

                <div class="navbar=end">
                    <div class="navbar-item">
                        <div class="buttons">
                            <sec:authorize access="isAnonymous()">
                            <a class="button is-primary" href="/register">
                                <strong>Register</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Login</strong>
                            </a>
                            </sec:authorize>

                            <sec:authorize access="isAuthenticated()">

                                <a class="button is-primary" href="/feedback">
                                    <strong>Feedback list</strong>
                                </a>
                                <a class="button is-primary" href="/addfeedback">
                                    <strong>Add Feedback</strong>
                                </a>
                                <a class="button is-primary" href="/addmanager">
                                    <strong>Add Fund Manager</strong>
                                </a>
                                <a class="button is-primary" href="/addfund">
                                    <strong>Add Fund</strong>
                                </a>
                                <a class="button is-primary" href="/user">
                                    <strong>Account</strong>
                                </a>
                                <form method="post" action="/logout">
                                    <button class="button is-link" type="submit">Wyloguj</button>
                                    <sec:csrfInput/>
                                </form>
                            </sec:authorize>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>
