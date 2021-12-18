import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/viewServlet"})
public class viewServlet extends HttpServlet {

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
                out.println("<html><head><title>Servlet enteryServlet</title>");
                out.println("");
                out.println("</head><body><table>");
                out.println("<th>ID</th><th>Name</th><th>RollNo</th><th>Degree</th><th>Department</th><th>CellNo</th><th>Action</th><th>Action</th>");
                out.println("<tr>");
                out.println("<td>"+s.id+"</td><td>"+s.name+"</td><td>"+s.rollNo+"</td><td>"+s.degree+"</td><td>"+s.desig+"</td>");
                out.println("<td><a href=\'http://localhost:8080/studentManagementSystem/editServlet'>Edit</a></td>");
                out.println("<td><a href=http://localhost:8080/studentManagementSystem/deleteServlet>Delete</a></dt>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td><a href=http://localhost:8080/studentManagementSystem/enteryServlet>Insert New Record</a></dt>");
                out.println("</tr>");
                out.println("</table></body></html>");
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
