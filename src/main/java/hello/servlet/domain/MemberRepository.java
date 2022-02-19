package hello.servlet.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    /** 동시성이 고려되지 않음: 실무에서는 ConcurrentHashMap / AtomicLong 사용 고려 **/
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    /** servlet 기반임으로 spring 미사용: singleton으로 직접 설정 **/
    private static final MemberRepository instance = new MemberRepository();
    private MemberRepository() {} // singleton 이기 때문에 객체 생성을 막음
    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
