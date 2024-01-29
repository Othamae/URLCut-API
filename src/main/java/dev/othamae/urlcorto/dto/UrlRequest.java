package dev.othamae.urlcorto.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlRequest {

    @Schema(example = "https://developer.redis.com/assets/images/hackernews-974e3026a35651a1790714fa7f947184.png", description = "")
    private String longUrl;
}
