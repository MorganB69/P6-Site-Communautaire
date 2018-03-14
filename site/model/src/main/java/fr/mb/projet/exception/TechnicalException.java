package fr.mb.projet.exception;

public class TechnicalException extends Exception {
	
	 public TechnicalException(String pMessage) {
	        super(pMessage);
	    }


	    public TechnicalException(String pMessage, Throwable pCause) {
	        super(pMessage, pCause);
	    }
}
