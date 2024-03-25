package b10_a;

import java.util.*;

public class b10_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departments = new HashMap<>();

        while (true) {
            System.out.println("========= HR Management System =========");
            System.out.println("1. Hiển thị danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên của phòng ban theo mã phòng");
            System.out.println("5. Xóa phòng ban (chỉ xóa khi ko có nhân viên nào)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayDepartments(departments);
                    break;
                case 2:
                    addDepartment(scanner, departments);
                    break;
                case 3:
                    editDepartmentName(scanner, departments);
                    break;
                case 4:
                    displayEmployeesInDepartment(scanner, departments);
                    break;
                case 5:
                    deleteDepartment(scanner, departments);
                    break;
                case 6:
                    System.out.println("Đang thoát...");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 1 đến 6.");
            }
        }
    }

    public static void displayDepartments(Map<String, Department> departments) {
        System.out.println("Danh sách các phòng ban:");
        for (Department department : departments.values()) {
            System.out.println("ID Phòng ban: " + department.getDepartmentId() +
                    ", Tên Phòng ban: " + department.getDepartmentName() +
                    ", Tổng số thành viên: " + department.getTotalMembers());
        }
    }

    public static void addDepartment(Scanner scanner, Map<String, Department> departments) {
        System.out.print("Nhập ID phòng ban: ");
        String departmentId = scanner.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        String departmentName = scanner.nextLine();
        System.out.print("Nhập tổng số thành viên: ");
        int totalMembers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Department newDepartment = new Department(departmentId, departmentName, totalMembers);
        departments.put(departmentId, newDepartment);
        System.out.println("Đã thêm phòng ban thành công.");
    }

    public static void editDepartmentName(Scanner scanner, Map<String, Department> departments) {
        System.out.print("Nhập ID Phòng ban để chỉnh sửa tên: ");
        String departmentId = scanner.nextLine();
        if (departments.containsKey(departmentId)) {
            System.out.print("Nhập tên phòng ban mới: ");
            String newDepartmentName = scanner.nextLine();
            departments.get(departmentId).setDepartmentName(newDepartmentName);
            System.out.println("Tên bộ phận được cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy phòng ban.");
        }
    }

    public static void displayEmployeesInDepartment(Scanner scanner, Map<String, Department> departments) {
        System.out.print("Nhập ID phòng Ban để hiển thị nhân viên: ");
        String departmentId = scanner.nextLine();
        if (departments.containsKey(departmentId)) {
            Department department = departments.get(departmentId);
            System.out.println("Nhân viên trong phòng ban " + departmentId + ":");
            System.out.println("Tên phòng ban: " + department.getDepartmentName());
            System.out.println("Tổng số thành viên: " + department.getTotalMembers());
        } else {
            System.out.println("Không tìm thấy phòng ban.");
        }
    }

    public static void deleteDepartment(Scanner scanner, Map<String, Department> departments) {
        System.out.print("Nhập ID phòng ban để xóa: ");
        String departmentId = scanner.nextLine();
        if (departments.containsKey(departmentId)) {
            departments.remove(departmentId);
            System.out.println("Đã xóa thành công phòng ban.");
        } else {
            System.out.println("Không tìm thấy phòng ban.");
        }
    }
}
