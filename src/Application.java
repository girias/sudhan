import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);
            Map<String, Double> customerTransactionMap = new TreeMap<>();
            Map<Date, Double> dateTransactionMap = new TreeMap<>();

            while (scanner.nextLine().equalsIgnoreCase("Yes")) {
                System.out.println("Customer Name:");
                String custName = scanner.nextLine();

                System.out.println("Invoice date:");
                Date invoiceDate = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());


                System.out.println("Price:");
                double price = Double.parseDouble(scanner.nextLine());

                customerTransactionMap.put(custName, (customerTransactionMap.containsKey(custName) ? price + customerTransactionMap.get(custName) : price));
                dateTransactionMap.put(invoiceDate, (dateTransactionMap.containsKey(invoiceDate) ? price + dateTransactionMap.get(invoiceDate) : price));

                System.out.println("Do you want to add another invoice?(Yes/No)");

            }

            System.out.println("customerTransactionMap: " + customerTransactionMap);
            System.out.println("dateTransactionMap: " + dateTransactionMap);

        } catch (ParseException ex) {
            System.out.print("Error occurred" + ex);
        }
    }
}
