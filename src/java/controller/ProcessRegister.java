package controller;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Profile;
import util.Validate;

public class ProcessRegister extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String emailOrPhone = request.getParameter("mobile-or-email");
        String password = request.getParameter("user-password");
        String day = request.getParameter("day");
        String month = request.getParameter("month");
        String year = request.getParameter("year");
        String sex = request.getParameter("sex");
        String university = request.getParameter("university");
        System.out.println(university);
        System.out.println(sex);
        
        RequestDispatcher dis = request.getRequestDispatcher("register.jsp");
        if (!Validate.checkName(firstName)) {
            request.setAttribute("error", "First name is in valid");
            dis.forward(request, response);
        } else if (!Validate.checkName(lastName)) {
            request.setAttribute("error", "Last name is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkEmailOrPhone(emailOrPhone)) {
            request.setAttribute("error", "Email/phone is invalid");
            dis.forward(request, response);
        } else if (!Validate.checkPassword(password)) {
            request.setAttribute("error", "Password is invalid");
            dis.forward(request, response);
        } else if (UserDAO.isDuplicateEmailOrPhone(emailOrPhone)) {
            request.setAttribute("error", "Email/phone is duplicate");
            dis.forward(request, response);
        } 
        else if (day.equals("Day")) {
            request.setAttribute("error", "Day is invalid");
            dis.forward(request, response);
        }
        else if (month.equals("Month")) {
            request.setAttribute("error", "Month is invalid");
            dis.forward(request, response);
        }
        else if (year.equals("Year")) {
            request.setAttribute("error", "Year is invalid");
            dis.forward(request, response);
        }
        else if (sex == null){
            request.setAttribute("error", "Let's input your sex!");
            dis.forward(request, response);
        }
        else {
            String birthday = String.format("%s-%s-%s", day, month, year);
            Profile profile = new Profile(firstName, lastName, emailOrPhone, 
                    password, birthday, sex);
            boolean result = UserDAO.addNewUser(profile,university);
            if (result) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Try again!");
                dis.forward(request, response);
            }
        }
        
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
