package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.MembersLoginRequestDto;
import meQ.backend.domain.dto.MembersResponseDto;
import meQ.backend.domain.dto.MembersSaveRequestDto;
import meQ.backend.domain.entity.Members;
import meQ.backend.exception.LoginFailException;
import meQ.backend.repository.MembersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MembersService {
    private final MembersRepository membersRepository;
    private final PasswordEncoder passwordEncoder;

    private Members findMembers(Long membersKey) {
        return membersRepository.findById(membersKey)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + membersKey + "] members"));
    }

    public boolean isExistMembersWithMembersId(String membersId) {
        return membersRepository.existsByMembersId(membersId);
    }

    public Members findMembersWithMembersId(String membersId) {
        return membersRepository.findByMembersId(membersId)
                .orElseThrow(() -> new IllegalArgumentException("there is no" + membersId + "] members"));
    }

    public String save(MembersSaveRequestDto requestDto) {
        Members members = Members.createMembers(requestDto, passwordEncoder.encode(requestDto.getPassword()));
        return membersRepository.save(members).getMembersId();
    }

    public MembersResponseDto login(MembersLoginRequestDto requestDto) {
        if (!isExistMembersWithMembersId(requestDto.getMembersId())) {
            throw new LoginFailException("id or password is not valid");
        }

        Members members = findMembersWithMembersId(requestDto.getMembersId());

        if (passwordEncoder.matches(requestDto.getMembersPassword(), members.getPassword())) {
            return MembersResponseDto.builder()
                    .members(members)
                    .build();
        } else {
            throw new LoginFailException("id or password is not valid");
        }
    }

    public MembersResponseDto getMembers(Long membersKey) {
        return MembersResponseDto.builder()
                .members(findMembers(membersKey))
                .build();
    }
}
