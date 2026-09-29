package CommerceBurger;

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

        private void showProducts (Category category) {

            List<Product> products = category.getProducts();

            System.out.println();
            System.out.println("[ " + category.getName() + " ]");

            for (int i = 0; i < products.size(); i++) {

                Product product = products.get(i);

                System.out.println(
                        (i + 1) + ". "
                                + product.getName()
                                + " | "
                                + product.getPrice()
                                + "원 | "
                                + product.getDescription()
                );
            }

            System.out.println("0. 뒤로가기");
            System.out.print("상품 선택: ");

            int productChoice = scanner.nextInt();

            if (productChoice==0) {
                return;
            }

            if (productChoice >= 1 && productChoice <= products.size()) {
                Product selectedProduct = products.get(productChoice - 1);
                System.out.println("선택한 상품: "
                        + selectedProduct.getName()
                        + " | "
                        + selectedProduct.getPrice()
                        + "원 | "
                        + selectedProduct.getDescription()
                        + " | 재고: "
                        + selectedProduct.getStockQuantity()
                        + "개");

                System.out.print("장바구니에 추가하시겠습니까? (Y/N): ");
                String answer = scanner.next();

                if (cart.canAdd(selectedProduct, 1)) {
                    cart.addItem(selectedProduct, 1);
                    System.out.println("장바구니에 추가되었습니다.");
                } else {
                    System.out.println("재고가 부족합니다.");
                }

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
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        public void start() {
            // Scanner scanner = new Scanner(System.in);

            while (true) {

                System.out.println("[버거킹]");
                System.out.println("1. 버거");
                System.out.println("2. 음료");
                System.out.println("3. 사이드");
                System.out.println("4. 세트");
                System.out.println("0. 종료");
                System.out.println("선택: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // 버거 카테고리 보여주기
                        showProducts(categories.get(0));
                        break;

                    case 2:
                        // 음료 카테고리 보여주기
                        showProducts(categories.get(1));
                        break;

                    case 3:
                        // 사이드 카테고리 보여주기
                        showProducts(categories.get(2));
                        break;

                    case 4:
                        // 세트 카테고리 보여주기
                        showProducts(categories.get(3));
                        break;

                    case 0:
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        return;

                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }
        }
    }
