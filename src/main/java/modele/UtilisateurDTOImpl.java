package modele;

public class UtilisateurDTOImpl implements UtilisateurDTO {

    long id;

    String login;

    public UtilisateurDTOImpl(Utilisateur u) {
        this.id = u.getId();

        this.login = u.getNom();
    }


    public static UtilisateurDTO creer(Utilisateur u) {
        return new UtilisateurDTOImpl(u);
    }



    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getLogin() {
        return login;
    }
}
