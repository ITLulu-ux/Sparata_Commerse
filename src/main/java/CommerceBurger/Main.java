package CommerceBurger;

import CommerceBurger.commerce.CommerceSystem;
import CommerceBurger.customer.Kiosk;
import CommerceBurger.domain.Category;
import CommerceBurger.domain.Customer;
import CommerceBurger.domain.CustomerGrade;
import CommerceBurger.domain.Product;

import java.util.List;

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
                "크리스피 갈릭칩과 불고기소스로 즐기는 갈릭불고기와퍼",
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

        Product americano = new Product(
                "아메리카노",
                2600,
                "자연을 담은 버거킹 RA인증커피",
                100
        );

        Product cocacola = new Product(
                "코카콜라 제로",
                3200,
                "100% 짜릿함, 칼로리는 제로",
                100
        );

        Product sprite = new Product(
                "스프라이트 제로",
                3200,
                "제대로 상쾌한 맛남 스프라이트 제로",
                100
        );

        // 카테고리 생성
        Category drink = new Category("음료");

        // 카테고리에 상품 추가
        drink.addProduct(americano);
        drink.addProduct(cocacola);
        drink.addProduct(sprite);

        Product nurgetking = new Product(
                "너겟킹",
                5500,
                "바삭 촉촉 한입에 쏙, 부드러운 너겟킹",
                100
        );

        Product cheesestick = new Product(
                "21치즈스틱",
                3600,
                "21cm의 역대급 사이즈, 진하고 고소한 자연 모짜렐라가 가득한 21치즈스틱",
                100
        );

        Product frenchfry = new Product(
                "프랜치프라이",
                3300,
                "세계최고의 감자만 엄선해서 버거킹만의 비법으로 바삭하게, 프랜치프라이",
                100
        );

        // 카테고리 생성
        Category side = new Category("사이드");

        // 카테고리에 상품 추가
        side.addProduct(nurgetking);
        side.addProduct(cheesestick);
        side.addProduct(frenchfry);

        Product cheesewhopperset = new Product(
                "치즈와퍼세트",
                11700,
                "불에 직접 구운 순쇠고기 패티가 들어간 와퍼에 아메리칸 치즈까지, 치즈와퍼",
                100
        );

        Product garlicbulgogiwhopperset = new Product(
                "갈릭불고기와퍼 세트",
                11400,
                "갈릭불고기와퍼 + 프랜치프라이 + 콜라",
                100
        );

        Product bulgogiwhopperset = new Product(
                "불고기와퍼세트",
                11100,
                "불고기와퍼 + 프랜치프라이 + 콜라",
                100
        );

        // 카테고리 생성
        Category set = new Category("세트");

        // 카테고리에 상품 추가
        set.addProduct(cheesewhopperset);
        set.addProduct(garlicbulgogiwhopperset);
        set.addProduct(bulgogiwhopperset);

        List<Category> categories = List.of(
                burger,
                drink,
                side,
                set
        );

        Customer customer = new Customer(
                "김루루",
                "example@email.com",
                CustomerGrade.GOLD
        );

        CommerceSystem commerceSystem =
                new CommerceSystem(categories, customer);

        Kiosk kiosk =
                new Kiosk(commerceSystem);

        kiosk.start();
    }
}

// 시작화면(매장/식사)