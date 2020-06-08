package JspJstl.calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet",urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html ; charset=UTF-8");
        double firstOperator = Double.parseDouble(request.getParameter("firstOperand"));
        double secondOperator = Double.parseDouble(request.getParameter("secondOperand"));
        char operator =request.getParameter("operator").charAt(0);
        PrintWriter writer = response.getWriter();

        try{
           double result = Calculator.calculator(firstOperator,secondOperator,operator);
            writer.println("<h1>Result: </h1>");
           writer.println("<h2>"+firstOperator+ operator + secondOperator+" = "+result+"</h2>");
        } catch (Exception e){
            writer.println(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
