<%@page import="shortener.ShortUrl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>url shortener</title>
<link type="text/css" rel="stylesheet" href="styles/demo.css">

</head>
<body>

<h1>Url Shortener</h1>
<div class="form">
	<form action="shortener" method="post">
		Url à raccourcir :
		<input type="text" name="url" size="50"></input>
		<button type="submit">Go !</button>	
	</form>
</div>

<div class="result">
	<% 
		Object url = request.getSession().getAttribute("shortUrl");
		if (url!=null) {
			ShortUrl shortUrl = (ShortUrl)url;
			out.print(shortUrl.getId());
			out.print(" -> ");
			out.println(shortUrl.getLongUrl());
		}
	%>
</div>

</body>
</html>