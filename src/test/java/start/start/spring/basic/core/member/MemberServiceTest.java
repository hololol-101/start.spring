package start.start.spring.basic.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import start.start.spring.basic.core.AppConfig;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
