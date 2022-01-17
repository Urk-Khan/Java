import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/saveServlet"})
public class saveServlet extends HttpServlet {

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
                s.id = Integer.parseInt(request.getParameter("textid"));
                s.name = request.getParameter("textName");
                s.uName = request.getParameter("textUserName");
                s.cnic = request.getParameter("textcnic");
                s.degree = request.getParameter("textDegree");
                s.cell = request.getParameter("textcell");
                
                int res=dao.insert(s);
                if (res > 0) {
                    response.sendRedirect("viewServlet");
                }
                else{
                    out.println("Not Inserted");

                }
            }
        }
    }
}