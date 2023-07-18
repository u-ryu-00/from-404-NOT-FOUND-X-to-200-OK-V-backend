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
                " VALUES(15, '높낮이 조절이 가능한 책상1', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(16, '높낮이 조절이 가능한 책상2', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(17, '높낮이 조절이 가능한 책상3', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(18, '높낮이 조절이 가능한 책상4', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(19, '높낮이 조절이 가능한 책상5', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(20, '높낮이 조절이 가능한 책상6', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(21, '높낮이 조절이 가능한 책상7', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(22, '높낮이 조절이 가능한 책상8', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(23, '높낮이 조절이 가능한 책상9', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(24, '높낮이 조절이 가능한 책상10', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(25, '높낮이 조절이 가능한 책상11', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(26, '높낮이 조절이 가능한 책상12', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(27, '높낮이 조절이 가능한 책상13', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(28, '높낮이 조절이 가능한 책상14', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(29, '높낮이 조절이 가능한 책상15', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(30, '높낮이 조절이 가능한 책상16', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(31, '높낮이 조절이 가능한 책상17', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(32, '높낮이 조절이 가능한 책상18', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(33, '높낮이 조절이 가능한 책상19', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(34, '높낮이 조절이 가능한 책상20', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(35, '높낮이 조절이 가능한 책상21', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(36, '높낮이 조절이 가능한 책상22', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(37, '높낮이 조절이 가능한 책상23', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(38, '높낮이 조절이 가능한 책상24', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(39, '높낮이 조절이 가능한 책상25', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(40, '높낮이 조절이 가능한 책상26', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(41, '높낮이 조절이 가능한 책상27', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(42, '높낮이 조절이 가능한 책상28', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(43, '높낮이 조절이 가능한 책상29', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(44, '높낮이 조절이 가능한 책상30', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(45, '높낮이 조절이 가능한 책상31', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(46, '높낮이 조절이 가능한 책상32', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(47, '높낮이 조절이 가능한 책상33', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(48, '높낮이 조절이 가능한 책상34', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(49, '높낮이 조절이 가능한 책상35', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(50, '높낮이 조절이 가능한 책상36', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(114, '높낮이 조절이 가능한 책상37', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(115, '높낮이 조절이 가능한 책상38', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(116, '높낮이 조절이 가능한 책상39', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(117, '높낮이 조절이 가능한 책상40', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(118, '높낮이 조절이 가능한 책상41', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(119, '높낮이 조절이 가능한 책상42', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(120, '높낮이 조절이 가능한 책상43', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(121, '높낮이 조절이 가능한 책상44', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(122, '높낮이 조절이 가능한 책상45', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(123, '높낮이 조절이 가능한 책상46', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(124, '높낮이 조절이 가능한 책상47', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(125, '높낮이 조절이 가능한 책상48', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(126, '높낮이 조절이 가능한 책상49', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(127, '높낮이 조절이 가능한 책상50', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(128, '높낮이 조절이 가능한 책상51', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(129, '높낮이 조절이 가능한 책상52', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(130, '높낮이 조절이 가능한 책상53', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(131, '높낮이 조절이 가능한 책상54', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(132, '높낮이 조절이 가능한 책상55', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(133, '높낮이 조절이 가능한 책상56', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(134, '높낮이 조절이 가능한 책상57', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(135, '높낮이 조절이 가능한 책상58', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(136, '높낮이 조절이 가능한 책상59', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(137, '높낮이 조절이 가능한 책상60', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(138, '높낮이 조절이 가능한 책상61', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(139, '높낮이 조절이 가능한 책상62', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(140, '높낮이 조절이 가능한 책상63', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(141, '높낮이 조절이 가능한 책상64', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(142, '높낮이 조절이 가능한 책상65', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(143, '높낮이 조절이 가능한 책상66', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(144, '높낮이 조절이 가능한 책상67', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(145, '높낮이 조절이 가능한 책상68', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(146, '높낮이 조절이 가능한 책상69', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(147, '높낮이 조절이 가능한 책상70', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(148, '높낮이 조절이 가능한 책상71', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(149, '높낮이 조절이 가능한 책상72', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
        );

        jdbcTemplate.execute("" +
                "INSERT INTO product(product_Id, name, image, description, price, inventory)" +
                " VALUES(150, '높낮이 조절이 가능한 책상73', 'https://images.unsplash.com/photo-1623177623442-979c1e42c255?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=774&q=80', '높낮이 조절이 가능한 책상입니다.', 500000, 2)"
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
