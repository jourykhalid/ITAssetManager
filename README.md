# IT Infrastructure Asset Manager

An enterprise-inspired command-line interface (CLI) application developed in **Java** to automate corporate hardware asset provisioning. 

The application governs the deployment lifecycle of crucial hardware assets (Servers, Laptops, Printers) and safely binds them to employees leveraging **Role-Based Access Control (RBAC)** filters.

## IT Domain Features Implemented
- **Role-Based Provisioning:** Security layer built inside the business logic ensures sensitive assets (e.g., Servers) can only be assigned to technical roles (`Admin`/`Developer`), preventing operational security compliance violations from `HR` or guest roles.
- **Flat-File Storage Simulation:** Emulates a persistent configuration database module by safely storing local environment data into comma-separated text blocks that act as lightweight record stores.
- **Concurrent Maps Management:** Utilizes fast Java memory indexing collections (`HashMaps`) to quickly retrieve state values across O(1) query patterns.

## Architecture & Subdirectories
- `model/Asset.java`: Defines infrastructure hardware components and deployment flags.
- `model/Employee.java`: Contains staff properties and corporate role matrices.
- `service/AssetManagerService.java`: Drives the core back-end management logic and File persistence sequence.
- `Main.java`: The interactive network operations console framework interface.

## Quick Start (VS Code)
1. Open the project inside VS Code.
2. Confirm that the Microsoft **Java Extension Pack** is enabled.
3. Launch `src/Main.java` and click **Run**.
4. Test the authorization rules by attempting to assign a `Server` asset type to `reem@company.com` (HR role) to see the integrated firewall logic block the sequence.

## License
Open-source under the MIT License guidelines.