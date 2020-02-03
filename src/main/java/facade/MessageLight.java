package facade;

import java.io.Serializable;

public interface MessageLight extends Serializable {

    long getId();
    String getContenu();
    UtilisateurLight getEnvoyeur();
    UtilisateurLight getDestinataire();

}
