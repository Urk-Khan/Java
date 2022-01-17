import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/deleteServlet"})
public class deleteServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (request.getSession().getAttribute("textUserName")==null)
            {
                response.sendRedirect("index.html");
            }
            else
            {
                student s =new student();
                s.id=Integer.parseInt(request.getParameter("id"));
                DAOStudent dao = new DAOStudent();
                int res=dao.delete(s);
                response.sendRedirect("viewServlet");
            }
        }
    }
}
