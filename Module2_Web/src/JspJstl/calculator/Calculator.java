package JspJstl.calculator;

public class Calculator {
    private static double result;

    public Calculator() {
    }


    public static double calculator(double fistOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                result =fistOperand + secondOperand;
                 break;
            case '-':
                result = fistOperand - secondOperand;
                break;
            case '*':
                result = fistOperand * secondOperand;
                break;
            case '/':
                if(secondOperand !=0) {
                    result = fistOperand / secondOperand;
                } else {
                    throw new RuntimeException("Không thực hiện được phép chia cho 0");
                }
                break;
            default:
                throw new RuntimeException("Lỗi");

        }
            return result;
    }
}
