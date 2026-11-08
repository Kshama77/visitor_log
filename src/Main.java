import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VisitorManager manager = new VisitorManager();
        boolean running = true;

        while (running) {
            System.out.println("\\n===== VisitorLog =====");
            System.out.println("1. Add visitor");
            System.out.println("2. View all visitors");
            System.out.println("3. Search visitor by name");
            System.out.println("4. Remove visitor by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Visitor name: ");
                    String name = scanner.nextLine().trim();

                    System.out.print("Visit purpose: ");
                    String purpose = scanner.nextLine().trim();

                    if (name.isEmpty() || purpose.isEmpty()) {
                        System.out.println("Name and purpose cannot be empty.");
                        break;
                    }

                    System.out.print("Visit date (YYYY-MM-DD): ");
                    String dateText = scanner.nextLine().trim();

                    try {
                        LocalDate visitDate = LocalDate.parse(dateText);
                        manager.addVisitor(name, purpose, visitDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date. Please use YYYY-MM-DD.");
                    }
                    break;

                case "2":
                    manager.showVisitors();
                    break;

                case "3":
                    System.out.print("Enter visitor name: ");
                    manager.searchVisitor(scanner.nextLine().trim());
                    break;

                case "4":
                    System.out.print("Enter visitor ID to remove: ");
                    try {
                        int id = Integer.parseInt(scanner.nextLine().trim());
                        manager.removeVisitor(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "5":
                    running = false;
                    System.out.println("Thank you for using VisitorLog!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose 1 to 5.");
            }
        }

        scanner.close();
    }
}
