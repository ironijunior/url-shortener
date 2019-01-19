package br.com.ironijunior.urlshortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ironijunior.urlshortener.persistence.UrlPO;

public interface UrlRepository extends JpaRepository<UrlPO, String> {

}
