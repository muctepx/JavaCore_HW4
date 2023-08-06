package JavaCore.HW4;

import JavaCore.HW4.exceptions.AmountException;
import JavaCore.HW4.exceptions.CustomerException;
import JavaCore.HW4.exceptions.ProductException;
import JavaCore.HW4.model.Customer;
import JavaCore.HW4.model.Order;
import JavaCore.HW4.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Customer> customerList;
    public static ArrayList<Product> productList;
    public static ArrayList<Order> orders;

    public static void main(String[] args) {
        customerList = new ArrayList<>();
        customerList.add(new Customer(
                "Иванов", "Иван", "Иванович",
                LocalDate.of(1987, 12, 3),
                "+7", 7004002030L));
        customerList.add(new Customer(
                "Петров", "Петр", "Петрович",
                LocalDate.of(1979, 4, 18),
                "+7", 7014012131L));
        printList(customerList, "Список покупателей:");

        productList = new ArrayList<>();
        productList.add(new Product("Болт", 0.54));
        productList.add(new Product("Гайка", 0.2));
        productList.add(new Product("Молоток", 30.3));
        productList.add(new Product("Пила", 60));
        productList.add(new Product("Лобзик", 220));
        productList.add(new Product("Перфоратор", 450));
        printList(productList, "Список товаров:");

        orders = new ArrayList<>();
        int countOrders = 6;

        String customerFullName, productName, countProduct;

        while (orders.size() < countOrders) {
            customerFullName = View.getCustomerLastName() + ' '
                    + View.getCustomerFirstName() + ' '
                    + View.getCustomerPatronymic();
            productName = View.getProductName();
            countProduct = View.getCountProduct();
            try {
                orders.add(createOrder(customerFullName, productName, countProduct));
                System.out.println("Статус: Заказ оформлен\n");
            } catch (ProductException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Статус: Заказ не оформлен\n");
            } catch (AmountException e) {
                System.out.println("! " + e.getMessage());
                try {
                    orders.add(createOrder(customerFullName, productName, "1"));
                    System.out.println("Статус: Заказ оформлен, количество товара: 1\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } catch (CustomerException e) {
                System.out.println("Ошибка: " + e.getMessage() + '\n');
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        printList(orders, "Заказы:");
    }

    public static Order createOrder(String customerFullName, String productName,
                                    String countProduct)
            throws CustomerException, ProductException, AmountException {
        return new Order(findCustomer(customerFullName),
                findProduct(productName),
                getCountProduct(countProduct, 100));
    }

    public static Customer findCustomer(String customerFullName)
            throws CustomerException {
        if (customerList == null || customerList.size() == 0)
            throw new RuntimeException("Список покупателей не создан");
        for (Customer customer : customerList) {
            if (customer.getFullName().equals(customerFullName)) {
                return customer;
            }
        }
        throw new CustomerException();
    }

    public static Product findProduct(String productName)
            throws ProductException {
        if (productList == null || productList.size() == 0)
            throw new RuntimeException("Список товаров не создан");
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        throw new ProductException();
    }

    public static int getCountProduct(String countProduct, int maxCount)
            throws AmountException {
        if (maxCount < 1)
            throw new RuntimeException("Некорректный параметр");
        int count = Integer.parseInt(countProduct);
        if (count < 1)
            throw new AmountException("Количество товаров не может быть меньше 1");
        if (count > maxCount)
            throw new AmountException("Количество товаров не может быть больше " + maxCount);
        return count;
    }

    public static void printList(ArrayList<?> list, String massage) {
        System.out.println(massage);
        if (list == null) {
            System.out.println("!!! Список не создан\n");
            return;
        }
        if (list.size() == 0) {
            System.out.println("!!! Пустой список\n");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%03d %s%n", i + 1, list.get(i));
        }
        System.out.println();
    }
}