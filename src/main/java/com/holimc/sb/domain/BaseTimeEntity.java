package com.holimc.sb.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// 객체의 입장에서 공통 매핑 정보가 필요할때 사용한다.
// 작성자, 작성시간, 수정자, 수정시간 등 모든 엔티티가 공통으로 가져가야하는 상황에서 사용한다.
// (추상 클래스 사용을 권장한다고 한다)
@EntityListeners(AuditingEntityListener.class)
// Audit = 검사로 AuditingEntityListener를 사용해 데이터가 생성되거나 수정등이 발생하는걸 검사하여 자동으로 값을 넣어준다.
public abstract class BaseTimeEntity {
    @CreatedDate
    // 데이터가 생성된 시간을 저장
    private LocalDateTime createdDate;

    @LastModifiedDate
    // 데이터를 마지막으로 변경한 시간을 저장
    private LocalDateTime modifiedDate;
}
