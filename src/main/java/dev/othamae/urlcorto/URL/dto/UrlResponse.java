package dev.othamae.urlcorto.URL.dto;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlResponse {

    @Schema(example = "1", description = "")
    private Long id;

    @Schema(example = "https://urlcorto.com/8efb33", description = "")
    private String shortUrl;

    @Schema(example = "https://developer.redis.com/assets/images/hackernews-974e3026a35651a1790714fa7f947184.png", description = "")
    private String longUrl;

    private Date createdAt;

    private Date updatedAt;
}
