import java.time.LocalDate;

public class Transaction {
    private String transactionID;
    private LocalDate date;
    private String description;
    private double debitAccount;
    private double creditAccount;
    private double amount;
    private int referenceNumber;
    private String type;
    private String createdBy;
    private String status;

    public Transaction(String transactionID, LocalDate date, String description, double debitAccount,
                       double creditAccount, double amount, int referenceNumber,
                       String type, String createdBy, String status) {
        this.transactionID = transactionID;
        this.date = date;
        this.description = description;
        this.debitAccount = debitAccount;
        this.creditAccount = creditAccount;
        this.amount = amount;
        this.referenceNumber = referenceNumber;
        this.type = type;
        this.createdBy = createdBy;
        this.status = status;
    }

    public void display() {
        System.out.println("---------------------------------------------------");
        System.out.println("📌 Transaction ID: " + transactionID);
        System.out.println("📅 Date: " + date);
        System.out.println("📝 Description: " + description);
        System.out.println("💳 Debit Account: " + debitAccount);
        System.out.println("💰 Credit Account: " + creditAccount);
        System.out.println("💵 Amount: " + amount);
        System.out.println("📄 Reference #: " + referenceNumber);
        System.out.println("🔖 Type: " + type);
        System.out.println("👤 Created By: " + createdBy);
        System.out.println("📌 Status: " + status);
    }
}
