package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("number"));

            if (num < 0) {
                throw new IllegalArgumentException("Number must be positive");
            }

            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Output HTML
            out.println("<html><body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Entered Number: " + num + "</p>");

            if (isPrime) {
                out.println("<h3 style='color:green;'>" + num + " is a Prime Number</h3>");
            } else {
                out.println("<h3 style='color:red;'>" + num + " is NOT a Prime Number</h3>");
            }

            out.println("<a href='index.html'>Check Another</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}