import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/saveServlet"})
public class saveServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
            if (request.getSession().getAttribute("textUserName")!=null)
            {
                
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                student s = new student();
                daoStudent dao = new daoStudent();
                s.id = Integer.parseInt(request.getParameter("textid"));
                s.name=request.getParameter("textName");
                s.cnic = request.getParameter("textcnic");
                s.rollNo = request.getParameter("textRollt");
                s.degree= request.getParameter("textDegree");
                s.department= request.getParameter("textDepartment");
                int x = dao.insert(s);
                
                if (x>0)
                {
                    response.sendRedirect("viewServlet");;
                }
                {
                    out.print("error in saveServlet");
                }
                }
            }
            else
            {
                response.sendRedirect("index.html");
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
