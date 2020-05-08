package P1javalanguage.baitap.twentyPrime;

public class TwentyPrime {
    public static void main(String[] args) {
        int count = 0;
        int number = 2;
        StringBuilder result = new StringBuilder();
        while (count <= 20) {
            if (checkPrime(number)) {
                result.append(number).append(" - ");
                count++;
            }
            if (++number % 2 == 0){
                number++;
            }
        }
        System.out.println(result);
    }
    public static boolean checkPrime(int num) {
        boolean isPrime = true;
        if (num == 2) return true;
        for (int i = 2; i <= java.lang.Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
