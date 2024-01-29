package dev.othamae.urlcorto.service;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.othamae.urlcorto.dto.UrlRequest;
import dev.othamae.urlcorto.dto.UrlResponse;
import dev.othamae.urlcorto.model.UrlCorto;
import dev.othamae.urlcorto.repository.UrlcortoRepository;
import dev.othamae.urlcorto.utils.UrlCortoUtils;
import dev.othamae.urlcorto.utils.UrlMapper;

@Service
public class UrlcortoService {

    @Autowired
    UrlcortoRepository urlcortoRepository;

    @Autowired
    UrlCortoUtils urlCortoUtils;

    public UrlResponse createUrlCorto(UrlRequest urlRequest) {
        String longUrl = urlRequest.getLongUrl();
        System.out.println(longUrl);

        if (urlAlreadyInDb(longUrl)) {
            return getUrlCortoByLongUrl(longUrl);
        }
        String key = urlCortoUtils.generateKey(longUrl);
        UrlCorto urlCorto = new UrlCorto();
        urlCorto.setLongUrl(longUrl);
        urlCorto.setKey(key);
        urlCorto.setCreatedAt(new Date());
        urlCorto.setUpdatedAt(new Date());
        urlcortoRepository.save(urlCorto);
        return UrlMapper.toUrlResponse(urlCorto);
    }

    public UrlResponse getUrlCortoByLongUrl(String longUrl) {
        UrlCorto urlCorto = urlcortoRepository.findUrlCortoByLongUrl(longUrl);
        return UrlMapper.toUrlResponse(urlCorto);
    }

    public ResponseEntity<Void> getUrlCortoByKey(String key) {
        System.out.println(key);
        UrlCorto urlCorto = urlcortoRepository.findUrlCortoByKey(key);
        System.out.println(urlCorto.getLongUrl());

        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .location(URI.create(urlCorto.getLongUrl()))
                .header(HttpHeaders.CONNECTION, "close").build();
    }

    public Boolean urlAlreadyInDb(String longUrl) {
        UrlCorto urlCorto = urlcortoRepository.findUrlCortoByLongUrl(longUrl);
        return (urlCorto != null);
    }
}
