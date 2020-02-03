package modele;

public class UtilisateurImpl implements Utilisateur {

    private long id;
    private String nom;
    private String password;
    private static int ID =0 ;

    private UtilisateurImpl(String nom, String password) {
        this.nom = nom;
        this.password = password;
        this.id = UtilisateurImpl.ID++;

    }


    public static Utilisateur creer(String login, String password) {
        return new UtilisateurImpl(login,password);
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public long getId() {
        return id;
    }
}
