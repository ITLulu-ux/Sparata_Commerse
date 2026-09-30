package CommerceBurger.commerce;

import CommerceBurger.domain.*;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;
    private Customer customer;
    private Scanner scanner;
    private Cart cart;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CommerceSystem(List<Category> categories, Customer customer) {
        this.categories = categories;
        this.customer = customer;
        this.scanner = new Scanner(System.in);
        this.cart = new Cart();
    }

    public boolean addToCart(Product product, int quantity) {

        if (cart.canAdd(product, quantity)) {
            cart.addItem(product, quantity);
            return true;
        }

        return false;
    }

    public void order() {

        Order order = new Order();

        for (CartItem cartItem : cart.getItems()) {

            OrderItem orderItem =
                    new OrderItem(
                            cartItem.getProduct(),
                            cartItem.getQuantity()
                    );

            order.addItem(orderItem);
        }

        order.complete();

        // 주문 확정 후 재고 차감
        for (CartItem cartItem : cart.getItems()) {
            cartItem.getProduct()
                    .decreaseStock(cartItem.getQuantity());
        }

        // 주문 완료 후 장바구니 비우기
        cart.clear();
    }

    public int getCartTotalPrice() {
        return cart.getTotalPrice();
    }

    public void showCart() {

        System.out.println("[ 장바구니 ]");

        for (CartItem item : cart.getItems()) {
            System.out.println(
                    item.getProduct().getName()
                            + " | "
                            + item.getProduct().getPrice()
                            + "원 | "
                            + item.getQuantity()
                            + "개"
            );
        }
    }
}
