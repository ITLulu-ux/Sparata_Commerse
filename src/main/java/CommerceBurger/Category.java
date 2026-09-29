package CommerceBurger;

import java.util.ArrayList;
import java.util.List;

public class Category {

   private String name;
   private List<Product> products;

   public Category(String name) {
      this.name = name;
      this.products = new ArrayList<>();
   }

   // 상품 추가
   public void addProduct(Product product) {
      products.add(product);
   }

   // 카테고리 이름 반환
   public String getName() {
      return name;
   }

   // 상품 목록 반환
   public List<Product> getProducts() {
      return products;
   }
}

// Category가 Product 관리
