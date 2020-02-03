package rmistuff;

import facade.FacadeApplicationMessagerie;
import facade.FacadeApplicationMessagerieImpl;
import facade.exceptions.InformationsNonConformesException;
import facade.exceptions.LoginDejaPrisException;

import java.rmi.RemoteException;

/**
 * Created by YohanBoichut on 08/10/14.
 */
public class MonServiceImpl implements MonService {

    private final static FacadeApplicationMessagerie facadeApplicationMessagerie = new FacadeApplicationMessagerieImpl();


    @Override
    public void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException, RemoteException {
        facadeApplicationMessagerie.inscription(login,password);
    }
}
