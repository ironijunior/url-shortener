package br.com.ironijunior.urlshortener.exception;

public class InvalidURLException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidURLException() {
        super("Invalid URL.");
    }

}
