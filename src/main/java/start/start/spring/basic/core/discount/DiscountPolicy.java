package start.start.spring.basic.core.discount;

import start.start.spring.basic.core.member.Member;

public interface DiscountPolicy {
    /*
     return 할인대상금액
    */

    int discount(Member member, int price);

}
