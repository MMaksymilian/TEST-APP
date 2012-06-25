<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="org.springframework.security.web.authentication.AuthenticationProcessingFilter" %>

<form action="j_spring_security_check">
	<label for="j_username">Username</label>
	<input type="text" name="j_username" id="j_username" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>'</c:if>/>
	<br/>
	<label for="j_password">Password</label>
	<input type="password" name="j_password" id="j_password"/>
	<br/>
	<input type='checkbox' name='_spring_security_remember_me'/> Remember me on this computer.
	<br/>
	<input type="submit" value="Login"/>
</form>