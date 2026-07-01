package mypack;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author minhloan
 */
@WebServlet(name = "LoginProcess", urlPatterns = {"/LoginProcess"})
public class LoginProcess extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Nhan gia tri
        String uname = request.getParameter("username");
        String pword = request.getParameter("password");
        if(uname.equals("admin")&&pword.equals("123")){            
            //Session
            HttpSession session = request.getSession(true);
            session.setAttribute("username", uname);
            //Cookie
            int t = 60*60*24*7;
            Cookie c1 = new Cookie("username", uname);
            c1.setMaxAge(t);
            c1.setPath("/");
            response.addCookie(c1);
            
            Cookie c2 = new Cookie("password", pword);
            c2.setMaxAge(t);
            c2.setPath("/");
            response.addCookie(c2);
            
            response.sendRedirect("admin/admin_dashboard.jsp");
        }else{
            response.sendRedirect("login.jsp?log=false");
            //response.sendError(503, "Miss Information!");
        }
        out.print("Hello! <br/>Username: "+uname+"<br/>Password: "+pword);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
