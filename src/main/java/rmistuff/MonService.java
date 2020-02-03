package rmistuff;

import facade.MessageLight;
import facade.UtilisateurLight;
import facade.exceptions.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * Created by YohanBoichut on 08/10/14.
 */
public interface MonService extends Remote{


    public final String serviceName = "ApplicationMessagerieService";


    void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException, RemoteException;



    /**
     * Permet de se désabonner de l'application
     * @param login
     * @param password
     * @throws DonneesIncoherentesException : le couple login/password n'est pas correct
     * @throws InformationsNonConformesException : Au moins une des informations n'est pas conforme (vide ou non
     * renseignée
     */
    void resiliser(String login, String password) throws DonneesIncoherentesException, InformationsNonConformesException, RemoteException;



    /**
     * Permet de se connecter à l'application
     * @param login
     * @param password
     * @throws DonneesIncoherentesException : le couple login/password n'est pas correct
     * @throws InformationsNonConformesException : Au moins une des informations n'est pas conforme (vide ou non
     * renseignée
     */
    long connexion(String login, String password)throws LoginDejaPrisException, InformationsNonConformesException, UtilisateurDejaConnecteException, RemoteException;


    /**
     * Permet de se déconnecter de l'application
     * @param idUtilisateur : identifiant de l'utilisateur demandant la déco
     * @throws InformationsNonConformesException
     */

    void deconnexion(long idUtilisateur) throws InformationsNonConformesException, RemoteException;


    /**
     * Permet d'envoyer un nouveau message de idEnvoyeur -> idDestinataire
     * @param idEnvoyeur
     * @param idDestinataire
     * @param contenu
     * @return id du message envoyé
     */

    long envoyerUnMessage(long idEnvoyeur, long idDestinataire, String contenu) throws UtilisateurNonConnecteException, UtilisateurInexistantException, RemoteException;


    /**
     * Permet de récupérer la liste des messages de l'utilisateur idUtilisateur. Cet utilisateur doit être connecté
     * @param idUtilisateur
     * @return
     * @throws UtilisateurNonConnecteException : l'utilisateur spécifié n'est pas connecté
     */

    Collection<MessageLight> getMesMessages(long idUtilisateur) throws UtilisateurNonConnecteException, RemoteException;


    /**
     * Permet de récupérer la liste des personnes inscrites à l'application. L'utilisateur idUtilisateur doit être connecté
     * @param idUtilisateur
     * @return
     * @throws UtilisateurNonConnecteException : l'utilisateur spécifié n'est pas connecté
     */

    Collection<UtilisateurLight> getListeDesInscrits(long idUtilisateur) throws UtilisateurNonConnecteException, UtilisateurInexistantException, RemoteException;



    MessageLight getMessageById(long idUtilisateur, long idMessage) throws UtilisateurNonConnecteException,
            MessageInexistantException, UtilisateurInexistantException, RemoteException;



}
