package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.ClearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring!!");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member = new Member();
        member.setName("findByName");
        repository.save(member);

        Member result = repository.findByName("findByName").get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member = new Member();
        member.setName("findByName");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("findByName2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("findByName3");
        repository.save(member3);

        List<Member> members = new ArrayList<>();
        members.add(member);
        members.add(member2);
        members.add(member3);

        List<Member> result = repository.findAll();

        assertThat(members).isEqualTo(result);
    }
}
