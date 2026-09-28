package CommerceBurger;

import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Category> categories;
    private Customer customer;

    public CommerceSystem(List<Category> categories, Customer customer) {
        this.categories = categories;
        this.customer = customer;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            // TODO
            // 1. 카테고리 목록 출력
            // 2. 사용자 입력 받기
            // 3. 선택한 카테고리 처리
            // 4. 0 입력 시 종료

        }

        // scanner.close();
    }
}
