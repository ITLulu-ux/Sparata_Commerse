package CommerceBurger;

public class Main {
    public static void main(String[] args) {

        // 상품 생성
        Product whopper = new Product(
                "와퍼",
                8400,
                "단품",
                100
        );

        Product cheesewhopper = new Product(
                "치즈와퍼",
                9000,
                "단품",
                100
        );

        Product garlicbulgogiwhopper = new Product(
                "갈릭불고기와퍼",
                8700,
                "# 크리스피 갈릭칩과 불고기소스로 즐기는 갈릭불고기와퍼",
                150
        );

        Product bulgogiwhopper = new Product(
                "불고기와퍼",
                8400,
                "단품",
                200
        );

        Product monsterwhopper = new Product(
                "몬스터와퍼",
                10600,
                "디아블로 소스의 매콤함, 불에 직접 구운 100% 순쇠고기 패티와 치킨패티까지 압도적 크기의 몬스터와퍼",
                70
        );

        // 카테고리 생성
        Category burger = new Category("버거");

        // 카테고리에 상품 추가
        burger.addProduct(whopper);
        burger.addProduct(cheesewhopper);
        burger.addProduct(garlicbulgogiwhopper);
        burger.addProduct(monsterwhopper);
        burger.addProduct(bulgogiwhopper);

        // TODO:
        // 음료 카테고리
        // 사이드 카테고리
        // 세트 카테고리

        // TODO:
        // Customer 생성

        // TODO:
        // Category들을 List로 묶기

        // TODO:
        // CommerceSystem 생성

        // TODO:
        // start() 호출


    }
}

// 시작화면(매장/식사)