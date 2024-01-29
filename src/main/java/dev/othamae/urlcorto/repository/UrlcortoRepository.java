package dev.othamae.urlcorto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.othamae.urlcorto.model.UrlCorto;

@Repository
public interface UrlcortoRepository extends JpaRepository<UrlCorto, Long> {

    UrlCorto findUrlCortoByLongUrl(String longUrl);

    UrlCorto findUrlCortoByKey(String key);

}
