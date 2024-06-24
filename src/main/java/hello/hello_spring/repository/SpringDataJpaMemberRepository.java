package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스가 인터페이스를 받을때는 extends라고 한다.
//인터페이스는 다중 상속이 가능하다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //인터페이스 이름을 기준으로 한다. ex) findByNameAndId(String name, Long id);
    //JPQL select m from Member as m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
