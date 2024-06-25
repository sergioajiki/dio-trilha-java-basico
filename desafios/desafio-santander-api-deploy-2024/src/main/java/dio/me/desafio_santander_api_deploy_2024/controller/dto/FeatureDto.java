package dio.me.desafio_santander_api_deploy_2024.controller.dto;

import dio.me.desafio_santander_api_deploy_2024.model.Feature;

public record FeatureDto(
        Long id,
        String icon,
        String description
) {
    public FeatureDto(Feature model) {
        this(model.getId(),
                model.getIcon(),
                model.getDescription());
    }

    public Feature toModel() {
        Feature model = new Feature();
        model.setId(this.id);
        model.setIcon(this.icon);
        model.setDescription(this.description);
        return model;
    }
}
