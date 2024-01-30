package dev.othamae.urlcorto.URL.utils;

import dev.othamae.urlcorto.URL.dto.UrlResponse;
import dev.othamae.urlcorto.URL.model.UrlCorto;

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
