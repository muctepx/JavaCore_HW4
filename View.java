package JavaCore.HW4;

import java.util.Scanner;

public class View {
    static Scanner scan = new Scanner(System.in);

    private static String getStringValue(String massage, String regex,
                                         int minLengthString, int maxLengthString) {
        System.out.print(massage);
        String value = scan.nextLine();
        if (value.isEmpty()) {
            System.out.println("Значение не введено");
            return getStringValue(massage, regex, minLengthString, maxLengthString);
        }
        if (value.toLowerCase().matches(regex)
                && value.length() >= minLengthString
                && value.length() <= maxLengthString) {
            String result = value.substring(0, 1).toUpperCase()
                    + value.substring(1).toLowerCase();
            if (result.charAt(result.length() - 1) == ' ')
                return result.substring(0, result.length() - 1);
            return result;
        }
        System.out.println("Некорректные данные. Повторите ввод");
        return getStringValue(massage, regex, minLengthString, maxLengthString);
    }

    public static String getCustomerFirstName() {
        return getStringValue("Введите имя покупателя: ",
                "[а-яё]+", 2, 20);
    }

    public static String getCustomerLastName() {
        return getStringValue("Введите фамилию покупателя: ",
                "[а-яё]+", 2, 20);
    }

    public static String getCustomerPatronymic() {
        return getStringValue("Введите отчество покупателя: ",
                "[а-яё]+", 2, 20);
    }

    public static String getProductName() {
        return getStringValue("Введите название товара: ",
                "(?:[а-яё]+ ?){1,4}", 3, 25);
    }

    public static String getCountProduct() {
        return getStringValue("Введите количество товаров: ",
                "-?[0-9]+", 1, 4);
    }
}