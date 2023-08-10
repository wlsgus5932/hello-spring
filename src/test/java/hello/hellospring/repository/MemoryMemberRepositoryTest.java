package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repo.clearStore();
    }
    //repo test code
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repo.save(member);
        Member result = repo.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repo.save(member2);

        Member result = repo.findByName(member1.getName()).get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member1.setName("spring2");
        repo.save(member2);

        List<Member> result = repo.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
