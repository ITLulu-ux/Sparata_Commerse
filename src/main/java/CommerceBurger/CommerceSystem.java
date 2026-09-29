package CommerceBurger;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;
    private Customer customer;
    private Scanner scanner;

    public CommerceSystem(List<Category> categories, Customer customer) {
        this.categories = categories;
        this.customer = customer;
        this.scanner = new Scanner(System.in);
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
                System.out.println(selectedProduct.getName() + "을(를) 선택했습니다.");
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
