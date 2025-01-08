<%@page import="com.tka.model.User"%>
<%@page import="java.util.ArrayList"%>
<% 
ArrayList<User>alUser = (ArrayList<User>)request.getAttribute("manyusers");

for(User user : alUser){
	out.println(user.getPassword());
	out.println(user.getUserName());


}
%>