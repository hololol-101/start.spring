package start.start.spring.basic.core;

import start.start.spring.basic.core.member.Grade;
import start.start.spring.basic.core.member.Member;
import start.start.spring.basic.core.member.MemberService;
import start.start.spring.basic.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1l, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = "+ findMember.getName());

    }
}
