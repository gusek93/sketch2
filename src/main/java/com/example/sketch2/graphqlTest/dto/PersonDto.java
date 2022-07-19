package com.example.sketch2.graphqlTest.dto;

import com.example.sketch2.graphqlTest.domain.Person;
import lombok.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {
    private Integer id;

    private Integer memberId;

    private String person;

    public static List<PersonDto> from(Collection<Person> entities) {
        if(entities == null) {
            return null;
        }
        return entities.stream().map(PersonDto::from).collect(Collectors.toList());
    }

    public static PersonDto from(Person entity) {
        return PersonDto.builder()
                .id(entity.getId())
                .memberId(entity.getMemberId())
                .person(entity.getPerson())
                .build();
    }
}
