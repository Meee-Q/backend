package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.entity.Foods;
import meQ.backend.repository.FoodsRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FoodsService {

    private final FoodsRepository foodsRepository;

    public void setting() {
        foodsRepository.save(Foods.createFavoriteFoods("사과"));
        foodsRepository.save(Foods.createFavoriteFoods("바나나"));
        foodsRepository.save(Foods.createFavoriteFoods("오렌지"));
        foodsRepository.save(Foods.createFavoriteFoods("딸기"));
        foodsRepository.save(Foods.createFavoriteFoods("브로콜리"));
        foodsRepository.save(Foods.createFavoriteFoods("시금치"));
        foodsRepository.save(Foods.createFavoriteFoods("당근"));
        foodsRepository.save(Foods.createFavoriteFoods("양파"));
        foodsRepository.save(Foods.createFavoriteFoods("버섯"));
        foodsRepository.save(Foods.createFavoriteFoods("콩나물"));
        foodsRepository.save(Foods.createFavoriteFoods("토마토"));
        foodsRepository.save(Foods.createFavoriteFoods("소고기"));
        foodsRepository.save(Foods.createFavoriteFoods("돼지고기"));
        foodsRepository.save(Foods.createFavoriteFoods("양고기"));
        foodsRepository.save(Foods.createFavoriteFoods("베이컨"));
        foodsRepository.save(Foods.createFavoriteFoods("새우"));
        foodsRepository.save(Foods.createFavoriteFoods("굴"));
        foodsRepository.save(Foods.createFavoriteFoods("조개"));
        foodsRepository.save(Foods.createFavoriteFoods("문어"));
        foodsRepository.save(Foods.createFavoriteFoods("게"));
        foodsRepository.save(Foods.createFavoriteFoods("랍스터"));
        foodsRepository.save(Foods.createFavoriteFoods("달걀"));
        foodsRepository.save(Foods.createFavoriteFoods("치즈"));
        foodsRepository.save(Foods.createFavoriteFoods("우유"));
        foodsRepository.save(Foods.createFavoriteFoods("버터"));
        foodsRepository.save(Foods.createFavoriteFoods("고등어"));
        foodsRepository.save(Foods.createFavoriteFoods("연어"));
        foodsRepository.save(Foods.createFavoriteFoods("두부"));
        foodsRepository.save(Foods.createFavoriteFoods("아보카도"));
        foodsRepository.save(Foods.createFavoriteFoods("가지"));
        foodsRepository.save(Foods.createFavoriteFoods("케일"));
        foodsRepository.save(Foods.createFavoriteFoods("바질"));
        foodsRepository.save(Foods.createFavoriteFoods("고수"));
        foodsRepository.save(Foods.createFavoriteFoods("로즈마리"));
        foodsRepository.save(Foods.createFavoriteFoods("아몬드"));
        foodsRepository.save(Foods.createFavoriteFoods("호두"));
        foodsRepository.save(Foods.createFavoriteFoods("호박"));
        foodsRepository.save(Foods.createFavoriteFoods("피망"));
        foodsRepository.save(Foods.createFavoriteFoods("감자"));
        foodsRepository.save(Foods.createFavoriteFoods("고구마"));
        foodsRepository.save(Foods.createFavoriteFoods("오트밀"));
        foodsRepository.save(Foods.createFavoriteFoods("콩"));
    }
}
