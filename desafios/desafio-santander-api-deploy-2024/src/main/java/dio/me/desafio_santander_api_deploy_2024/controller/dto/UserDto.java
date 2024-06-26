package dio.me.desafio_santander_api_deploy_2024.controller.dto;

import dio.me.desafio_santander_api_deploy_2024.model.User;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public record UserDto(
        Long id,
        String name,
        AccountDto account,
        CardDto card,
        List<FeatureDto> featureList,
        List<NewsDto> newsList
) {
    public UserDto(User model) {
        this(
                model.getId(),
                model.getName(),
                ofNullable(model.getAccount()).map(AccountDto::new).orElse(null),
                ofNullable(model.getCard()).map(CardDto::new).orElse(null),
                ofNullable(model.getFeatureList()).orElse(emptyList()).stream().map(FeatureDto::new).collect(Collectors.toList()),
                ofNullable(model.getNewsList()).orElse(emptyList()).stream().map(NewsDto::new).collect(Collectors.toList())
        );
    }

    public User toModel() {
        User model = new User();
        model.setId(this.id);
        model.setName(this.name);
        model.setAccount(ofNullable(this.account).map(AccountDto::toModel).orElse(null));
        model.setCard(ofNullable(this.card).map(CardDto::toModel).orElse(null));
        model.setFeatureList(ofNullable(this.featureList).orElse(emptyList()).stream().map(FeatureDto::toModel).collect(Collectors.toList()));
        model.setNewsList(ofNullable(this.newsList).orElse(emptyList()).stream().map(NewsDto::toModel).collect(Collectors.toList()));
        return model;
    }
}
