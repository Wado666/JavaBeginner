package Libary;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputException {

    private static final Scanner sc = new Scanner(System.in);

    //===============================================================
    // 1. STRING
    //===============================================================
    public static String normalizeString(String s) {
        return s.replaceAll("\\s+", " ").trim();
    }

    // Loại bỏ những khoảng trắng và tab dư thừa; Chuỗi không rỗng
    public static String inputString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            s = normalizeString(s);

            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Lỗi: Không được để trống!");
        }
    }

    // Giới hạn độ dài
    public static String inputString(String msg, int maxLength) {
        while (true) {
            String s = inputString(msg);
            if (s.length() <= maxLength) {
                return s;
            }
            System.out.println("Lỗi: Tối đa " + maxLength + " ký tự!");
        }
    }

    public static String normalizeName(String s) {
        // Chuẩn hóa khoảng trắng
        s = s.trim().toLowerCase().replaceAll("\\s+", " ");

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            if (!w.isEmpty()) {
                // Viết hoa chữ cái đầu (Unicode-safe)
                sb.append(Character.toUpperCase(w.charAt(0)))
                        .append(w.substring(1))
                        .append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static String inputName(String msg) {
        while (true) {
            String s = inputString(msg);
            s = normalizeName(s);

            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("Lỗi: Tên không hợp lệ!");
        }
    }

    // Chuẩn hóa + validate tên (chỉ chứa chữ)
    public static String inputNameStrict(String msg) {
        while (true) {
            String s = inputString(msg);

            // Chỉ cho phép chữ + khoảng trắng (Unicode)
            if (!s.matches("^[\\p{L} ]+$")) {
                System.out.println("Lỗi: Chỉ được nhập chữ!");
                continue;
            }

            return normalizeName(s);
        }
    }

    // Validate email
    public static String inputEmail(String msg) {
        String pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        while (true) {
            String s = inputString(msg);
            if (s.matches(pattern)) {
                return s;
            }
            System.out.println("Lỗi: Email không hợp lệ!");
        }
    }
    //Ví dụ hợp lệ
    //abc@gmail.com
    //user.name@hutech.edu.vn

    // Validate Số điện thoại Việt Nam
    public static String inputPhoneVN(String msg) {
        String pattern = "^(03|05|07|08|09)\\d{8}$";

        while (true) {
            String s = inputString(msg);
            if (s.matches(pattern)) {
                return s;
            }
            System.out.println("Lỗi: SĐT Việt Nam không hợp lệ!");
        }
    }
//    + Ví dụ hợp lệ
//    0912345678
//    0387654321
//    + Không hợp lệ
//    1234567890
//    09123abc78
//    0012345678
    
    // Validate Password, hiện rõ
    public static String inputPassword(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();

            if (s.length() < 6) {
                System.out.println("Lỗi: Ít nhất 6 ký tự!");
                continue;
            }

            if (s.contains(" ")) {
                System.out.println("Lỗi: Không được chứa khoảng trắng!");
                continue;
            }

            if (!s.matches(".*[A-Za-z].*") || !s.matches(".*\\d.*")) {
                System.out.println("Lỗi: Phải có chữ và số!");
                continue;
            }

            return s;
        }
    }
    //===============================================================
    // 2. INT
    //===============================================================

    public static int inputInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Phải nhập số nguyên!");
            }
        }
    }

    public static int inputIntRange(String msg, int min, int max) {
        while (true) {
            int x = inputInt(msg);
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("Lỗi: Phải trong khoảng [" + min + ", " + max + "]");
        }
    }

    public static int inputIntPositive(String msg) {
        while (true) {
            int x = inputInt(msg);
            if (x > 0) {
                return x;
            }
            System.out.println("Lỗi: Phải > 0");
        }
    }

    //===============================================================
    // 3. LONG
    //===============================================================
    public static long inputLong(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Long.parseLong(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Phải nhập số nguyên (long)!");
            }
        }
    }

    public static long inputLongRange(String msg, long min, long max) {
        while (true) {
            long x = inputLong(msg);
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("Lỗi: Phải trong khoảng [" + min + ", " + max + "]");
        }
    }

    public static long inputLongPositive(String msg) {
        while (true) {
            long x = inputLong(msg);
            if (x > 0) {
                return x;
            }
            System.out.println("Lỗi: Phải > 0");
        }
    }

    //===============================================================
    // 4. FLOAT
    //===============================================================
    public static float inputFloat(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Phải nhập số thực (float)!");
            }
        }
    }

    public static float inputFloatRange(String msg, float min, float max) {
        while (true) {
            float x = inputFloat(msg);
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("Lỗi: Phải trong khoảng [" + min + ", " + max + "]");
        }
    }

    public static float inputFloatPositive(String msg) {
        while (true) {
            float x = inputFloat(msg);
            if (x > 0) {
                return x;
            }
            System.out.println("Lỗi: Phải > 0");
        }
    }
    //===============================================================
    // 5. DOUBLE
    //===============================================================

    public static double inputDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Phải nhập số thực!");
            }
        }
    }

    public static double inputDoubleRange(String msg, double min, double max) {
        while (true) {
            double x = inputDouble(msg);
            if (x >= min && x <= max) {
                return x;
            }
            System.out.println("Lỗi: Phải trong khoảng [" + min + ", " + max + "]");
        }
    }

    public static double inputDoublePositive(String msg) {
        while (true) {
            double x = inputDouble(msg);
            if (x > 0) {
                return x;
            }
            System.out.println("Lỗi: Phải > 0");
        }
    }

    //===============================================================
    // 6. CHAR
    //===============================================================
    public static char inputChar(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.length() == 1) {
                return s.charAt(0);
            }
            System.out.println("Lỗi: Chỉ nhập 1 ký tự!");
        }
    }

    //===============================================================
    // 7. BOOLEAN
    //===============================================================
    public static boolean inputBoolean(String msg) {
        while (true) {
            System.out.print(msg + " (true/false | y/n | 1/0): ");
            String s = sc.nextLine().trim().toLowerCase();

            if (s.equals("true") || s.equals("t") || s.equals("1") || s.equals("y")) {
                return true;
            }
            if (s.equals("false") || s.equals("f") || s.equals("0") || s.equals("n")) {
                return false;
            }

            System.out.println("Lỗi: Giá trị không hợp lệ!");
        }
    }

    //===============================================================
    // 8. MENU 
    //===============================================================
    public static int inputChoice(String msg, int min, int max) {
        return inputIntRange(msg, min, max);
    }

    public static boolean inputYesNo(String msg) {
        while (true) {
            System.out.print(msg + " (y/n): ");
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("y")) {
                return true;
            }
            if (s.equals("n")) {
                return false;
            }
            System.out.println("Lỗi: Chỉ nhập y hoặc n!");
        }
    }

    //===============================================================
    // 9. DATE 
    //===============================================================
    public static LocalDate inputDate(String msg) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
        while (true) {
            try {
                System.out.print(msg);
                return LocalDate.parse(sc.nextLine(), fmt);
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Sai định dạng (dd/MM/yyyy)!");
            }
        }
    }

    //===============================================================
    // 10. CUSTOM VALIDATION 
    //===============================================================
    public static String inputNonEmptyUpper(String msg) {
        return inputString(msg).toUpperCase();
    }

    public static String inputNonEmptyLower(String msg) {
        return inputString(msg).toLowerCase();
    }
}

