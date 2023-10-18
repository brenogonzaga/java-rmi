package server;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileTransfer extends Remote {
    byte[] downloadFile(String fileName) throws RemoteException;

    void uploadFile(String fileName, byte[] data) throws RemoteException;
}
