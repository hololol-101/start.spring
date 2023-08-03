package start.start.spring.basic.core;

import start.start.spring.basic.core.discount.DiscountPolicy;
import start.start.spring.basic.core.discount.FixDiscountPolicy;
import start.start.spring.basic.core.discount.RateDiscountPolicy;
import start.start.spring.basic.core.member.MemberRepository;
import start.start.spring.basic.core.member.MemberService;
import start.start.spring.basic.core.member.MemberServiceImpl;
import start.start.spring.basic.core.member.MemoryMemberRepository;
import start.start.spring.basic.core.order.OrderService;
import start.start.spring.basic.core.order.OrderServiceImpl;

public class AppConfig {
    //생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
