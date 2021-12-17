import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/saveServlet"})
public class saveServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String id = request.getParameter("testid");
            String name = request.getParameter("testName");
            String cnic = request.getParameter("testCnic");
            String degree = request.getParameter("testDegree");
            
            HttpSession session = request.getSession();
            
            session.setAttribute("textid", id);
            session.setAttribute("textName", name);
            session.setAttribute("textCnic", cnic);
            session.setAttribute("textDegree", degree);
            
            response.sendRedirect("viewServlet");
//            out.print("id: "+id+"Name: " +name+"cnic: "+cnic+"Degree: "+degree);
            
            
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
