package service;

import model.Asset;
import model.Employee;
import java.io.*;
import java.util.*;

public class AssetManagerService {
    private Map<String, Asset> assets = new HashMap<>();
    private Map<String, Employee> employees = new HashMap<>();
    private static final String STORAGE_FILE = "infrastructure_data.txt";

    public void addEmployee(Employee emp) {
        employees.put(emp.getEmail(), emp);
    }

    public void addAsset(Asset asset) {
        assets.put(asset.getId(), asset);
        saveData();
    }

    public boolean assignAsset(String assetId, String employeeEmail) {
        Asset asset = assets.get(assetId);
        Employee emp = employees.get(employeeEmail);

        if (asset == null || emp == null) return false;

        // فحص الصلاحيات الأمنية بناءً على الدور (IT Business Logic)
        if ("Server".equalsIgnoreCase(asset.getType()) && !emp.hasServerAccess()) {
            System.out.println("[-] Access Denied: " + emp.getRole() + " roles are not authorized to manage Servers.");
            return false;
        }

        asset.setAssignedToEmail(emp.getEmail());
        saveData();
        return true;
    }

    public void listAssets() {
        if (assets.isEmpty()) System.out.println("[*] No assets in the infrastructure.");
        else assets.values().forEach(System.out::println);
    }

    public void listEmployees() {
        employees.values().forEach(System.out::println);
    }

    // حفظ البيانات بصيغة نصية تشبه الـ JSON مبسطة
    public void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STORAGE_FILE))) {
            for (Asset a : assets.values()) {
                writer.println(a.getId() + "," + a.getName() + "," + a.getType() + "," + a.getAssignedToEmail());
            }
        } catch (IOException e) {
            System.out.println("[-] Storage error: " + e.getMessage());
        }
    }

    // استرجاع البيانات تلقائياً عند تشغيل النظام
    public void loadData() {
        File file = new File(STORAGE_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Asset a = new Asset(parts[0], parts[1], parts[2]);
                    a.setAssignedToEmail(parts[3]);
                    assets.put(a.getId(), a);
                }
            }
        } catch (IOException e) {
            System.out.println("[-] Error loading data: " + e.getMessage());
        }
    }
}