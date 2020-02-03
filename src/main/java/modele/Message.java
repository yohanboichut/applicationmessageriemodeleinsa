package modele;

public interface Message {

    Utilisateur getEnvoyeur();
    Utilisateur getDestinataire();
    String getContenu();
    long getId();

}
