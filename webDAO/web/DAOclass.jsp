<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            class staff
            {
                int id, cnic, cell;
                String name, uName, address;
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
                int insert(staff s)
                {
                    int ret = 0;
                    try
                    {
                        connection();
                        String qry = "insert into tblstaff values(?,?,?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(qry);
                        pst.setInt(1, s.id);
                        pst.setString(2, s.name);
                        pst.setString(3, s.uName);
                        pst.setInt(4, s.cnic);
                        pst.setString(5, s.address);
                        pst.setInt(6, s.cell);
                        ret=pst.executeUpdate();
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex);
                    }
                    return ret;
                }
            }
        %>
    </body>
</html>
