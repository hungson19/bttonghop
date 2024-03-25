package bttonghop.bussiness.entity;

import java.util.List;
import java.util.Scanner;

public class Department {
    private String departmentId, departmentName;
    private int totalMembers;//gia tri mac dinh = 0

    public Department() {
    }

    public Department(String departmentID, String departmentName, int totalMembers) {
        this.departmentId = departmentID;
        this.departmentName = departmentName;
        this.totalMembers = totalMembers;
    }

    public String getDepartmentID() {
        return departmentId;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentId = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(int totalMembers) {
        this.totalMembers = totalMembers;
    }

    public void inputData(List<Department> departmentList){
        this.departmentId = getInputDepartmentID(departmentList);
        this.departmentName = getInputDepartmentName(departmentList);
    }

    private String getInputDepartmentName(List<Department> departmentList) {
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhap vao ten phong ban");
            String departmentNameInput = sc.nextLine();
            if (!departmentNameInput.isBlank()){
                //kt dung dinh dang -> kt trung lap
                if (departmentList.stream().noneMatch(t->t.getDepartmentName().equals(departmentNameInput))){
                    //trung lap
                    return departmentNameInput;
                }
                System.err.println("Khong duoc de trong");
            }
        }
    }

    private String getInputDepartmentID(List<Department> departmentList) {
        final String regex = "^D\\w{3}$";
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Nhập vào mã phòng ban");
            String departmentIdInput = sc.nextLine();
            if (departmentIdInput.matches(regex)){
                //kt dung dinh dang -> kiem tra trung lap
                if (departmentList.stream().noneMatch(t->t.getDepartmentID().equals(departmentIdInput))){
                    //trung lap
                    return departmentIdInput;
                }
                System.out.println("Id da ton tai, vui long nhap gia tri khac");
            }else{
                System.out.println("Khong dung dinh dang(D___)");
            }
    }
    }
    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | TotalMembers : %-3s |\n",
                departmentId,departmentName,totalMembers);
        System.out.println("------------------------------------------------------------------------");
    }
}
