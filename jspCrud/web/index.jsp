<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@ page import="com.Demo" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login
        </title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method="POST" action="index.jsp" >
            User Name <input type = "text" name="textUserName" required>
            Password <input type="password" name="textPass" required><br>
            <input type="submit" value="index.jsp" name="login">
        </form>
        <%
            class staff
            {
                int id, cnic, celll;
                String name, uName, address, pass;
            }
            class DAOclass
            {
                Connection con=null;
                void connection(){
                try 
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:3306/studentdb";
                    con = DriverManager.getConnection(url, "root", "");
                } catch (Exception ex) {
                    System.out.println("Student_Connection Error try again");
                    System.out.println(ex);
                    }
                }
            }
            staff s = new staff();
            DAOclass dao= new DAOclass();
            s.uName = request.getParameter(string)
            }
        %>
    </body>
</html>
