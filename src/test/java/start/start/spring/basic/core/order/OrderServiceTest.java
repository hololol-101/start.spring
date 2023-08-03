package start.start.spring.basic.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import start.start.spring.basic.core.AppConfig;
import start.start.spring.basic.core.member.Grade;
import start.start.spring.basic.core.member.Member;
import start.start.spring.basic.core.member.MemberService;
import start.start.spring.basic.core.member.MemberServiceImpl;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void 주문(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
