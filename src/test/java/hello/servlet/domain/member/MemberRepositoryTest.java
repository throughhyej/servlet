package hello.servlet.domain.member;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member("member1", 30);
        Member saveMember = memberRepository.save(member);
        Member findMameber = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(saveMember).isEqualTo(findMameber);
    }

    @Test
    public void findAll() {

        Member member1 = new Member("member1", 30);
        Member member2 = new Member("member2", 31);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> memberAll = memberRepository.findAll();

//        int loop = 5;
//        for (int i = 0; i < loop; i++) {
//            int num = i + 1;
//            Member member = new Member("member" + num, num + 10);
//            memberRepository.save(member);
//        }
//        Assertions.assertThat(memberAll.size()).isEqualTo(loop);

        Assertions.assertThat(memberAll.size()).isEqualTo(2);
        Assertions.assertThat(memberAll).contains(member1, member2);
    }

}
