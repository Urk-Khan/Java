import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/contactSrvlet"})
public class contactSrvlet extends HttpServlet {

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
                if (request.getSession().getAttribute("textContact")!= null)
                {
                    String scontact = session.getAttribute("textContact").toString();

                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet profileServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Contact Us At: "+scontact+"</h1><br>");
                    out.println("<a href=\'http://localhost:8080/WebApplicationTask/mainServlet'>Back</a>");
                out.println("<a href=\'http://localhost:8080/WebApplicationTask/logOutSrvlet'>Log out</a>");
                    out.println("</body>");
                    out.println("</html>");
                }
                else
                {
                    out.println("<h1>first enter data <a href=\'http://localhost:8080/WebApplicationTask/enteryServlet'>Home</a></h1>");
                }
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
