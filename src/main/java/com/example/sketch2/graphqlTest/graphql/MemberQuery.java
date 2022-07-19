package com.example.sketch2.graphqlTest.graphql;

import com.example.sketch2.graphqlTest.domain.Member;
import com.example.sketch2.graphqlTest.dto.MemberDto;
import com.example.sketch2.graphqlTest.repository.MemberRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
@Transactional
public class MemberQuery implements GraphQLQueryResolver {
    private final MemberRepository memberRepository;

    public MemberDto getMember(int id) {
        Member member = memberRepository.findById(id)
                .orElse(null);
        return MemberDto.from(member);
    }

}
