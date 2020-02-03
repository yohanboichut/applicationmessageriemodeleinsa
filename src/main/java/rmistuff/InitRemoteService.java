package rmistuff;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by YohanBoichut on 08/10/14.
 */





public class InitRemoteService {


    public static void main(String[] args) {
        try {
            MonService skeleton = (MonService)UnicastRemoteObject.exportObject(new MonServiceImpl(),10000);

            Registry registry = LocateRegistry.createRegistry(10000);
            registry.rebind(MonService.serviceName,skeleton);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
