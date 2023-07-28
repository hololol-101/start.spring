package start.start.spring.service;

import start.start.spring.domain.Member;
import start.start.spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public class MemberService {
    private final MemberRepository memberRepository ;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Transactional
    /*회원가입*/
    public Long join(Member member){
        validateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    /*전체 회원 조회*/
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**/
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

}
