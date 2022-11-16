package com.example.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Divider", value = "/Divider")
public class Divider extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        newContentType(response);
        divider(request, response);

    }

    private void newContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private void divider(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }



}
