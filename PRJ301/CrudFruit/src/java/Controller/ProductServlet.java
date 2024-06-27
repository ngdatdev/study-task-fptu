/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Fruit;
import Model.FruitDB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author admin
 */
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "LIST";
        }

        try {
            switch (action) {
                case "DELETE":
                    deleteFruit(request, response);
                    break;
                case "EDIT":
                    updateFruit(request, response);
                    break;
                case "UPDATE":
                    updateFruit(request, response);
                    break;
                default:
                    listFruits(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            action = "LIST"; // or any other default action you want to perform
        }

        switch ("UPDATE") {
            case "DELETE":
                deleteFruit(request, response);
                break;
            case "ADD":
                insertFruit(request, response);
                break;
            case "UPDATE":
                updateFruit(request, response);
                break;
            default:
                listFruits(request, response);
                break;
        }

    }

    private void listFruits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Fruit> allFruits = FruitDB.listAll();
        request.setAttribute("allFruits", allFruits);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void insertFruit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = 0.0; // Default value or handle error if necessary

        String priceParam = request.getParameter("price");
        if (priceParam != null && !priceParam.isEmpty()) {
            price = Double.parseDouble(priceParam);
        }

        Fruit newFruit = new Fruit(10 + new Random().nextInt(), name, description, price);
        FruitDB.newFruit(newFruit);

        response.sendRedirect("index.jsp");
    }

    private void updateFruit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = 0;
        if (idParam != null && !idParam.isEmpty()) {
            id = Integer.parseInt(idParam);
        } else {
            // Handle error or redirect appropriately
            // For example, you can throw a ServletException or redirect to an error page
            throw new ServletException("ID parameter is missing or empty.");
        }

        String name = request.getParameter("name");
        String description = request.getParameter("description");

        double price = 0.0;
        String priceParam = request.getParameter("price");
        if (priceParam != null && !priceParam.isEmpty()) {
            price = Double.parseDouble(priceParam);
        } else {
            // Handle error or redirect appropriately
            // For example, you can throw a ServletException or redirect to an error page
            throw new ServletException("Price parameter is missing or empty.");
        }

        Fruit fruit = new Fruit(id, name, description, price);
        FruitDB.update(fruit);

        response.sendRedirect("index.jsp");
    }

    private void deleteFruit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FruitDB.delete(id);
        response.sendRedirect("index.jsp");
    }

}
