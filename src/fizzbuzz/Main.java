package fizzbuzz;

public class Main {

    public static void main(String args[]) {
        int endPoint = 100;
        FizzBuzzer fizzBuzzer = FizzBuzzer.getFizzBuzzer();
        fizzBuzzer.runFizzBuzz(endPoint);
    }

}
