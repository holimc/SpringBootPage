package com.holimc.sb.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
// 클래스의 모든 변수에 Getter 메서드를 자동으로 생성
@NoArgsConstructor
// Constructor = 생성자, 기본 생성자를 자동으로 추가하는 어노테이션
@Entity
// 테이블과 링크될 클래스임을 나타내는 어노테이션, 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블과 매칭
// ex) kakaoLogin -> kakao_login table
public class Posts {
    @Id
    // PK(기본키) 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false)
    // 테이블의 컬럼을 의미하는 어노테이션이며, RDBMS의 SQL로 치면 varchar2(500) not null이 된다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    // 빌더 패턴 클래스를 생성, 생성자의 상단에 생선시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    /*
        Entity 클래스에서는 Setter 메소드가 없다.
        그렇다면 해당 클래스에선 DB에 값을 삽입하기 위해선 기본적으로 생성자를 통해 최종 값을 채운후 DB에 삽입한다.
        값의 변경이 필요하다면 그때 해당 이벤트에 맞는 퍼블릭 메소드를 호출하여 변경하는걸 전제로 한다.

        그리고 이 외의 방법으로는 @Builder를 통해 제공되는 빌더 클래스를 이용한다.
        Example.builder()
            .a(a)
            .b(b)
            .build();
        위의 형식으로 빌더패턴을 사용한다면, 어느 필드에 어느 값이 들어가는지 명확하게 인지하고 쓸 수 있다

     */

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
