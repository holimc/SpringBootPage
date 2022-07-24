package com.holimc.sb.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "고길동";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        // assertj라는 테스트 검증 라이브러리의 검증 메소드이고, 검증하는 대상을 메소드로 인자를 받아
        // 연계되는 메소드인 isEqualTo로 같은지 검증한다. 같다면 성공
    }
}
