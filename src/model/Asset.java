package model;

public class Asset {
    private String id;
    private String name;
    private String type; // Server, Laptop, Printer
    private String assignedToEmail; // إيميل الموظف المستلم أو "None"

    public Asset(String id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.assignedToEmail = "None";
    }

    // Getters and Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getAssignedToEmail() { return assignedToEmail; }
    public void setAssignedToEmail(String assignedToEmail) { this.assignedToEmail = assignedToEmail; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Type: " + type + " | Assigned To: " + assignedToEmail;
    }
}