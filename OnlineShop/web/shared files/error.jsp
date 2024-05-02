<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>

    <main>
        <section>
            <h2>Error</h2>
            <p>An error occurred while processing your request.</p>
            <p>Error Details: <%= exception.getMessage() %></p>
        </section>
    </main>

<%@ include file="shared/Footer.jsp" %>
