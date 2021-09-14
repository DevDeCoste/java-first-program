import com.h2.BestLoanRates;
import com.h2.MortgageCalculator;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Finance {

    public final static String BEST_LOAN_RATES = "bestLoanRates";
    public final static String SAVINGS_CALCULATOR = "savingsCalculator";
    public final static String MORTGAGE_CALCULATOR = "mortgageCalculator";

    public final static Map<String,String> commandsToUsage = Map.of(BEST_LOAN_RATES, "usage: bestLoanRates",
            SAVINGS_CALCULATOR, "usage: savingsCalculator <credits separated by ','> <debits separated by ','>",
            MORTGAGE_CALCULATOR, "usage: mortgageCalculator <loanAmount> <termInYears> <annualRate>");


    private static boolean validateCommandArguments(String[] args) {
        switch (args[0]) {
            case BEST_LOAN_RATES:
                return args.length == 1;
            case SAVINGS_CALCULATOR:
                return args.length == 3;
            case MORTGAGE_CALCULATOR:
                return args.length == 4;
        }
        return false;
    } // End validateCommandArguments Method

    private static void executeCommand(String command,String[] arguments) {
        switch(command) {
            case BEST_LOAN_RATES:
                System.out.println("Finding the best loan rates...");
                BestLoanRates.main(arguments);
                return;
            case SAVINGS_CALCULATOR:
                System.out.println("Finding your net savings...");
                MortgageCalculator.main(arguments);
                return;
            case MORTGAGE_CALCULATOR:
                System.out.println("Finding your monthly payment...");
                MortgageCalculator.main(arguments);
                return;

        }
    } // End executeCommand Method

    public static void main(String[] args) {

        String command = args[0];

        //Checking if key is available at entered command
        if(!(commandsToUsage.containsKey(command))) {
            System.out.println(command + ": command not found");
            return;
        }

        Boolean isValidCommand = validateCommandArguments(args);

        if(!isValidCommand) {
            commandsToUsage.get(args[0]);
            return;
        }

        executeCommand(command,Arrays.copyOfRange(args, 1, args.length));



    } // End Main Method


} // End Finance Class
