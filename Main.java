import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Map<String, Integer> romanNumber = Map.of(
            "I", 1,
            "II", 2,
            "III", 3,
            "IV", 4,
            "V", 5,
            "VI", 6,
            "VII", 7,
            "VIII", 8,
            "IX", 9,
            "X", 10
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пример!");

        String value = scanner.nextLine();

        String[] symbols = value.split(" ");

        if (symbols.length != 3) {
            throw new IllegalArgumentException(
                    "формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }

        boolean isRoman = isRoman(symbols[0]);
        String[] decimal = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] single = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        if (!isRoman) {
            System.out.println("Это арабское число");
            int result = workingWithArabicNumber(symbols);

            System.out.println(result);

        } else {
            System.out.println("Это римское число");
            int result = workingWithRomanNumber(symbols);
            if (result == 100) {
                System.out.println("C");
            } else if (result < 1) {
                throw new IllegalArgumentException("В римской системе нет отрицательных чисел и 0");
            } else if (result < 10) {
                System.out.println(single[result]);
            } else if (result > 9 && result < 100) {
                int d = result / 10;
                int s = result % 10;
                System.out.print(decimal[d]);
                System.out.print(single[s]);
            }
        }


    }

    public static boolean isRoman(String scanner) {
        return romanNumber.containsKey(scanner);
    }

    public static int workingWithRomanNumber(String[] val) {
        try {
            int var1 = romanNumber.get(val[0]);
            int var2 = romanNumber.get(val[2]);

            if (var1 > 0 && var1 < 11 && var2 > 0 && var2 < 11) {

                switch (val[1]) {
                    case "+":
                        return var1 + var2;
                    case "-":
                        return var1 - var2;
                    case "*":
                        return var1 * var2;
                    case "/":
                        return var1 / var2;
                    default:
                        throw new IllegalArgumentException("Неверная операция");
                }
            } else {
                throw new IllegalArgumentException("Неверное число");
            }

        } catch (NullPointerException r) {
            throw new IllegalArgumentException("используются одновременно разные системы счисления");
        }
    }

    public static int workingWithArabicNumber(String[] values) {

        try {
            int var1 = Integer.parseInt(values[0]);
            int var2 = Integer.parseInt(values[2]);

            if (var1 > 0 && var1 < 11 && var2 > 0 && var2 < 11) {

                switch (values[1]) {
                    case "+":
                        return var1 + var2;
                    case "-":
                        return var1 - var2;
                    case "*":
                        return var1 * var2;
                    case "/":
                        return var1 / var2;
                    default:
                        throw new IllegalArgumentException("Неверная операция");
                }
            } else {
                throw new IllegalArgumentException("Неверное число");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("используются одновременно разные системы счисления");
        }

    }

}
