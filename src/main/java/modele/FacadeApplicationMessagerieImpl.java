package modele;

import java.util.*;
import java.util.stream.Collectors;

public class FacadeApplicationMessagerieImpl implements FacadeApplicationMessagerie {

    private static Map<Long, Utilisateur> mapInscrits =new HashMap<>();

    private static Map<Long,Message> messagesEnvoyes = new HashMap<>();



    private static Collection<Utilisateur> utilisateursConnectes = new ArrayList<>();




    @Override
    public void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException {

        if (Objects.isNull(login) || Objects.isNull(password)) {
            throw new InformationsNonConformesException();
        }

        Collection<String> logins = mapInscrits.values().stream().map(u -> u.getNom()).collect(Collectors.toList());
        if (logins.contains(login)) {
            throw new LoginDejaPrisException();
        }

        Utilisateur utilisateur = UtilisateurImpl.creer(login,password);
        mapInscrits.put(utilisateur.getId(),utilisateur);


    }


    private Utilisateur getUtilisateurByName(String nom) throws UtilisateurInexistantException {
        for (Utilisateur u : mapInscrits.values()) {
            if (u.getNom().equals(nom))
                return u;
        }

        throw new UtilisateurInexistantException();
    }


    @Override
    public void resiliser(String login, String password) throws DonneesIncoherentesException, InformationsNonConformesException {
        if (Objects.isNull(login) || Objects.isNull(password)) {
            throw new InformationsNonConformesException();
        }

        try {
            Utilisateur utilisateur = getUtilisateurByName(login);

            if (utilisateur.getPassword().equals(password)) {
                mapInscrits.remove(utilisateur.getId());
            }
            else
                throw new DonneesIncoherentesException();
        } catch (UtilisateurInexistantException e) {
            throw new DonneesIncoherentesException();
        }


    }

    @Override
    public long connexion(String login, String password) throws InformationsNonConformesException,
            UtilisateurDejaConnecteException {
        if (Objects.isNull(login) || Objects.isNull(password)) {
            throw new InformationsNonConformesException();
        }

        try {
            Utilisateur utilisateur = getUtilisateurByName(login);



            if (utilisateursConnectes.contains(utilisateur)) {
                throw new UtilisateurDejaConnecteException();
            }
            if (utilisateur.getPassword().equals(password)) {
                utilisateursConnectes.add(utilisateur);
                return utilisateur.getId();
            }
            else
                throw new InformationsNonConformesException();
        } catch (UtilisateurInexistantException e) {
            throw new InformationsNonConformesException();
        }
    }

        @Override
    public void deconnexion(long idUtilisateur) throws InformationsNonConformesException {

        Utilisateur utilisateur = mapInscrits.get(idUtilisateur);
        if (Objects.isNull(utilisateur)) {
            throw new InformationsNonConformesException();
        }

        utilisateursConnectes.remove(utilisateur);
    }




    private Utilisateur getUtilisateur(long id) throws UtilisateurInexistantException {
        Utilisateur utilisateur = mapInscrits.get(id);
        if (Objects.isNull(utilisateur)) {
            throw new UtilisateurInexistantException();
        }
        return utilisateur;
    }



    @Override
    public long envoyerUnMessage(long idEnvoyeur, long idDestinataire, String contenu) throws UtilisateurNonConnecteException, UtilisateurInexistantException {

        Utilisateur utilisateur = getUtilisateur(idEnvoyeur);
        Utilisateur destinataire = getUtilisateur(idDestinataire);
        if (!utilisateursConnectes.contains(utilisateur)) {
            throw new UtilisateurNonConnecteException();
        }

        Message message = MessageImpl.creer(utilisateur,destinataire,contenu);

        messagesEnvoyes.put(message.getId(),message);
        return message.getId();
    }

    @Override
    public Collection<MessageDTO> getMesMessages(long idUtilisateur) throws UtilisateurNonConnecteException {

        Collection<MessageDTO> messageDTOS = messagesEnvoyes.values().stream().filter(e ->
                e.getDestinataire().getId()==idUtilisateur ).map(e -> MessageDTOImpl.creer(e)).collect(Collectors.toList());

        return messageDTOS;
    }

    @Override
    public Collection<UtilisateurDTO> getListeDesInscrits(long idUtilisateur) throws UtilisateurNonConnecteException, UtilisateurInexistantException {

        Utilisateur u = this.getUtilisateur(idUtilisateur);

        if (!utilisateursConnectes.contains(u)) {
            throw new UtilisateurNonConnecteException();
        }

        return mapInscrits.values().stream().map(e-> UtilisateurDTOImpl.creer(e)).collect(Collectors.toList());
    }

    @Override
    public MessageDTO getMessageById(long idUtilisateur, long idMessage) throws UtilisateurNonConnecteException, MessageInexistantException, UtilisateurInexistantException {
        Utilisateur u = this.getUtilisateur(idUtilisateur);

        if (!utilisateursConnectes.contains(u)) {
            throw new UtilisateurNonConnecteException();
        }



        Message m = this.getMessage(idMessage);


        return MessageDTOImpl.creer(m);
    }

    private Message getMessage(long idMessage) throws MessageInexistantException {
        Message message = messagesEnvoyes.get(idMessage);
        if (Objects.isNull(message)) {
            throw new MessageInexistantException();
        }
        return message;
    }


}
