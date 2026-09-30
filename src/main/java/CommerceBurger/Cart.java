package CommerceBurger;

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
//        for (CartItem item : items) {
//            item.getProduct().decreaseStock(item.getQuantity());
//        }

        items.clear();
    }
}
