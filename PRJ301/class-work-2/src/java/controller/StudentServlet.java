package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("student.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String numberStr = request.getParameter("number");
        int n = 0;
        try {
            n = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid number format.");
        }

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student s = new Student();
            s.setId(i);
            s.setName("Dat" + i);
            s.setGender(i % 2 == 0);
            s.setDob(LocalDate.now());
            students.add(s);
        }
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("student.jsp");
        rd.forward(request, response);
        
    }

    @Override
    public String getServletInfo() {
        return "Student servlet to generate and display student details";
    }
}
