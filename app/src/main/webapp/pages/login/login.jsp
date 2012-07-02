<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>

<html>
<head>
    <title>Login Page</title>
    <style>
        .errorblock {
            color: #ff0000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<%--<body onload='document.f.j_username.focus();'>--%>
<h3>Log in my friend</h3>
<%--<sec:authorize access="!isAuthenticated()">--%>
    <%--YES, you are logged in!--%>
<%--</sec:authorize>--%>
    <div class="errorblock">
        <%--Your login attempt was not successful, try again.<br /> Caused :--%>
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>

<form name='f' action="<c:url value='/j_spring_security_check' />"
      method='POST'>

    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' />
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit"/>
            </td>
        </tr>
        <tr>
            <td colspan='2'><input name="reset" type="reset" />
            </td>
        </tr>
    </table>

</form>
</body>
</html>