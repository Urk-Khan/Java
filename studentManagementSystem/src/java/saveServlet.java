import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/saveServlet"})
public class saveServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (request.getSession().getAttribute("textUserName")!=null)
            {
                Student s = new Student();
                
                DAOStudent dao = new DAOStudent();
                int id = Integer.parseInt(request.getParameter("textid"));
                String name=request.getParameter("textName");
                String cnic = request.getParameter("textcnic");
                String rollNo = request.getParameter("textRollt");
                String degree= request.getParameter("textDegree");
                String department= request.getParameter("textDepartment");
                int x=0;
                x = dao.insert(s);
                
                
                if (x>0)
                {
                    out.print("Data Inserted");
                   // response.sendRedirect("viewServlet");
                }
                {
                    out.print("error in saveServlet");
                }
                
            }
            else
            {
                response.sendRedirect("index.html");
            }
    }
       }
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.
