package forms.controller;

import forms.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userdate")
public class UserDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = creatUserFromRequest(request);
        sendResponse(user, response);
    }

    private User creatUserFromRequest(HttpServletRequest request){
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("pass"));
        user.setGender(request.getParameter("gender"));
        user.setHobby(request.getParameterValues("hobby"));
        return user;
    }

    private void sendResponse(User user, HttpServletResponse response)throws IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<h1>Dane odebrane pomyślnie</h1>");
        writer.println("<div>");
        writer.println(user.getUserName() + "<br>");
        writer.println(user.getPassword() + "<br>");
        writer.println(user.getGender() + "<br>");
        writer.println("Hobby:");
        for (String hobby:user.getHobby()){
            writer.println(" " + hobby);
        }
        writer.println("<div>");
        writer.println("</body>");
        writer.println("</html>");
        writer.println("");
    }
}
