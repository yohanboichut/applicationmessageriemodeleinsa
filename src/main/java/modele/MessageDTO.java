package modele;

public interface MessageDTO {

    long getId();
    String getContenu();
    UtilisateurDTO getEnvoyeur();
    UtilisateurDTO getDestinataire();

}
