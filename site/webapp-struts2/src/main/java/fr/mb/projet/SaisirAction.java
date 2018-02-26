package fr.mb.projet;



import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;

/**
 * 
 */

public class SaisirAction extends ActionSupport {
    
    private String prenom;
    private String nom;
    
 
    @RequiredFieldValidator(message = "Please enter the name")
    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
   
    @RequiredStringValidator(message = "Please enter a firstname", trim = true)
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public String getPrenom() { return this.prenom; }
    
    public String execute() throws Exception {
        
        return SUCCESS;
    }
}
