package com.holimc.sb.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;


    @After
    //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정하는 어노테이션
    // 보통은 배포전 전체 테스트를 수행할때 테스트간 데이터 침범을 막기 위해 사용
    // 여러 테스트가 동시에 수행되면 테스트용 데이터베이스 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 테스트가 실패할 수 있다.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());
        // postsRepository.save : 테이블 posts에 insert/update 쿼리를 실행한다
        // id값이 있다면 update, 없으면 insert

        //when
        List<Posts> postsList = postsRepository.findAll();
        // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);


        /*
            src/main/resources/application.properties에 spring.jap.show_sql=true를 작성시

            Hibernate: insert into posts (id, author, content, title) values (null, ?, ?, ?)
            2022-07-28 20:49:19.389  INFO 12832 --- [           main] o.h.h.i.QueryTranslatorFactoryInitiator  : HHH000397: Using ASTQueryTranslatorFactory
            Hibernate: select posts0_.id as id1_0_, posts0_.author as author2_0_, posts0_.content as content3_0_, posts0_.title as title4_0_ from posts posts0_
            Hibernate: select posts0_.id as id1_0_, posts0_.author as author2_0_, posts0_.content as content3_0_, posts0_.title as title4_0_ from posts posts0_
            Hibernate: delete from posts where id=?

            이처럼 sql문을 직접 확인할 수 있다.

            또한, Hibernate: create table posts (id bigint generated by default as identity, author varchar(255), content TEXT not null, title varchar(500) not null, primary key (id))
            라는 쿼리를 보면 H2의 쿼리 문법이 적용되어있는데 MySQL의 쿼리를 수행해도 정상적으로 작동한다.
            application.propertie에서 설정시 쿼리 로그을 MySQL로 바꿀 수도있다.

         */
    }


}