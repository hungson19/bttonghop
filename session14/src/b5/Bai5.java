package b5;

import java.util.Arrays;
import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        // Bước 1: Tạo một mảng số nguyên
        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Bước 2: Nhập giá trị xác định từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị xác định: ");
        int threshold = scanner.nextInt();

        // Bước 3: Sử dụng Stream API và phương thức filter() để lọc các số lớn hơn giá trị xác định
        System.out.println("Các số lớn hơn " + threshold + " là:");
        Arrays.stream(numbers)
                .filter(number -> number > threshold)
                .forEach(System.out::println);
    }
}

