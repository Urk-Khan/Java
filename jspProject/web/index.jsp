<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.servlet.java.*"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in</title>
    </head>
    <body>
        <form action="index.jsp" method="post">
            User Name<input type="text" name="name" required><br>
            Password<input type="password" name="psw" required><br>
            <input type="submit" value="Login" name="insert">
        </form> 
            
            <%
            
class studenttb{
    
    
     String uname;
    String password;
    
}
class DAOStudent {
                Connection con=null;
                void connection(){
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        String url = "jdbc:mysql://localhost:3306/studentsform";
                        con = DriverManager.getConnection(url, "root", "");
                    } catch (Exception ex) {
                        System.out.println("Student_Connection Error try again");
                        System.out.println(ex);
                    }
                }
                int insert(studenttb s)
                {
                    int ret = 0;
                    try
                    {
                        connection();
                        String qry = "insert into tbls values(?,?)";
                        PreparedStatement pst = con.prepareStatement(qry);
                       
                        pst.setString(1, s.uname);
                        pst.setString(2, s.password);
                        ret=pst.executeUpdate();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    return ret;
                }
}
            
          studenttb ss=new studenttb();
          DAOStudent dos=new DAOStudent();
           ss.uname=request.getParameter("name");
           ss.password=request.getParameter("psw");
           if(request.getParameter("insert")!=null){
           
           int res=dos.insert(ss);
           response.sendRedirect("valid.jsp");
           }

%>
      
    </body>
</html>
