package WebOverview.ProductDiscount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String product = request.getParameter("product");
        double price = Double.parseDouble(request.getParameter("Price"));
        double discount = Double.parseDouble(request.getParameter("Discount"));
        double amount;
        double discountPrice;
        PrintWriter writer = response.getWriter();
        writer.println("<h3> Product Description: " + product + "</h3>");
        writer.println("<h3> List Price: " + price + "</h3>");
        writer.println("<h3> Discount Percent: " + discount + "</h3>");

        amount = price * discount *0.01 ;
        discountPrice = price - amount;
        writer.println("<h3>Discount Amount: " + amount + "</h3>");
        writer.println("<h3>Discount Price: " + discountPrice + "</h3>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
