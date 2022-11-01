package com.example.web_app_jee_semvi;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        System.out.println("Cześć " + firstName + " " + lastName);
    }
}