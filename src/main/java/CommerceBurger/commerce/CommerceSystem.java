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

    public int getCartTotalPrice() {
        return cart.getTotalPrice();
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

        int totalPrice = order.getTotalPrice();
        int discountRate = customer.getGrade().getDiscountRate();
        int finalPrice = order.getDiscountedTotalPrice(customer.getGrade());

        System.out.println("주문 금액: " + totalPrice + "원");
        System.out.println("고객 등급: " + customer.getGrade());
        System.out.println("할인율: " + discountRate + "%");
        System.out.println("최종 결제 금액: " + finalPrice + "원");

        order.complete();

        // 주문 확정 후 재고 차감
        for (CartItem cartItem : cart.getItems()) {
            cartItem.getProduct()
                    .decreaseStock(cartItem.getQuantity());
        }

        // 주문 완료 후 장바구니 비우기
        cart.clear();
    }

    public int getTotalPrice() {
        int total = 0;

        for (CartItem cartItem : cart.getItems()) {
            total += cartItem.getTotalPrice();
        }

        return total;
    }

    public int getDiscountedTotalPrice(CustomerGrade grade) {
        int total = getTotalPrice();
        int discountRate = grade.getDiscountRate();

        return total - (total * discountRate / 100);
    }

    public void showCart() {

        System.out.println("[ 장바구니 ]");

        if (cart.getItems().isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

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

    public void deleteProduct(Category category, Product product) {
        System.out.println("CommerceSystem 상품 삭제 실행");

        category.deleteProduct(category, product);
        cart.removeProduct(product);

        System.out.println("Cart에서도 상품 삭제 실행");
    }
}
