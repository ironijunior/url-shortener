package br.com.ironijunior.urlshortener.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ironijunior.urlshortener.exception.InvalidURLException;
import br.com.ironijunior.urlshortener.persistence.UrlPO;
import br.com.ironijunior.urlshortener.repository.UrlRepository;

@Service
public class ShortenerService {

	@Autowired
	private UrlRepository urlRepo;
	
	public UrlPO shortUrl(UrlPO url) throws InvalidURLException {
		String id = generateId(url.getUrl());
		if(urlRepo.existsById(id)) {
			return getShortened(id, false);
		}
		url.setId(id);
		url.setHits(0);
		url.setShortenedUrl(transformUrl(id));
		
		return urlRepo.save(url);
	}

	public UrlPO getShortened(String id, boolean countStats) throws InvalidURLException {
		Optional<UrlPO> urlOpt = urlRepo.findById(id);
		if(urlOpt.isPresent()) {
			UrlPO url = urlOpt.get();
			if(countStats) {
				url = setStatistics(url);
			}
			return url;
		} else {
			throw new InvalidURLException();
		}
	}
	
	public UrlPO getShortened(String id) throws InvalidURLException {
		return getShortened(id, true);
	}

	private synchronized UrlPO setStatistics(UrlPO url) {
		Integer nGets = 0;
		if(url.getHits() != null) {
			nGets = url.getHits();
		}
		url.setHits(nGets + 1);
		url.setLastHit(new Date());
		
		return urlRepo.save(url);
	}

	private String generateId(String url) {
		return String.valueOf(url.getBytes().hashCode());
	}
	
	private String transformUrl(String id) {
		String prefix = "localhost:8080/";
		return prefix + id;
	}
	
}
