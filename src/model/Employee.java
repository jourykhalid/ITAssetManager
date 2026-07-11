package model;

public class Employee {
    private String name;
    private String email;
    private String role; // Admin, Developer, HR

    public Employee(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    // التحقق مما إذا كان للموظف صلاحية استلام سيرفر
    public boolean hasServerAccess() {
        return "Admin".equalsIgnoreCase(role) || "Developer".equalsIgnoreCase(role);
    }

    @Override
    public String toString() {
        return "Name: " + name + " (" + role + ") | Email: " + email;
    }
}