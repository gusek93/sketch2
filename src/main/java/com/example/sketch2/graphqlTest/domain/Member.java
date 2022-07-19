package com.example.sketch2.graphqlTest.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String loginId;

    private String password;

    private String name;

    @OneToMany
    @JoinColumn(name ="memberId")
    private List<Person> Persons = new ArrayList<>();
}
