package start.start.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.start.spring.repository.MemberRepository;
import start.start.spring.repository.MemoryMemberRepository;
import start.start.spring.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
