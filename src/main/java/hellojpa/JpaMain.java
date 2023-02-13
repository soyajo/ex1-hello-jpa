package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member2 member2 = new Member2();
            member2.setMbUserName("AA");

            em.persist(member2);

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

            System.out.println("=====================");
//            Member findMember1 = em.find(Member.class, 101L);
//            //한번 조회된 쿼리는 1차 캐시에 가져옴
//            Member findMember2 = em.find(Member.class, 101L);

//            System.out.println("result = " + (findMember1 == findMember2));

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
