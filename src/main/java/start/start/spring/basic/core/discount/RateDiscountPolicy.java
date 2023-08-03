package start.start.spring.basic.core.discount;

import start.start.spring.basic.core.member.Grade;
import start.start.spring.basic.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPolicy = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price*discountPolicy/100;
        }else{
            return 0;
        }

    }
}
