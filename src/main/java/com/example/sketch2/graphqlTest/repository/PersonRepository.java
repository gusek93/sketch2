package com.example.sketch2.graphqlTest.repository;

import com.example.sketch2.graphqlTest.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByMemberId(int memberId);
}
