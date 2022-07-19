package com.example.sketch2.graphqlTest.dto;


import com.example.sketch2.graphqlTest.domain.Member;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Integer id;

    private String loginId;

    private String password;

    private String name;

    private List<PersonDto> persons;

    public static List<MemberDto> from(Collection<Member> entities) {
        return entities.stream().map(MemberDto::from).collect(Collectors.toList());
    }

    public static MemberDto from(Member entity) {
        return MemberDto.builder()
                .id(entity.getId())
                .loginId(entity.getLoginId())
                .password(entity.getPassword())
                .name(entity.getName())
                .persons(PersonDto.from(entity.getPersons()))
                .build();
    }
}
