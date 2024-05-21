/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import model.Student;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 *
 * @author admin
 */
public class UpdateStudentServlet extends HttpServlet {

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
//        List<Student> students = (List<Student>)request.getParameter("students");
//        int updateId = Integer.parseInt(request.getParameter("updateId"));
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<Student> students = mapper.readValue(studentsJson, new TypeReference<List<Student>>(){});
//
//        Student studentToUpdate = null;
//        for (Student student : students) {
//            if (student.getId() == updateId) {
//                studentToUpdate = student;
//                break;
//            }
//        }

//        if (studentToUpdate != null) {
//            request.setAttribute("student", studentToUpdate);
//            request.getRequestDispatcher("updateStudentForm.jsp").forward(request, response);
//        } else {
//            response.sendRedirect("errorPage.jsp");
//        }
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

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = request.getParameter("gender").equalsIgnoreCase("male");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        Student updatedStudent = new Student();
        updatedStudent.setId(id);
        updatedStudent.setName("hehe" + (gender == true ? "1" : "0"));
        updatedStudent.setGender(!gender);
        updatedStudent.setDob(dob);

        List<Student> students = (List<Student>) request.getSession().getAttribute("students");

        for (Student student : students) {
            if (student.getId() == id) {
                // Cập nhật thông tin của sinh viên
                student.setName(updatedStudent.getName());
                student.setGender(updatedStudent.isGender());
                student.setDob(updatedStudent.getDob());
                break;
            }
        }

        response.sendRedirect("student.jsp");
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
