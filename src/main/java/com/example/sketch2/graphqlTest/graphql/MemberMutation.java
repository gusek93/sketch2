package com.example.sketch2.graphqlTest.graphql;

import com.example.sketch2.graphqlTest.domain.Member;
import com.example.sketch2.graphqlTest.domain.Person;
import com.example.sketch2.graphqlTest.dto.MemberDto;
import com.example.sketch2.graphqlTest.repository.MemberRepository;
import com.example.sketch2.graphqlTest.repository.PersonRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Component
@RequiredArgsConstructor
@Transactional
public class MemberMutation implements GraphQLMutationResolver {
    private final MemberRepository memberRepository;

    private final PersonRepository personRepository;

    public MemberDto createMember(MemberDto memberDto) {
        Member member = memberRepository.save(Member.builder()
                .loginId(memberDto.getLoginId())
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .build());
        return MemberDto.from(member);
    }

    public Boolean deleteMember(int id){
        Optional<Member> optionalMember = memberRepository.findById(id);
        Person person = personRepository.findByMemberId(id);
        if(optionalMember.isPresent()) {
            personRepository.delete(person);
            memberRepository.delete(optionalMember.get());
        }
        return true;
    }
}
