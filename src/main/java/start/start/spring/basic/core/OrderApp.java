package start.start.spring.basic.core;

import start.start.spring.basic.core.member.Grade;
import start.start.spring.basic.core.member.Member;
import start.start.spring.basic.core.member.MemberService;
import start.start.spring.basic.core.member.MemberServiceImpl;
import start.start.spring.basic.core.order.Order;
import start.start.spring.basic.core.order.OrderService;
import start.start.spring.basic.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.memberService()
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order: " + order.toString());
        System.out.println("order calculator price :" + order.calculatePrice());

    }
}
