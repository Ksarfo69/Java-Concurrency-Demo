package FP;

import java.util.Scanner;
import java.util.stream.Stream;

public class CommandSelector {


    /** Asks for two numbers from the command line.
     * @return the sum of the two numbers
     */
    public static int add()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first number");
        int number1 = scanner.nextInt();

        System.out.println("Please enter the second number");
        int number2 = scanner.nextInt();

        System.out.println(String.format(
                "You just added %s and %s and the result is: %s", number1, number2, number1+number2)
        );
        return number1 + number2;
    }


    /** Asks for two numbers from the command line
     * @return first number minus second number
     */
    public static int subtract()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first number");
        int number1 = scanner.nextInt();

        System.out.println("Please enter the second number");
        int number2 = scanner.nextInt();

        System.out.println(String.format(
                "You just subtracted %s from %s and the result is: %s", number2, number1, number1-number2)
        );
        return number1 - number2;
    }


    /** Takes a number
     * @return the square of the number
     */
    public static int power()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number");
        int number = scanner.nextInt();

        System.out.println(String.format("The power of %s is : %s", number, number*number));
        return number * number;
    }

    public static void calculator()
    {

        Command command = null;
        Scanner scanner;

        do {
            System.out.println("Please enter a command: ADD SUBTRACT POWER EXIT: ");



            try {
                scanner = new Scanner(System.in);
                command = Command.parse(scanner.next());


                switch (command) {
                    case ADD -> add();
                    case SUBTRACT -> subtract();
                    case POWER -> power();
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }

        }
        while (command != Command.EXIT);
    }


    public static void main(String[] args) {

        calculator();

    }

    public enum Command{
        ADD,
        SUBTRACT,
        POWER,
        EXIT;

        public static Command parse(String command)
        {
            return Stream.of(Command.values())
                    .filter(cmd -> cmd.toString().equalsIgnoreCase(command))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Invalid command."));
        }
    }
}
