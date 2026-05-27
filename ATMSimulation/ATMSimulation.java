import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double balance = 8500.50;
        String pin = "1234";
        int attempts = 3;

        ArrayList<String> transactionHistory = new ArrayList<>();

        double dailyWithdrawn = 0;
        final double DAILY_LIMIT = 20000;

        System.out.println("=== Welcome to SecureBank ATM ===\n");

        // PIN LOGIN
        boolean loggedIn = false;

        while (attempts > 0 && !loggedIn) {

            System.out.print("Enter your 4-digit PIN: ");
            String enteredPin = scanner.nextLine();

            if (enteredPin.equals(pin)) {

                System.out.println(">> Login Successful!\n");
                loggedIn = true;

            } else {

                attempts--;
                System.out.println("!! Incorrect PIN. " + attempts + " attempts remaining.");
            }
        }

        if (!loggedIn) {

            System.out.println("!! Too many failed attempts. Card blocked!");
            scanner.close();
            return;
        }

        // MAIN MENU LOOP
        while (true) {

            System.out.println("\n" + "=".repeat(40));
            System.out.println("              ATM MENU");
            System.out.println("=".repeat(40));

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Fast Cash");
            System.out.println("5. Transaction History");
            System.out.println("6. Change PIN");
            System.out.println("7. Exit");

            System.out.println("=".repeat(40));

            System.out.print("\nEnter your choice (1-7): ");
            String choice = scanner.nextLine();

            switch (choice) {

                // CHECK BALANCE
                case "1":

                    System.out.printf("\n-- Current Balance: Rs. %.2f\n", balance);
                    break;

                // DEPOSIT MONEY
                case "2":

                    System.out.print("\nEnter amount to deposit: Rs. ");

                    try {

                        double amount = Double.parseDouble(scanner.nextLine());

                        if (amount > 0) {

                            balance += amount;

                            transactionHistory.add(
                                    "Deposited: +Rs. " + String.format("%.2f", amount));

                            System.out.printf(
                                    ">> Rs. %.2f deposited successfully!\n", amount);

                            System.out.printf(
                                    "-- New Balance: Rs. %.2f\n", balance);

                        } else {

                            System.out.println("!! Amount must be greater than zero.");
                        }

                    } catch (Exception e) {

                        System.out.println("!! Invalid amount!");
                    }

                    break;

                // WITHDRAW MONEY
                case "3":

                    System.out.print("\nEnter amount to withdraw: Rs. ");

                    try {

                        double amount = Double.parseDouble(scanner.nextLine());

                        if (amount <= 0) {

                            System.out.println("!! Amount must be greater than zero.");

                        } else if (amount > balance) {

                            System.out.println("!! Insufficient Balance!");

                        } else if (dailyWithdrawn + amount > DAILY_LIMIT) {

                            System.out.println("!! Daily withdrawal limit exceeded!");

                        } else {

                            balance -= amount;
                            dailyWithdrawn += amount;

                            transactionHistory.add(
                                    "Withdrawn: -Rs. " + String.format("%.2f", amount));

                            System.out.printf(
                                    ">> Rs. %.2f withdrawn successfully!\n", amount);

                            System.out.printf(
                                    "-- Remaining Balance: Rs. %.2f\n", balance);
                        }

                    } catch (Exception e) {

                        System.out.println("!! Invalid amount!");
                    }

                    break;

                // FAST CASH
                case "4":

                    System.out.println("\nFast Cash Options:");

                    System.out.println("1. Rs. 500     2. Rs. 1000");
                    System.out.println("3. Rs. 2000    4. Rs. 5000");

                    System.out.print("\nSelect option: ");

                    String fastChoice = scanner.nextLine();

                    double fastAmount = 0;

                    switch (fastChoice) {

                        case "1":
                            fastAmount = 500;
                            break;

                        case "2":
                            fastAmount = 1000;
                            break;

                        case "3":
                            fastAmount = 2000;
                            break;

                        case "4":
                            fastAmount = 5000;
                            break;

                        default:

                            System.out.println("!! Invalid option!");
                            break;
                    }

                    if (fastAmount > 0) {

                        if (fastAmount > balance) {

                            System.out.println("!! Insufficient balance!");

                        } else if (dailyWithdrawn + fastAmount > DAILY_LIMIT) {

                            System.out.println("!! Daily limit exceeded!");

                        } else {

                            balance -= fastAmount;
                            dailyWithdrawn += fastAmount;

                            transactionHistory.add(
                                    "Fast Cash: -Rs. " + fastAmount);

                            System.out.println(
                                    ">> Rs. " + fastAmount + " dispensed successfully!");
                        }
                    }

                    break;

                // TRANSACTION HISTORY
                case "5":

                    System.out.println("\n" + "-".repeat(50));

                    System.out.println("           TRANSACTION HISTORY");

                    System.out.println("-".repeat(50));

                    if (transactionHistory.isEmpty()) {

                        System.out.println("-- No transactions yet.");

                    } else {

                        for (String transaction : transactionHistory) {

                            System.out.println(transaction);
                        }
                    }

                    System.out.printf(
                            "-- Current Balance : Rs. %.2f\n", balance);

                    System.out.println("-".repeat(50));

                    break;

                // CHANGE PIN
                case "6":

                    System.out.print("Enter current PIN: ");
                    String currentPin = scanner.nextLine();

                    if (currentPin.equals(pin)) {

                        System.out.print("Enter new 4-digit PIN: ");
                        String newPin = scanner.nextLine();

                        if (newPin.length() == 4 && newPin.matches("\\d+")) {

                            pin = newPin;

                            System.out.println(">> PIN changed successfully!");

                        } else {

                            System.out.println("!! PIN must be exactly 4 digits.");
                        }

                    } else {

                        System.out.println("!! Incorrect current PIN.");
                    }

                    break;

                // EXIT
                case "7":

                    System.out.println(
                            "\nThank you for using SecureBank ATM.");

                    scanner.close();
                    return;

                // INVALID CHOICE
                default:

                    System.out.println(
                            "!! Invalid choice! Please select 1 to 7.");
            }
        }
    }
}