package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.lang.reflect.Member;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {


            // seqence allocation 속성 테스트
//            Member2 member1 = new Member2();
//            member1.setMbUserName("AA");
//            Member2 member2 = new Member2();
//            member2.setMbUserName("BB");
//            Member2 member3 = new Member2();
//            member3.setMbUserName("CC");
//
//            System.out.println("=================");
//            em.persist(member1); // 1, 51
//            em.persist(member2); // memory
//            em.persist(member3); // memory
//            System.out.println("member1.getMbId() = " + member1.getMbId());
//            System.out.println("member2.getMbId() = " + member2.getMbId());
//            System.out.println("member3.getMbId() = " + member3.getMbId());
//            System.out.println("=================");




            // persistence db ddl auto 설정 test
//            Member1 member1 = new Member1();
//            member1.setId(1L);
//            member1.setUsername("A");
//            member1.setRoleType(RoleType.USER);
//            em.persist(member1);
//
//            Member1 member12 = new Member1();
//            member12.setId(2L);
//            member12.setUsername("B");
//            member12.setRoleType(RoleType.ADMIN);
//            em.persist(member12);
//
//            Member1 member13 = new Member1();
//            member13.setId(3L);
//            member13.setUsername("C");
//            member13.setRoleType(RoleType.GUEST);
//            em.persist(member13);

//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

//            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            // 영속
//            System.out.println("==== BEFORE =====");
//            em.persist(member);
//            // 준영속(영속성 컨테스트 지우기)
//            em.detach(member);
//            System.out.println("==== AFTER =====");

//            // 쓰기 지연 batch - persistence.xml 파일에 설정해야함. <property name="hibernate.jdbc.batch_size" value="10"/>
//            Member m1 = new Member(15L, "SS1");
//            Member m2 = new Member(16L, "SS2");
//            Member m3 = new Member(17L, "SS3");
//            Member m4 = new Member(18L, "SS4");
//            em.persist(m1);
//            em.persist(m2);
//            em.persist(m3);
//            em.persist(m4);

            // 변경 감지 (dirty checking) - member.update()가 존재하지 않다. 영속성 컨텍스트가 처리함.
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAAAA");

//            em.detach(member);

            // 직접 디비에 커밋 시킴.
//            em.flush();

            // 영속성 컨텍스트 초기화
//            em.clear();

            // 영속성 컨텍스트 종료
//            em.close();

//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();

//            System.out.println("=====================");
//            Member findMember1 = em.find(Member.class, 101L);
//            //한번 조회된 쿼리는 1차 캐시에 가져옴
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("result = " + (findMember1 == findMember2));

            // 저장


            // 1대다 관계 - update 쿼리가 하나 더 나감.
            // @JoinColumn 을 안쓰면 join 테이블이 하나 더 생김.
            Member2 member = new Member2();
            member.setMbUserName("member1");
            em.persist(member);

            // 연관관계 편의 메서드 - 둘 중 하나만
//            member.changeTeam(team); // **
            Team team = new Team();
            team.setName("TeamA");
            team.getMembers().add(member);

            em.persist(team);


            // 연관관계 편의 메서드 - 둘 중 하나만
//            team.addMember(member); // **

//            em.flush();
//            em.clear();

//            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시
//            List<Member2> members = findTeam.getMembers();

            System.out.println("=================");
//            for (Member2 member1 : members) {
//                System.out.println("member1.getMbId() = " + member1.getMbId());
//            }
            System.out.println("=================");

//            Member2 findMember = em.find(Member2.class, member.getMbId());
//            List<Member2> members = findMember.getTeam().getMembers();
//
//            for (Member2 m : members) {
//                System.out.println("m.getMbUserName() = " + m.getMbUserName());
//            }

//            Team findTeam = findMember.getTeam();
//            System.out.println("findTeam = " + findTeam.getName());

            // 변경
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

            //db에 쿼리 적용
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }

}
