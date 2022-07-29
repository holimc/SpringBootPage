package com.holimc.sb.web;

import com.holimc.sb.service.PostsService;
import com.holimc.sb.web.dto.PostsResponseDto;
import com.holimc.sb.web.dto.PostsSaveRequestDto;
import com.holimc.sb.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
// 생성자를 자동으로 생성해주는 어노테이션.
// NoArgsConstructor, AllArgsConstructor 등과 다른 점은 final이나 @NonNull 선언이 된 필드값만 받는 생성자를 만들어준다.
@RestController
public class PostsApiController {
    private final PostsService postsService;
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
