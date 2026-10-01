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

        if(choice == 0){
            return;
        }

            switch (choice) {
                case 1:
                    // 상품 추가
                    break;

                case 2:
                    // 상품 수정
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

    public void addProduct(Category category, Product product) {
        category.addProduct(product);
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

