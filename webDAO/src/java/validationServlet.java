import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Najaf Zawar
 */
@WebServlet(urlPatterns = {"/validationServlet"})
public class validationServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String uname = request.getParameter("textUserName");
            String pass = request.getParameter("textPass");
            if ("admin".equals(uname) && "admin".equals(pass))
            {
                HttpSession session = request.getSession();
                session.setAttribute("textUserName", uname);
                response.sendRedirect("viewServlet");
            }
            else
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet enteryServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h3>Please type correct User Name or Passowrd</h3><br><br>");
                out.println("<form method='POST' action=validationServlet>");
                out.println("User Name <input type ='text' name='textUserName' / required><br>");
                out.println("Password <input type ='text' name='textPass' required><br>");
                out.println("<input type='submit' value='Login'>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }
}
