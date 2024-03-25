package b7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Nhập hai số nguyên x và y từ người dùng
        System.out.print("Nhập số nguyên x: ");
        int x = scanner.nextInt();
        System.out.print("Nhập số nguyên y: ");
        int y = scanner.nextInt();

        // Bước 2: Sử dụng Stream API và phương thức range() để tạo danh sách các số từ x đến y
        List<Integer> list = IntStream.rangeClosed(x, y).boxed().collect(Collectors.toList());

        System.out.println("Danh sách số nguyên từ " + x + " đến " + y + ": " + list);
    }
}

