package com.holimc.sb.web;

import com.holimc.sb.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러를 json으로 반환하는 컨트롤러로 만들어 줍니다.
// ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용한다고 생각하면 된다.
public class HelloController {
    @GetMapping("/hello")
    // Http Method인 Get의 요청을 받을 수 있는 API를 만들어 줍니다.
    // 스프링 프레임워크로 만든 프로젝트에서 @RequestMapping(method = RequestMethod.GET)으로 사용한것과 같은? 비슷한? 기능이다
    public String hello(){
        return "hello";
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        // RequestParam 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 입니다. 외부에서 name이라는 이름으로 넘긴 파라미터를
        // 받아서, 매개변수 String name으로 저장하게됩니다.
        return new HelloResponseDto(name, amount);
    }
}
