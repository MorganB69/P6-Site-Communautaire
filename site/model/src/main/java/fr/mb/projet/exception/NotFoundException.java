package fr.mb.projet.exception;

/**
 * Classe d'exception lev�e quand l'objet m�tier demand� n'a pas �t� trouv�
 *
 *
 */
public class NotFoundException extends Exception {

    /**
     * Constructeur par d�faut.
     */
    public NotFoundException() {
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public NotFoundException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public NotFoundException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}