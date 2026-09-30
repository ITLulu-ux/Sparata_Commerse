package CommerceBurger;

import java.util.*;

public class Kiosk {

    private CommerceSystem commerceSystem;
    private Scanner scanner;

    public Kiosk(CommerceSystem commerceSystem) {
        this.commerceSystem = commerceSystem;
        this.scanner = new Scanner(System.in);
    }

    private void showProducts(Category category) {

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

        if (productChoice == 0) {
            return;
        }

        if (productChoice >= 1 && productChoice <= products.size()) {

            Product selectedProduct =
                    products.get(productChoice - 1);

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

            if (answer.equalsIgnoreCase("Y")) {

                System.out.print("수량을 입력하세요: ");
                int quantity = scanner.nextInt();

                if (commerceSystem.addToCart(selectedProduct, quantity)) {

                    System.out.println("장바구니에 추가되었습니다.");
                    System.out.println(
                            "총 금액: "
                                    + commerceSystem.getCartTotalPrice()
                                    + "원"
                    );

                    commerceSystem.showCart();

                    System.out.print("주문하시겠습니까? (Y/N): ");
                    String orderAnswer = scanner.next();


                    if (orderAnswer.equalsIgnoreCase("Y")) {
                        commerceSystem.order();
                        System.out.println("주문이 완료되었습니다.");

                    } else if (orderAnswer.equalsIgnoreCase("N")) {

                        System.out.println("주문을 취소했습니다.");
                    }

                } else {
                    System.out.println("재고가 부족합니다.");
                }

            } else if (answer.equalsIgnoreCase("N")) {

                System.out.println("장바구니 추가를 취소했습니다.");
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    public void start() {

        List<Category> categories =
                commerceSystem.getCategories();

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
                    showProducts(categories.get(0));
                    break;

                case 2:
                    showProducts(categories.get(1));
                    break;

                case 3:
                    showProducts(categories.get(2));
                    break;

                case 4:
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
