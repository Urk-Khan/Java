<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>validation</title>
    </head>
    <body>
        
         <form action="valid.jsp" method="post">
         
            Password<input type="password" name="psw" required><br>
            <input type="submit" value="Login" name="login">
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
boolean SelectById(studenttb s) {
    boolean find=false;

        ResultSet ret = null;
        try{
            connection();
            String qry = "select * from tbls where password =?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, s.password);
            ret = pst.executeQuery();
            while(ret.next()){
                
                
             find=true;   
                
                
            }
            
        } 
        catch (Exception ex) {
            System.out.println("Error in selected by ID, try again");
            System.out.println(ex);
        }
        return find;
    }
}
     
        studenttb st=new studenttb();
          
          DAOStudent dos=new DAOStudent();
          
st.password=request.getParameter("psw");
   boolean res=dos.SelectById(st);
   if(request.getParameter("login")!=null){
if(res==true){

response.sendRedirect("Home.jsp");
}
else{
response.sendRedirect("index.jsp");
}
   }
        %>
    </body>
</html>
