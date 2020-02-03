package modele;

public class MessageDTOImpl implements MessageDTO {


    private long id;

    private UtilisateurDTO envoyeur;

    private UtilisateurDTO destinataire;

    private String contenu;

    public MessageDTOImpl(Message message) {
        this.id = message.getId();

        this.envoyeur = UtilisateurDTOImpl.creer(message.getEnvoyeur());
    }


    public static MessageDTO creer(Message message) {
        return new MessageDTOImpl(message);
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getContenu() {
        return contenu;
    }

    @Override
    public UtilisateurDTO getEnvoyeur() {
        return envoyeur;
    }

    @Override
    public UtilisateurDTO getDestinataire() {
        return destinataire;
    }
}
