package com.example.servlets;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.Collections;
import java.util.Enumeration;

@WebServlet("/browser")
public class BrowserCheckController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        printUserAgent(request);
        System.out.println("-----------");
        printAllHeaders(request);
    }

    private void printAllHeaders(HttpServletRequest request) {
        System.out.println("Wszystkie nagłówki:");
        Enumeration<String> headerNames = request.getHeaderNames();
        //while(headerNames.hasMoreElements()){
        //    String nextHeaderName = headerNames.nextElement();
        //     System.out.println(nextHeaderName + " " + request.getHeader(nextHeaderName));
        // }

        //to samo co wyżej tyle że wykożystana jest

        Collections.list(headerNames).stream()
                .map(name -> name + " " + request.getHeader(name))
                .forEach(System.out::println);

    }

    private static void printUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("user-agent");
        System.out.println("Przeglądarka klienta: " + userAgent);
    }

}
