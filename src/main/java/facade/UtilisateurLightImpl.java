package facade;

import modele.Utilisateur;

public class UtilisateurLightImpl implements UtilisateurLight {

    long id;

    String login;

    public UtilisateurLightImpl(Utilisateur u) {
        this.id = u.getId();

        this.login = u.getNom();
    }


    public static UtilisateurLight creer(Utilisateur u) {
        return new UtilisateurLightImpl(u);
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
