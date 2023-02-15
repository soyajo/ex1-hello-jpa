package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_member")
// sequence 사용 시 시퀀스 설정
@SequenceGenerator(
        name = "member_seq_generator", // 식별자 생성기 이름
        sequenceName = "member_seq", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, // 시작 숫자
        allocationSize = 50 // 증가하는 수
)

// table 사용 시 설정
//@TableGenerator(
//        name = "member_seq_generator", // 식별자 생성기 이름
//        table = "my_sequences", // 매핑할 데이터베이스 시퀀스 이름
//        pkColumnValue = "member_seq",
//        allocationSize = 1
//)
public class Member2 {

    /**
     * 직접 할당 : Id만 사용
     * 자동 생성 : (@GeneratedValue)
     *
     * IDENTITY : 데이터베이스에 위임, MYSQL
     *  - 예 : AUTO_INCREMENT
     *  - 기본 키 생성을 데이터베이스에게 위임
     *  - AUTO_INCREMENT는 데이터베이스에 insert sql을 실행한 이후에 id값을 알 수 있음.
     *  - em.persist() 시점에 즉시 insert sql이 실행하고 db에서 식별자를 조회한다.
     *  - persistence.xml 에 DB 설정 중 dialect 설정 이슈.. 이상하게 h2 디비를 사용할 때 create 할 때는 h2로 해야하고 insert 할 때는 mysql로 사용해야한다.. 아마 쿼리문에 이상한게 붙어서 그런듯 ...
     *
     *
     *
     * SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용, ORACLE
     * @SequenceGenerator 필요
     *  - allocationSize : 애플리케이션 올라갈때 50개로 지정되있으면 insert sql 이 50번 실행되기 전까지 저장되어있다가 다쓰면 또 다시 51 ~ 100 까지 저장됨.
     *  - 서버가 자주꺼지면 힘들수도... 시퀀스 번호가 띄엄띄엄 있을 수 있다.
     *  - 동시성 문제는 없음.
     *
     * TABLE : 키 생성용 테이블 사용, 모든 DB에서 사용
     * @TableGenerator 필요
     *  - table을 생성해서 시퀀스처럼 사용1
     *  - allocationSize : 애플리케이션 올라갈때 50개로 지정되있으면 insert sql 이 50번 실행되기 전까지 저장되어있다가 다쓰면 또 다시 51 ~ 100 까지 저장됨.
     *  - 장점 : 모든 디비에서 사용가능
     *  - 단점 : 성능 이슈
     *  - 사용 잘 안함.
     *
     * AUTO : DB 방언에 따라 자동 지정, 기본값
     *  -
     */
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
//    , generator = "member_seq_generator" // 시퀀스 적용
//            , generator = "member_seq_generator" // table 적용
    )
    @Column(name = "MB_ID")
    private Long mbId;

    @Column(name = "USER_NAME", nullable = false)
    private String mbUserName;
//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name = "TEAM_ID",insertable = false,updatable = false) // 읽기 전용
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;


//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

    public Long getMbId() {
        return mbId;
    }

    public void setMbId(Long mbId) {
        this.mbId = mbId;
    }

    public String getMbUserName() {
        return mbUserName;
    }

    public void setMbUserName(String mbUserName) {
        this.mbUserName = mbUserName;
    }

}

