import java.time.LocalDate;

public class Visitor {
    private int id;
    private String name;
    private String purpose;
    private LocalDate visitDate;

    public Visitor(int id, String name, String purpose, LocalDate visitDate) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.visitDate = visitDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPurpose() {
        return purpose;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Name: " + name
                + " | Purpose: " + purpose
                + " | Visit Date: " + visitDate;
    }
}
