import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/enteryServlet"})
public class enteryServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (request.getSession().getAttribute("textUserName")==null)
            {
                response.sendRedirect("index.html");
            }
            else
            {
                student s = new student();
                DAOStudent dao = new DAOStudent();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet enteryServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='POST' action='saveServlet'>");
                out.println("Id <input type ='text' name='textid' / required><br>");
                out.println("Name <input type ='text' name='textName' / required><br>");
                out.println("UserName <input type ='text' name='textUserName' / required><br>");
                out.println("cnic <input type ='text' name='textcnic' / required><br>");
                out.println("Dagree <input type ='text' name='textDegree' required><br>");
                out.println("cell <input type ='text' name='textcell' required><br>");
                out.println("<input type='submit' value='Insert'>");
                out.println("</form>");
                out.println("<a href=\'http://localhost:8080/webDAO/viewServlet'>Back </a>");
                out.println("<a href=http://localhost:8080/webDAO/logout>  Log Out</a>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}