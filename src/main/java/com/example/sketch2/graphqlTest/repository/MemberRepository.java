package com.example.sketch2.graphqlTest.repository;

import com.example.sketch2.graphqlTest.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
