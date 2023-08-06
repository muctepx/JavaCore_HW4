package JavaCore.HW4.model;

import java.text.NumberFormat;

public class Product {
    String productName;
    double price;
    static final NumberFormat FORMAT_PRICE = NumberFormat.getCurrencyInstance();

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "Товар: " + productName + ", "
                + FORMAT_PRICE.format(price) + "/шт.";
    }
}
