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
            
            String sid = session.getAttribute("textid").toString();
            String sname = session.getAttribute("textName").toString();
            String scnic = session.getAttribute("textCnic").toString();
            String sdegree = session.getAttribute("textDegree").toString();
            
            out.print("id: " + sid + "Name: " + sname + "cnic: " + scnic + "Degree: " + sdegree);
            out.print("hellow");
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet viewServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Hello</h1>");
//            
//            out.println("</body>");
//            out.println("</html>");
//            
//            
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
