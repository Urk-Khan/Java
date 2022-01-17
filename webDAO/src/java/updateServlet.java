import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/updateServlet"})
public class updateServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            if (request.getSession().getAttribute("textUserName")==null)
            {
                response.sendRedirect("index.html");
            }
            else
            {
                student s =new student();
                DAOStudent dao = new DAOStudent();
                s.id = Integer.parseInt(request.getParameter("id"));
                s.name = request.getParameter("name");
                s.uName = request.getParameter("uName");
                s.cnic = request.getParameter("cnic");
                s.degree = request.getParameter("degree");
                s.cell = request.getParameter("cell");
               
                ResultSet se=dao.Selectbyid(s);
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Update</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='POST' action='saveServlet'>");
                out.println("id <input type ='text' name='textid'  / value="+s.id+" required><br>");
                out.println("Name <input type ='text' name='textName'  / value="+s.name+" required><br>");
                out.println("UserName <input type ='text' name='textUserName'  / value="+s.uName+" required><br>");
                out.println("CNIC <input type ='text' name='textcnic' value="+s.cnic+"  required><br>"); 
                out.println("Dagree <input type ='text' name='textDegree' value="+s.degree+" required><br>");
                out.println("Contact <input type ='text' name='textcell' value="+s.cell+" required><br>");
                out.println("<input type='submit' value='Update'>");
                
                out.println("</form>");
                out.println("<a href=\'http://localhost:8080/webDAO/viewServlet'>Back </a>");
                out.println("<a href=http://localhost:8080/webDAO/logout>  Log Out</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}