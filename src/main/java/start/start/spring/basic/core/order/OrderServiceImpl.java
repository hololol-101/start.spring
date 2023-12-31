package start.start.spring.basic.core.order;

import start.start.spring.basic.core.discount.DiscountPolicy;
import start.start.spring.basic.core.discount.FixDiscountPolicy;
import start.start.spring.basic.core.discount.RateDiscountPolicy;
import start.start.spring.basic.core.member.Member;
import start.start.spring.basic.core.member.MemberRepository;
import start.start.spring.basic.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
