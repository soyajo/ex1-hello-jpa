package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
// db 테이블명에 맞춰서 사용
//@Table(name = "MBR")
public class Member {

    public Member() {

    }

    public Member(Long id, String username, Integer age, RoleType roleType, Date createdDate, Date lastModifiedDate, String description) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.roleType = roleType;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", roleType=" + roleType +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Id
    private Long id;

    // unique 제약조건 잘 안씀2
    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private Integer age;
    // enum 타입 지정 어노테이션 - enum 에는 타입이 없어서 사용
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
    // 날짜 어노테이션
    // TemporalType.DATE
    // TemporalType.TIME
    // TemporalType.TIMESTAMP
    // 자바 8 이전
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // 자바 8 이상
    private LocalDate testLocalDate;
    private LocalDateTime testLocalDateTime;

    // 큰 컨텐츠를 넣을 때 사용
    // 문자면 CLOB 으로 맵핑
    // 나머지는 BLOB 맵핑
    @Lob
    private String description;

    // 디비 컬럼과 매칭을 안하고 메모리에서만 사용하는 컬럼 지정 매핑 x
    // @Transient

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
