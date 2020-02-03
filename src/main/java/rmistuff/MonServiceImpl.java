package rmistuff;

import facade.FacadeApplicationMessagerie;
import facade.FacadeApplicationMessagerieImpl;
import facade.MessageLight;
import facade.UtilisateurLight;
import facade.exceptions.*;

import java.rmi.RemoteException;
import java.util.Collection;

/**
 * Created by YohanBoichut on 08/10/14.
 */
public class MonServiceImpl implements MonService {

    private final static FacadeApplicationMessagerie facadeApplicationMessagerie = new FacadeApplicationMessagerieImpl();


    @Override
    public void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException, RemoteException {
        facadeApplicationMessagerie.inscription(login,password);
    }

    @Override
    public void resiliser(String login, String password) throws DonneesIncoherentesException, InformationsNonConformesException, RemoteException {
        facadeApplicationMessagerie.resiliser(login, password);
    }

    @Override
    public long connexion(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException, UtilisateurDejaConnecteException, RemoteException {
        return facadeApplicationMessagerie.connexion(login, password);
    }

    @Override
    public void deconnexion(long idUtilisateur) throws InformationsNonConformesException, RemoteException {
        facadeApplicationMessagerie.deconnexion(idUtilisateur);
    }

    @Override
    public long envoyerUnMessage(long idEnvoyeur, long idDestinataire, String contenu) throws UtilisateurNonConnecteException, UtilisateurInexistantException, RemoteException {
        return facadeApplicationMessagerie.envoyerUnMessage(idEnvoyeur, idDestinataire, contenu);
    }

    @Override
    public Collection<MessageLight> getMesMessages(long idUtilisateur) throws UtilisateurNonConnecteException, RemoteException {
        return facadeApplicationMessagerie.getMesMessages(idUtilisateur);
    }

    @Override
    public Collection<UtilisateurLight> getListeDesInscrits(long idUtilisateur) throws UtilisateurNonConnecteException, UtilisateurInexistantException, RemoteException {
        return facadeApplicationMessagerie.getListeDesInscrits(idUtilisateur);
    }

    @Override
    public MessageLight getMessageById(long idUtilisateur, long idMessage) throws UtilisateurNonConnecteException, MessageInexistantException, UtilisateurInexistantException, RemoteException {
        return getMessageById(idUtilisateur, idMessage);
    }
}
