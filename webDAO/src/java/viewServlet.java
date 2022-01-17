import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet(urlPatterns = {"/viewServlet"})
public class viewServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getSession().getAttribute("textUserName")==null)
            {
                response.sendRedirect("index.html");
            }
            else
            {
            
                DAOStudent dao = new DAOStudent();
                ArrayList <student> s1=dao.selectAll();
                
                
                out.println("<!DOCTYPE html>");
                out.println("<html><head><title>Servlet enteryServlet</title>");
                out.println("</head><body><table>");
                out.println("<tr>");
                out.println("<th>ID</th>"
                        + "<th>Name</th>"
                        + "<th>UserName</th>"
                        + "<th>Cnic</th>"
                        + "<th>Degree</th>"
                        + "<th>CellNo</th>"
                        + "<th>Action</th>"
                        + "<th>Action</th>");
                 out.println("</tr>");
                for(student s:s1)
                {
                    out.println("<tr>");
                    out.println("<td>"+s.id+"</td>"
                    +"<td>"+s.name+"</td>"
                    +"<td>"+s.uName+"</td>"
                    +"<td>"+s.cnic+"</td>"
                    +"<td>"+s.degree+"</td>"
                    +"<td>"+s.cell+"</td>");
                    out.println("<td><a href=\'http://localhost:8080/webDAO/updateServlet?id="+s.id+"'>Edit</a></td>");
                    out.println("<td><a href=\'http://localhost:8080/webDAO/deleteServlet?id="+s.id+"'>Delete</a></td>");
                    out.println("</tr>");
                }
                out.println("<tr>");
                out.println("<td><a href=http://localhost:8080/webDAO/enteryServlet>Insert a New Record</a></td>");
                out.println("<td><a href=http://localhost:8080/webDAO/logout>Log Out</a></td>");
                out.println("</tr>");
                out.println("</table></body></html>");   
            }
        }
    }
}