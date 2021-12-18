import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/enteryServlet"})
public class enteryServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
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
                student s = new student();
                daoStudent dao = new daoStudent();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet enteryServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<form method='POST' action=saveServlet>");
                out.println("Id <input type ='text' name='textid' / required><br>");
                out.println("Name <input type ='text' name='textName' / required><br>");
                out.println("CNIC <input type ='text' name='textCnic' required><br>");
                out.println("Dagree <input type ='text' name='textDegree' required><br>");
                out.println("Department <input type ='text' name='textDepartment' required><br>");
                out.println("Contact No <input type ='text' name='textContact' required><br><br>");
                out.println("<input type='submit' value='Insert'>");
                out.println("<a href=\'http://localhost:8080/WebApplicationTask/viewServlet'>Back</a>");
                out.println("<a href=\'http://localhost:8080/WebApplicationTask/logOutSrvlet'>Log out</a>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
