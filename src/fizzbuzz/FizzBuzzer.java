package fizzbuzz;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class FizzBuzzer {
    // Rules:

    private static boolean hasInstance = false;
    private static FizzBuzzer instance;

    private FizzBuzzer() {
        FizzBuzzer.instance = this;
        FizzBuzzer.hasInstance = true;
    }

    public static FizzBuzzer getFizzBuzzer() {
        if (FizzBuzzer.hasInstance) {
            return FizzBuzzer.instance;
        } else {
            return new FizzBuzzer();
        }
    }

    public void runFizzBuzz(int startPoint, int endPoint, Collection<Integer> numbersToSub) {
        for(int counter = startPoint; counter <= endPoint; counter++) {
            System.out.println(writeOutput(counter, numbersToSub));
        }
    }

    private void sub3(int number, ArrayList<String> builderList) {
        // 3: Print Fizz when divisible by 3 - comes first
        if (number % 3 == 0) {
            builderList.add("Fizz");
        }
    }

    private void sub5(int number, ArrayList<String> builderList) {
        // 5: Print Buzz when divisible by 5 - follows Fizz
        if (number % 5 == 0) {
            builderList.add("Buzz");
        }
    }

    private void sub7(int number, ArrayList<String> builderList) {
        // 7: Print Bang when divisible by 7 - follows Buzz
        if (number % 7 == 0) {
            builderList.add("Bang");
        }
    }

    private void sub11(int number, ArrayList<String> builderList) {
        // 11: Print Bong when divisble by 11 - replaces fizz, buzz, bang
        if (number % 11 == 0) {
            builderList.remove("Fizz");
            builderList.remove("Fuzz");
            builderList.remove("Bang");
            builderList.add("Bong");
        }
    }

    private void sub13(int number, ArrayList<String> builderList) {
        // 13: Print Fezz when divisible by 13 - comes immediately before first B word if present
        if (number % 13 == 0) {
            int insertIndex = builderList.size();
            for (int index = 0; index < builderList.size(); index++) {
                if (builderList.get(index).toLowerCase().startsWith("b")) {
                    insertIndex = index;
                    break;
                }
            }
            builderList.add(insertIndex, "Fezz");
        }
    }

    private void sub17(int number, ArrayList<String> builderList) {
        // 17: Reverse order of words when divisible by 17
        if (number % 17 == 0) {
            Collections.reverse(builderList);
        }
    }

    private String writeOutput(int number, Collection<Integer> numbersToSub) {

        ArrayList<String> builderList = applyRules(number, numbersToSub);

        String output = String.join("",builderList);

        if (output.equals("")) {
            return String.valueOf(number);
        } else {
            return output;
        }
    }

    private ArrayList<String> applyRules(int number, Collection<Integer> numbersToSub) {
        ArrayList<String> builderList = new ArrayList<>();

        if (numbersToSub.contains(3)) {
            sub3(number, builderList);
        }
        if (numbersToSub.contains(5)) {
            sub5(number, builderList);
        }
        if (numbersToSub.contains(7)) {
            sub7(number, builderList);
        }
        if (numbersToSub.contains(11)) {
            sub11(number, builderList);
        }
        if (numbersToSub.contains(13)) {
            sub13(number, builderList);
        }
        if (numbersToSub.contains(17)) {
            sub17(number, builderList);
        }

        return builderList;
    }

    public void printFizzBuzz(int startPoint, int endPoint, Collection<Integer> numbersToSub, String filePath) throws IOException {
        PrintWriter printer = new PrintWriter(new FileWriter(filePath));
        for (int counter = 0; counter <= endPoint; counter++) {
            printer.println(counter + ": " + writeOutput(counter, numbersToSub));
        }
    }
}
