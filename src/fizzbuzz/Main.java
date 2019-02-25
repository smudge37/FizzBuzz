package fizzbuzz;

import java.util.Collection;

public class Main {

    public static void main(String args[]) {
        UserInterface ui = UserInterface.getUserInterface();
        int startPoint = ui.promptForStartPoint();
        int endPoint = ui.promptForEndPoint();
        Collection<Integer> rules = ui.promptForRules();
        FizzBuzzer fizzBuzzer = FizzBuzzer.getFizzBuzzer();
        fizzBuzzer.runFizzBuzz(startPoint, endPoint, rules);
    }

}
