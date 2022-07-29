package com.holimc.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
// JPA의 Audit 기능을 활성화 한다.
@SpringBootApplication
// 스프링 부트의 자동 설정, beans 읽기 생성을 모두 자동으로 설정된다 (위의 import를 보면 autoconfigure이므로 추측이 가능)
// 또한, 해당 어노테이션이 있는 부분부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야한다.
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //SpringApplacation.run을 통해 내장 WAS를 사용한다. 스프링 부트의 장점으로 가벼운 프로젝트를 할때 유리하다는 부분이 있는데
        //이렇게 내장 WAS를 쓰면 톰캣이 없어도 되며, 언제 어디서나 같은 환경으로 배포하기 좋다
    }

}
