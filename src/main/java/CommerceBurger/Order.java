package CommerceBurger;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;
    private OrderStatus status;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        int total = 0;

        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }

        return total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void complete() {
        this.status = OrderStatus.PAID;
    }
}
