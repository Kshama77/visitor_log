import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorManager {
    private List<Visitor> visitors = new ArrayList<Visitor>();
    private int nextId = 1;

    public void addVisitor(String name, String purpose, LocalDate visitDate) {
        Visitor visitor = new Visitor(nextId, name, purpose, visitDate);
        visitors.add(visitor);
        nextId++;
        System.out.println("Visitor added successfully.");
    }

    public void showVisitors() {
        if (visitors.isEmpty()) {
            System.out.println("No visitor records found.");
            return;
        }

        System.out.println("\\n--- Visitor Records ---");
        for (Visitor visitor : visitors) {
            System.out.println(visitor);
        }
    }

    public void searchVisitor(String searchName) {
        boolean found = false;

        for (Visitor visitor : visitors) {
            if (visitor.getName().equalsIgnoreCase(searchName)) {
                System.out.println(visitor);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No visitor found with that name.");
        }
    }

    public void removeVisitor(int id) {
        for (int i = 0; i < visitors.size(); i++) {
            if (visitors.get(i).getId() == id) {
                visitors.remove(i);
                System.out.println("Visitor record removed.");
                return;
            }
        }

        System.out.println("Visitor ID not found.");
    }
}
