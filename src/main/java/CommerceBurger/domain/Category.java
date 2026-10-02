package CommerceBurger.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {

   private String name;
   private List<Product> products;

   public Category(String name) {
      this.name = name;
      this.products = new ArrayList<>();
   }

   public List<Product> findProductsByMaxPrice(int maxPrice) {
      return products.stream()
              .filter(product -> product.getPrice() <= maxPrice)
              .toList();
   }
   
   // 상품 추가
   public void addProduct(Product product) {
      products.add(product);
   }

   // 상품 업데이트
   public Product findProductByName(String name) {
         return products.stream()
                 .filter(product -> product.getName().equals(name))
                 .findFirst()
                 .orElse(null);

   }

   public void deleteProduct(Product product) {
      products.remove(product);
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
