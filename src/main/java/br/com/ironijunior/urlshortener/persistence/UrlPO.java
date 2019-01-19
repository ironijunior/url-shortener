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

	private String shortenUrl;

	private Integer numberOfGets;

	private Date lastGet;

}
