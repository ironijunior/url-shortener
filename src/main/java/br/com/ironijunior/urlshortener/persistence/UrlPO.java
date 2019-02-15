package br.com.ironijunior.urlshortener.persistence;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UrlPO {

	@Id
	private String id;

	private String url;

	private String shortenedUrl;

	private Integer hits;

	private Date lastHit;

}
