package CommerceBurger.admin;

import CommerceBurger.domain.Category;
import CommerceBurger.domain.Product;

import java.util.*;

public class AdminSystem {

    private final Scanner scanner;
    private List<Category> categories;
    //private List<Product> products;

    public AdminSystem(List<Category> categories, Scanner scanner) {
        this.categories = categories;
        this.scanner=scanner;
    }

    public void start() {

        while(true){
        System.out.println("[ 관리자 메뉴 ]");
        System.out.println("1. 상품 추가");
        System.out.println("2. 상품 수정");
        System.out.println("3. 상품 삭제");
        System.out.println("0. 나가기");

        int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // 상품 추가
                    addProduct();
                    break;

                case 2:
                    // 상품 수정
                    updateProduct();
                    break;

                case 3:
                    // 상품 삭제
                    break;

                case 0:
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private Category selectCategory() {
        System.out.println("[ 카테고리 선택 ]");

        for (int i = 0; i < categories.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + categories.get(i).getName()
            );
        }

        System.out.println("0. 취소");
        System.out.print("선택: ");

        int choice = scanner.nextInt();

//        if (choice == 0) {
//            return null;
//        }

        if (choice < 1 || choice > categories.size()) {
            System.out.println("잘못된 입력입니다.");
            return null;
        }

        return categories.get(choice - 1);
    }

    public void addProduct() {
        Category category = selectCategory();

        if (category == null) {
            return;
        }

        scanner.nextLine(); // nextInt() 뒤에 남은 엔터 제거

        System.out.print("상품명을 입력하세요: ");
        String name = scanner.nextLine();

        if (category.findProductByName(name) != null) {
            System.out.println("이미 존재하는 상품입니다.");
            return;
        }

        System.out.print("가격을 입력하세요: ");
        int price = scanner.nextInt();

        scanner.nextLine(); // nextInt() 뒤에 남은 엔터 제거

        System.out.print("상품 설명을 입력하세요: ");
        String description = scanner.nextLine();

        System.out.print("재고 수량을 입력하세요: ");
        int stockQuantity = scanner.nextInt();

        Product product =
                new Product(
                        name,
                        price,
                        description,
                        stockQuantity
                );

        category.addProduct(product);

        System.out.println("상품이 추가되었습니다.");
    }

    private void updateProduct() {
        Category category = selectCategory();

        if (category == null) {
            return;
        }

        scanner.nextLine();

        System.out.print("수정할 상품명을 입력하세요: ");
        String name = scanner.nextLine();

        Product product = category.findProductByName(name);

        if (product == null) {
            System.out.println("상품을 찾을 수 없습니다.");
            return;
        }

        System.out.println("현재 상품 정보:");
        System.out.println(
                product.getName() + " | "
                        + product.getPrice() + "원 | "
                        + product.getDescription() + " | 재고: "
                        + product.getStockQuantity()
        );

        System.out.print("새 가격을 입력하세요: ");
        int price = scanner.nextInt();

        scanner.nextLine();

        System.out.print("새 상품 설명을 입력하세요: ");
        String description = scanner.nextLine();

        System.out.print("새 재고 수량을 입력하세요: ");
        int stockQuantity = scanner.nextInt();

        updateProduct(
                category,
                name,
                price,
                description,
                stockQuantity
        );

        System.out.println("상품이 수정되었습니다.");
    }

    public void updateProduct(
            Category category,
            String name,
            int price,
            String description,
            int stockQuantity
    ) {
        Product product = category.findProductByName(name);

        if (product != null) {
            product.setPrice(price);
            product.setDescription(description);
            product.setStockQuantity(stockQuantity);
        }
    }

    public void deleteProduct(Category category, Product product) {
        category.deleteProduct(product);
    }
}

