package kr.megaptera.F4T2.backdoor;

import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("backdoor")
@Transactional
public class BackdoorController {
    private final JdbcTemplate jdbcTemplate;

    public BackdoorController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("setup-database")
    public String setupDatabase() {
        jdbcTemplate.execute("DELETE FROM product");

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(1, '소음이 적은 레이저 기계식 키보드', 'https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80', '저소음 적축 레이저 기계식 키보드입니다.', 49000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(2, '거북이 인형', 'https://images.unsplash.com/photo-1488723905857-809bb9a2d21d?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80', '귀여운 사이즈의 거북이 인형입니다!', 30000, 3)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(3, '엘모 인형', 'https://images.unsplash.com/photo-1614796918928-c92c79693e94?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80', '보고만 있어도 기분 좋아지는 엘모 인형입니다!', 60000, 4)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(4, '메모지', 'https://images.unsplash.com/photo-1531347334762-59780ece5c76?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '개발 아이디어를 정리할 수 있는 NOTE PAD입니다.', 10000, 6)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(5, '미니 알로에', 'https://images.unsplash.com/photo-1653447566342-1df9d50be7be?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1332&q=80', '책상에 두었다가 눈이 아플 때 초록초록한 알로에를 보세요💚', 10000, 6)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(6, '미니 조명', 'https://images.unsplash.com/photo-1499951360447-b19be8fe80f5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80', '모니터 쪽에 달 수 있는 미니 조명입니다!', 50000, 3)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(7, '원목 책상 의자 세트', 'https://images.unsplash.com/photo-1611269154421-4e27233ac5c7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=930&q=80', '깔끔한 우드톤의 책상과 의자 세트입니다.', 100000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(8, '화이트 책상', 'https://images.unsplash.com/photo-1449247709967-d4461a6a6103?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1471&q=80', '깔끔한 화이트 톤의 책상입니다.', 100000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(9, '스탠드 조명', 'https://images.unsplash.com/photo-1551380701-5dd33d5b5d06?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '책상 위에 두고 사용할 수 있는 스탠드 조명입니다.', 30000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(10, '모니터용 받침대', 'https://images.unsplash.com/photo-1494173853739-c21f58b16055?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=930&q=80', '모니터 아래에 두고 쓰는 모니터용 받침대입니다.', 40000, 3)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(11, '미니 키보드', 'https://images.unsplash.com/photo-1511467687858-23d96c32e4ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80', '휴대가 간편한 미니 블루투스 키보드입니다.', 40000, 6)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(12, '빅 모니터용 받침대', 'https://images.unsplash.com/photo-1586804186557-8939a72b2239?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1374&q=80', '큰 사이즈로 여유롭게 사용하실 수 있는 모니터용 받침대입니다.', 30000, 3)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(13, '토끼 인형', 'https://images.unsplash.com/photo-1558346547-3743a17cd0ec?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80', '귀여운 토끼 인형입니다.', 30000, 7)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(14, '높낮이 조절이 가능한 책상', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );
        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(15, '의자', 'https://images.unsplash.com/photo-1613413561312-e329d024ed65?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '푹신푹신하고 편안한 의자입니다.', 300000, 6)"
        );
        return "OK";
    }

    @GetMapping("delete-product")
    public String deleteProduct() {
        jdbcTemplate.execute("DELETE FROM product");

        return "OK";
    }

    @GetMapping("delete-cart")
    public String deleteCart() {
        jdbcTemplate.execute("DELETE FROM cart");

        return "OK";
    }

    @GetMapping("delete-orderHistory")
    public String deleteOrderHistory() {
        jdbcTemplate.execute("DELETE FROM order_history");

        return "OK";
    }
}
