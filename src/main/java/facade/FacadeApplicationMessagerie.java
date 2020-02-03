package facade;

import facade.exceptions.*;

import java.util.Collection;

public interface FacadeApplicationMessagerie {


    /**
     * Permet de s'inscrire à l'application
     * @param login
     * @param password
     * @throws LoginDejaPrisException : Le login est déjà pris
     * @throws InformationsNonConformesException : Au moins une des informations n'est pas conforme (vide ou non
     * renseignée.
     */
    void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException;


    /**
     * Permet de se désabonner de l'application
     * @param login
     * @param password
     * @throws DonneesIncoherentesException : le couple login/password n'est pas correct
     * @throws InformationsNonConformesException : Au moins une des informations n'est pas conforme (vide ou non
     * renseignée
     */
    void resiliser(String login, String password) throws DonneesIncoherentesException, InformationsNonConformesException;



    /**
     * Permet de se connecter à l'application
     * @param login
     * @param password
     * @throws DonneesIncoherentesException : le couple login/password n'est pas correct
     * @throws InformationsNonConformesException : Au moins une des informations n'est pas conforme (vide ou non
     * renseignée
     */
    long connexion(String login, String password)throws LoginDejaPrisException, InformationsNonConformesException, UtilisateurDejaConnecteException;


    /**
     * Permet de se déconnecter de l'application
     * @param idUtilisateur : identifiant de l'utilisateur demandant la déco
     * @throws InformationsNonConformesException
     */

    void deconnexion(long idUtilisateur) throws InformationsNonConformesException;


    /**
     * Permet d'envoyer un nouveau message de idEnvoyeur -> idDestinataire
     * @param idEnvoyeur
     * @param idDestinataire
     * @param contenu
     * @return id du message envoyé
     */

    long envoyerUnMessage(long idEnvoyeur, long idDestinataire, String contenu) throws UtilisateurNonConnecteException, UtilisateurInexistantException;


    /**
     * Permet de récupérer la liste des messages de l'utilisateur idUtilisateur. Cet utilisateur doit être connecté
     * @param idUtilisateur
     * @return
     * @throws UtilisateurNonConnecteException : l'utilisateur spécifié n'est pas connecté
     */

    Collection<MessageLight> getMesMessages(long idUtilisateur) throws UtilisateurNonConnecteException;


    /**
     * Permet de récupérer la liste des personnes inscrites à l'application. L'utilisateur idUtilisateur doit être connecté
     * @param idUtilisateur
     * @return
     * @throws UtilisateurNonConnecteException : l'utilisateur spécifié n'est pas connecté
     */

    Collection<UtilisateurLight> getListeDesInscrits(long idUtilisateur) throws UtilisateurNonConnecteException, UtilisateurInexistantException;



    MessageLight getMessageById(long idUtilisateur, long idMessage) throws UtilisateurNonConnecteException,
            MessageInexistantException, UtilisateurInexistantException;



}
