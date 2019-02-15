package br.com.ironijunior.urlshortener.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ironijunior.urlshortener.exception.InvalidURLException;
import br.com.ironijunior.urlshortener.persistence.UrlPO;
import br.com.ironijunior.urlshortener.service.ShortenerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ShortenerController {

	@Autowired
	private ShortenerService shortenerService;
	
	@PostMapping(path="/short")
    public @ResponseBody UrlPO shortUrl(
    		@Valid @RequestBody(required=true) UrlPO object) throws InvalidURLException {
		if(StringUtils.isBlank(object.getUrl())) {
			throw new InvalidURLException();
		}
        return shortenerService.shortUrl(object);
    }
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Object> getShortenedUrl(
			@PathVariable(required=true) String id) throws InvalidURLException, URISyntaxException {
		
		UrlPO urlPO = shortenerService.getShortened(id);
		URI url = new URI(urlPO.getUrl());
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setLocation(url);
	    return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
	}
	
	@GetMapping(path="/{id}/stats")
	public UrlPO getStatsUrl(
			@PathVariable(required=true) String id) throws InvalidURLException, URISyntaxException {
		
		return shortenerService.getShortened(id, false);
	}
	
}
