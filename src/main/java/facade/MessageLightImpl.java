package facade;

import modele.Message;

public class MessageLightImpl implements MessageLight {


    private long id;

    private UtilisateurLight envoyeur;

    private UtilisateurLight destinataire;

    private String contenu;

    public MessageLightImpl(Message message) {
        this.id = message.getId();

        this.envoyeur = UtilisateurLightImpl.creer(message.getEnvoyeur());
        this.destinataire = UtilisateurLightImpl.creer(message.getDestinataire());
        this.contenu = message.getContenu();
    }


    public static MessageLight creer(Message message) {
        return new MessageLightImpl(message);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getContenu() {
        return contenu;
    }

    @Override
    public UtilisateurLight getEnvoyeur() {
        return envoyeur;
    }

    @Override
    public UtilisateurLight getDestinataire() {
        return destinataire;
    }
}
