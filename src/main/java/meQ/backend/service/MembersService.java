package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.MembersSaveRequestDto;
import meQ.backend.domain.entity.Members;
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

    public String save(MembersSaveRequestDto requestDto) {
        Members members = Members.createMembers(requestDto, passwordEncoder.encode(requestDto.getPassword()));
        return membersRepository.save(members).getMembersId();
    }
}
