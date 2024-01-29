package dev.othamae.urlcorto.utils;

import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;

@Component
public class UrlCortoUtils {
  public String generateKey(String longUrl) {
    String sha256hex = Hashing.sha256()
        .hashString(longUrl, StandardCharsets.UTF_8)
        .toString();
    return sha256hex.substring(0, 6);
  }

}
