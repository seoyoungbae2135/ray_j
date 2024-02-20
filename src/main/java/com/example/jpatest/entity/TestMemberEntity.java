package com.example.jpatest.entity;
//20240215-7
import com.example.jpatest.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 20240215-7 클래스를 Entity 로 선언하여 이 클래스에서 db 테이블을 만들어 관리한다
@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestMemberEntity {

    @Id //db 에서 primary key 설정할 변수 위에 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column  // db 에서 column 설정할 변수위에 설정
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String tel;

    @OneToMany(mappedBy = "testMemberEntity") //20240219-4 다대일 양방향 설정
    List<LoginHistoryEntity> loginHistoryEntityList = new ArrayList<>();


    public static TestMemberEntity toEntity(MemberDto memberDto){
        return TestMemberEntity.builder()
                .email(memberDto.getEmail())
                .name(memberDto.getName())
                .tel(memberDto.getTel())
                .password(memberDto.getPassword())
                .id(memberDto.getId())
                .build();
    }
}