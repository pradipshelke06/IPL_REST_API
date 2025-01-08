
<%
out.println(request.getAttribute("message"));
%>
<form action="usercheck">
		UserName : <input type="text"name="userName"></input> <br> <br>
		Password : <input type="text"name="password"></input> <br> <br>
					<input type="submit" value="Signin"/>
</form>
