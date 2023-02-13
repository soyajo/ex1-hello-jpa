package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
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
////            em.detach(member);
//            System.out.println("==== AFTER =====");



//            변경 감지 (dirty checking) - member.update()가 존재하지 않다. 영속성 컨텍스트가 처리함.
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAAA");
            em.detach(member);

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
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }

}
