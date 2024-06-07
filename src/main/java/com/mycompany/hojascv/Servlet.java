/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.hojascv;

import com.mycompany.hojascv.models.CV;
import com.mycompany.hojascv.models.Person;
import com.mycompany.hojascv.infrastructure.JSON;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebServlet("/index")
public class Servlet extends HttpServlet {

    private ArrayList<CV> CVs;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String delete = request.getParameter("delete");
        JSON json = this.getJSON(request);
        CVs = json.getSave();

        if (delete != null) {
            if (delete.equals("True")) {
                CVs.remove(getById(id));
                json.save(CVs);
                request.setAttribute("CVs", CVs);
                request.getRequestDispatcher("/List.jsp").forward(request, response);
            }
        }

        if (id == null) {

            request.setAttribute("CVs", CVs);
            request.getRequestDispatcher("/List.jsp").forward(request, response);
        } else if (Integer.parseInt(id) < 0) {
            int c = 0;
            while (getById(c + "") != null) {
                c += 1;
            }
            CV cv = new CV(new Person(c + ""));
            CVs.add(cv);
            json.save(CVs);
            request.setAttribute("CV", cv);
            request.getRequestDispatcher("/CVMenu.jsp").forward(request, response);
        } else {
            CV cv = getById(id);
            request.setAttribute("CV", cv);
            request.getRequestDispatcher("/CVMenu.jsp").forward(request, response);
        }
    }

    protected void saveCV(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        JSON json = this.getJSON(request);
        CVs = json.getSave();
        CV cv = getById(request.getParameter("Id"));
        cv.getPerson().setName(request.getParameter("Name"));
        cv.getPerson().setAge(Integer.parseInt(request.getParameter("Age")));
        cv.getPerson().setSex(request.getParameter("Sex").charAt(0));
        cv.setGeneral(request.getParameter("General"));
        cv.setExperience(request.getParameter("Experience"));
        cv.setSkills(request.getParameter("Skills"));

        json.save(CVs);

        request.setAttribute("CVs", CVs);
        request.getRequestDispatcher("/List.jsp").forward(request, response);
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
        saveCV(request, response);
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

    private JSON getJSON(HttpServletRequest request) {
        ServletContext context = request.getServletContext();
        JSON json = new JSON(context.getRealPath("/WEB-INF/classes/CVs.json"));
        return json;
    }

    private CV getById(String id) {
        for (CV cv : CVs) {
            if (id.contains(cv.getId())) {
                return cv;
            }
        }
        return null;
    }
}
