<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Import external css file -->
<link href="<%=request.getContextPath()%>/style/css/browser.css"
	rel="stylesheet" type="text/css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/style/css/browser.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
	    <header>
        <div class="logo">
            <a href="#">
                <img alt="logo sito" src="<%=request.getContextPath()%>/images/logoFoundIt!.png" height="80px" width="180px">
            </a>
        </div>
        <div class="menu" id="MenuResponsive">
            <nav>
                <ul>
                    <li>
                    	<a href="#"><i class="fa fa-sign-in" aria-hidden="true"> Login</i></a>
                    </li>
                    <li>
                    	<a href="<%=request.getContextPath()%>/jsp/registrazione.jsp"><i class="fa fa-user-plus" aria-hidden="true"></i>Registrazione</a>
                    </li>
                </ul>
            </nav>
        </div>    
    </header>
	
</body>
</html>