package b6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bai6 {
    public static void main(String[] args) {
        // Bước 1: Tạo một danh sách chuỗi
        List<String> list = Arrays.asList("java", "python", "c++");

        // Bước 2: Sử dụng Stream API và phương thức map() để chuyển các chuỗi thành chữ in hoa
        List<String> upperCaseList = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseList);
    }
}

