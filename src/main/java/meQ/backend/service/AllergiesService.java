package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.entity.Allergies;
import meQ.backend.repository.AllergiesRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AllergiesService {
    private final AllergiesRepository allergiesRepository;

    public void setting() {
        allergiesRepository.save(Allergies.createAllergies("메밀"));
        allergiesRepository.save(Allergies.createAllergies("밀"));
        allergiesRepository.save(Allergies.createAllergies("대두"));
        allergiesRepository.save(Allergies.createAllergies("호두"));
        allergiesRepository.save(Allergies.createAllergies("땅콩"));
        allergiesRepository.save(Allergies.createAllergies("복숭아"));
        allergiesRepository.save(Allergies.createAllergies("토마토"));
        allergiesRepository.save(Allergies.createAllergies("돼지고기"));
        allergiesRepository.save(Allergies.createAllergies("난류(가금류)"));
        allergiesRepository.save(Allergies.createAllergies("우유"));
        allergiesRepository.save(Allergies.createAllergies("닭고기"));
        allergiesRepository.save(Allergies.createAllergies("쇠고기"));
        allergiesRepository.save(Allergies.createAllergies("새우"));
        allergiesRepository.save(Allergies.createAllergies("고등어"));
        allergiesRepository.save(Allergies.createAllergies("홍합"));
        allergiesRepository.save(Allergies.createAllergies("전복"));
        allergiesRepository.save(Allergies.createAllergies("굴"));
        allergiesRepository.save(Allergies.createAllergies("조개류"));
        allergiesRepository.save(Allergies.createAllergies("게"));
        allergiesRepository.save(Allergies.createAllergies("오징어"));
        allergiesRepository.save(Allergies.createAllergies("아황산 포함 식품"));
    }
}
