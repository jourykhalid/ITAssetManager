import model.Asset;
import model.Employee;
import service.AssetManagerService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssetManagerService service = new AssetManagerService();
        Scanner scanner = new Scanner(System.in);

        // تحميل البيانات المحفوظة سابقاً وتغذية النظام بموظفين وهميين للشركة
        service.loadData();
        service.addEmployee(new Employee("Khalid", "khalid@company.com", "Admin"));
        service.addEmployee(new Employee("Sarah", "sarah@company.com", "Developer"));
        service.addEmployee(new Employee("Reem", "reem@company.com", "HR"));

        System.out.println("==========================================");
        System.out.println("   IT Infrastructure Asset Manager CLI    ");
        System.out.println("==========================================");

        while (true) {
            System.out.println("\n--- IT Dashboard ---");
            System.out.println("1. List All Registered Assets");
            System.out.println("2. View Registered Employees & Roles");
            System.out.println("3. Add New Hardware Asset (Server/Laptop/Printer)");
            System.out.println("4. Assign Asset to an Employee (RBAC)");
            System.out.println("5. Shutdown System & Save Status");
            System.out.print("Select an operation: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--- Current Infrastructure Status ---");
                    service.listAssets();
                    break;
                case "2":
                    System.out.println("\n--- Company Directory ---");
                    service.listEmployees();
                    break;
                case "3":
                    System.out.print("Enter Asset ID (e.g., SRV-01, LAP-12): ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Asset Model Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Asset Type (Server/Laptop/Printer): ");
                    String type = scanner.nextLine();
                    
                    service.addAsset(new Asset(id, name, type));
                    System.out.println("[+] Asset successfully provisioned!");
                    break;
                case "4":
                    System.out.print("Enter Asset ID to assign: ");
                    String aId = scanner.nextLine();
                    System.out.print("Enter Target Employee Email: ");
                    String email = scanner.nextLine();
                    
                    if (service.assignAsset(aId, email)) {
                        System.out.println("[+] Provisioning sequence completed successfully.");
                    } else {
                        System.out.println("[-] Provisioning failed. Verify IDs or Role privileges.");
                    }
                    break;
                case "5":
                    System.out.println("[*] Securing database log state... Goodbye!");
                    return;
                default:
                    System.out.println("[-] Invalid dashboard argument. Try again.");
            }
        }
    }
}