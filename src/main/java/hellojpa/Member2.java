package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "tb_member")
// sequence 사용 시 시퀀스 설정
//@SequenceGenerator(
//        name = "member_seq_generator", // 식별자 생성기 이름
//        sequenceName = "member_seq", // 매핑할 데이터베이스 시퀀스 이름
//        initialValue = 1, // 시작 숫자
//        allocationSize = 1 // 증가하는 수
//)

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
     *
     * SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용, ORACLE
     * @SequenceGenerator 필요
     *  -
     *
     * TABLE : 키 생성용 테이블 사용, 모든 DB에서 사용
     * @TableGenerator 필요
     *  - table을 생성해서 시퀀스처럼 사용
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
    @Column(name = "mb_id")
    private Long mbId;

    @Column(name = "user_name", nullable = false)
    private String mbUserName;

    public Member2() {}

    public Member2(Long mbId, String mbUserName) {
        this.mbId = mbId;
        this.mbUserName = mbUserName;
    }

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

