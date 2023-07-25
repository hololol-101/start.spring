package start.start.spring.repository;

import start.start.spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    public Member save(Member member);
    //Optional 사용 이유: find 했을 때 값이 널인경우 Optional로 감싸서 넘겨줄 수 있음
    public Optional<Member> findById(Long id);
    public Optional<Member> findByName(String name);
    public List<Member> findAll();
}
