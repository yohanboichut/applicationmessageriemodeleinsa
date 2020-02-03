package modele;

public class MessageDTOImpl implements MessageDTO {


    private long id;

    private UtilisateurDTO envoyeur;

    private UtilisateurDTO destinataire;

    private String contenu;

    public MessageDTOImpl(Message message) {
        this.id = message.getId();

        this.envoyeur = UtilisateurDTOImpl.creer(message.getEnvoyeur());
        this.destinataire = UtilisateurDTOImpl.creer(message.getDestinataire());
        this.contenu = message.getContenu();
    }


    public static MessageDTO creer(Message message) {
        return new MessageDTOImpl(message);
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
    public UtilisateurDTO getEnvoyeur() {
        return envoyeur;
    }

    @Override
    public UtilisateurDTO getDestinataire() {
        return destinataire;
    }
}
