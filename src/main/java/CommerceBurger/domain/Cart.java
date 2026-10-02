package CommerceBurger.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean canAdd(Product product, int quantity) {
        return product.getStockQuantity() >= quantity;
    }

    public int getTotalPrice() {
        int total = 0;

        for (CartItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    public void clear() {
        items.clear();
    }

    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct() == product);
    }

    public void removeProductByName(String name) {
        items = items.stream()
                .filter(item -> !item.getProduct().getName().equals(name))
                .toList();
    }
}
