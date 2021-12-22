import java.sql.*;
class student
{
    int id, rollNo, cnic;
    String name, degree, desig;
}
public class daoStudent {
    Connection con=null;
    void connection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentdb";
            con = DriverManager.getConnection(url, "root", "");
        } catch (Exception ex) {
            System.out.println("Student_Connection Error try again");
            System.out.println(ex);
        }
    }    int insert(student s)
    {
        int ret = 0;
        try
        {
            connection();
            String qry = "insert into tbldata values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.id);
            pst.setString(2, s.name);
            pst.setInt(3, s.rollNo);
            pst.setInt(4, s.cnic);
            pst.setString(5, s.degree);
            pst.setString(6, s.desig);
            ret=pst.executeUpdate();
        }catch(Exception ex)
        {
            System.out.println("Error in dao insert");
            System.out.println(ex);
        }
        return ret;
    }
    int update(student s)
    {
        int ret = 0;
        try
        {
            connection();
            String qry = "update tbldata set= name=?, rollNo=?, cnic=?, degree=?, desig=? where id = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, s.id);
            pst.setString(2, s.name);
            pst.setInt(3, s.rollNo);
            pst.setInt(4, s.cnic);
            pst.setString(5, s.degree);
            pst.setString(6, s.desig);
            ret = pst.executeUpdate();
        }catch(Exception ex)
        {
            System.out.println("Error in doaUpdate");
            System.out.println(ex);
        }
        return ret;
    }
}

