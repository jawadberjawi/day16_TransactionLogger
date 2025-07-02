import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Transaction> journal = new ArrayList<>();
        System.out.println("📒 Welcome to the Journal Entry Logger");

        int count;

        while (true) {
            System.out.print("How many transactions would you like to enter? ");
            try {
                count = Integer.parseInt(input.nextLine());
                if (count <= 0) {
                    System.out.println("❌ Please enter a number greater than 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Please try again.");
            }
        }

        for (int i = 0; i < count; i++) {
            System.out.println("\n📝 Enter details for transaction #" + (i + 1));

            System.out.print("Transaction ID: ");
            String transactionID = input.nextLine();

            LocalDate date = null;
            while (date == null) {
                System.out.print("Date (YYYY-MM-DD): ");
                String dateInput = input.nextLine();
                try {
                    date = LocalDate.parse(dateInput);
                } catch (DateTimeParseException e) {
                    System.out.println("❌ Invalid date format. Please use YYYY-MM-DD.");
                }
            }

            System.out.print("Description: ");
            String description = input.nextLine();

            double debitAccount;
            while (true) {
                System.out.print("Debit Account: ");
                try {
                    debitAccount = Double.parseDouble(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid number.");
                }
            }

            double creditAccount;
            while (true) {
                System.out.print("Credit Account: ");
                try {
                    creditAccount = Double.parseDouble(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid number.");
                }
            }

            if (debitAccount != creditAccount) {
                System.out.println("❌ Transaction Rejected: Debit and Credit must be equal.");
                i--; // go back one step
                continue;
            }

            double amount;
            while (true) {
                System.out.print("Amount: ");
                try {
                    amount = Double.parseDouble(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid number.");
                }
            }

            int referenceNumber;
            while (true) {
                System.out.print("Reference Number: ");
                try {
                    referenceNumber = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Please enter a valid integer.");
                }
            }

            String type;
            do {
                System.out.print("Type: ");
                type = input.nextLine().trim();
            } while (type.isEmpty());

            String createdBy;
            do {
                System.out.print("Created By: ");
                createdBy = input.nextLine().trim();
            } while (createdBy.isEmpty());

            String status;
            do {
                System.out.print("Status (Approved / Pending / Rejected): ");
                status = input.nextLine().trim();
            } while (
                    !status.equalsIgnoreCase("Approved") &&
                            !status.equalsIgnoreCase("Pending") &&
                            !status.equalsIgnoreCase("Rejected")
            );

            Transaction t = new Transaction(
                    transactionID, date, description,
                    debitAccount, creditAccount, amount,
                    referenceNumber, type, createdBy, status
            );

            journal.add(t);
        }

        // ✅ Display all transactions
        System.out.println("\n📋 All Transactions:");
        for (Transaction t : journal) {
            t.display();
        }

        input.close();
    }
}











