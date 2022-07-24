package com.holimc.sb.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// 테스트를 진행할때 JUnit에 내장된 실행자 외에 다른 실행자를 싱행시킵니다. 여기서는 SpringRunner.class라는 스프링 실행자가 실행된다
// 스프링부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class)
// 스프링 테스트 어노테이션중 WEb(SpirngMVC)에 집중하는 어노테이션
// 선언시 @Controller, @ControllerAdvice 등을 사용할 수 있고, @Service, @Component, @Repository 등은 불가능
public class HelloControllerTest {

    @Autowired
    // 빈 주입하는 오토와이어드
    private MockMvc mvc;
    // 웹 API를 테스트할때 사용, 이 클래스를 통해 HTTP GET, POST 등에 대한 테스트 가능

    @Test
    public void Hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다. 이어붙여서 아래와같이 다른 검증기능도 가능
                .andExpect(status().isOk())
                // mvc.perform의 결과를 검증. 200, 404, 500 등의 상태를 확인하며, isOk는 200(페이지 정상작동)하는지 검증
               .andExpect(content().string(hello));
                // 응답 내용이 ()안의 내용과 일치하는지 검증, 이경우는 hello가 출력되는지 확인한다.

    }

    @Test
    public void HelloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                                // param : API 테스트 할때 사용될 요청 파라미터를 설정. 값은 String만 허용
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
                //jsonPath : JSON 응답값을 필드별로 검증, $를 기준으로 필드명을 명시함.

    }
}
