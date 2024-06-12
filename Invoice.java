import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Invoice {
    private int id;
    private double amount;
    private LocalDate due_date;
    private LocalDate paid_date;

    public Invoice(int id, double amount, LocalDate due_date, LocalDate paid_date) {
        this.id = id;
        this.amount = amount;
        this.due_date = due_date;
        this.paid_date = paid_date;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Invoice> invoices = new ArrayList<>();

        invoices.add(new Invoice(1, 100, LocalDate.parse("2024-03-31", formatter), null));
        invoices.add(new Invoice(2, 200, LocalDate.parse("2024-03-06", formatter), LocalDate.parse("2023-03-30", formatter)));
        invoices.add(new Invoice(3, 150, LocalDate.parse("2024-02-12", formatter), null));
        invoices.add(new Invoice(4, 300, LocalDate.parse("2024-03-02", formatter), null));
        getOverdueInvoices(invoices);

        invoices.clear();
        invoices.add(new Invoice(5, 500, LocalDate.parse("2024-03-01", formatter), LocalDate.parse("2023-02-15", formatter)));
        invoices.add(new Invoice(6, 1000, LocalDate.parse("2024-03-02", formatter), LocalDate.parse("2023-03-02", formatter)));
        invoices.add(new Invoice(7, 1500, LocalDate.parse("2024-03-03", formatter), null));
        invoices.add(new Invoice(8, 2000, LocalDate.parse("2024-03-05", formatter), LocalDate.parse("2023-01-30", formatter)));
        getOverdueInvoices(invoices);

        invoices.clear();
        invoices.add(new Invoice(9, 50, LocalDate.parse("2024-01-03", formatter), LocalDate.parse("2023-12-30", formatter)));
        invoices.add(new Invoice(10, 100, LocalDate.parse("2024-02-03", formatter), null));
        invoices.add(new Invoice(11, 150, LocalDate.parse("2024-03-03", formatter), null));
        invoices.add(new Invoice(12, 200, LocalDate.parse("2024-04-03", formatter), null));
        getOverdueInvoices(invoices);
    }

    public static void getOverdueInvoices(List<Invoice> invoices) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.parse("2024-03-03", formatter);
        ArrayList<String> overDue = new ArrayList<>();

        for (Invoice invoice : invoices) {
            if (invoice.due_date.isBefore(currentDate) && invoice.paid_date == null) {
                String temp = hashCodetoString(invoice);
                overDue.add(temp);
            }
        }

        System.out.println("Output: " + overDue);
    }

    private static String hashCodetoString(Invoice invoice) {
        int id = invoice.id;
        double amount = invoice.amount;
        String due_date = invoice.due_date.toString();
        String paid_date = invoice.paid_date == null ? "None" : invoice.paid_date.toString();

        return "{'id': " + id + ", 'amount': " + amount + ", 'due_date': " + due_date
                + ", 'paid_date':  " + paid_date + "}\n";
    }
}
