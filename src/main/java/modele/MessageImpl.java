package modele;

public class MessageImpl implements Message {
    private Utilisateur envoyeur;

    private Utilisateur destinataire;

    private String contenu;
    private long id;

    private static long ID = 0;


    public static Message creer(Utilisateur envoyeur, Utilisateur destinataire, String contenu) {
        return new MessageImpl(envoyeur,destinataire,contenu);
    }

    private MessageImpl(Utilisateur envoyeur, Utilisateur destinataire, String contenu) {
        this.envoyeur = envoyeur;
        this.destinataire = destinataire;
        this.contenu = contenu;
        this.id = ID++;
    }

    @Override
    public Utilisateur getEnvoyeur() {
        return envoyeur;
    }

    @Override
    public Utilisateur getDestinataire() {
        return destinataire;
    }

    @Override
    public String getContenu() {
        return contenu;
    }

    @Override
    public long getId() {
        return id;
    }
}
