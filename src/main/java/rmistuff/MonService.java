package rmistuff;

import facade.exceptions.InformationsNonConformesException;
import facade.exceptions.LoginDejaPrisException;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by YohanBoichut on 08/10/14.
 */
public interface MonService extends Remote{


    public final String serviceName = "ApplicationMessagerieService";


    void inscription(String login, String password) throws LoginDejaPrisException, InformationsNonConformesException, RemoteException;


}
