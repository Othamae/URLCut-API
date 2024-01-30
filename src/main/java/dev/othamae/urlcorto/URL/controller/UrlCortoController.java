package dev.othamae.urlcorto.URL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.othamae.urlcorto.URL.dto.UrlRequest;
import dev.othamae.urlcorto.URL.dto.UrlResponse;
import dev.othamae.urlcorto.URL.service.UrlcortoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "UrlCorto", description = "URL shortener generator")
@RestController
@RequestMapping("")
public class UrlCortoController {

    @Autowired
    private UrlcortoService urlcortoService;

    @GetMapping("/{key}")
    public ResponseEntity<Void> getUrl(@PathVariable String key) {
        return urlcortoService.getUrlCortoByKey(key);
    }

    @Operation(summary = "Url created", description = "Created shorter Url")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Url shorter created successfully", content = @Content(schema = @Schema(implementation = UrlResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error saving url", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public UrlResponse addUrl(@RequestBody UrlRequest urlRequest) {
        return urlcortoService.createUrlCorto(urlRequest);
    }

}
