package dev.othamae.urlcorto.utils;

import dev.othamae.urlcorto.dto.UrlResponse;
import dev.othamae.urlcorto.model.UrlCorto;

public class UrlMapper {

    public static UrlResponse toUrlResponse(UrlCorto urlCorto) {
        UrlResponse urlResponse = new UrlResponse(
                urlCorto.getId(),
                urlCorto.getKey(),
                urlCorto.getLongUrl(),
                urlCorto.getCreatedAt(),
                urlCorto.getUpdatedAt()

        );
        return urlResponse;
    }
}
