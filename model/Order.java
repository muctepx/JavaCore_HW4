package JavaCore.HW4.model;

public class Order {
    Customer customer;
    Product product;
    int countProduct;

    public Order(Customer customer, Product product, int countProduct) {
        this.customer = customer;
        this.product = product;
        this.countProduct = countProduct;
    }

    @Override
    public String toString() {
        return String.format("Заказ:%n    %s%n    %s%n    Количество: %d шт.",
                customer, product, countProduct);
    }
}
