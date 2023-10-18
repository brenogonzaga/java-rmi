package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTransferServer extends UnicastRemoteObject implements FileTransfer {

    protected FileTransferServer() throws RemoteException {
        super();
    }

    @Override
    public byte[] downloadFile(String fileName) throws RemoteException {
        try {
            Path path = Paths.get("arquivo/" + fileName);
            return Files.readAllBytes(path);
        } catch (Exception e) {
            throw new RemoteException("Erro ao baixar o arquivo: " + e.getMessage());
        }
    }

    @Override
    public void uploadFile(String fileName, byte[] data) throws RemoteException {
        try {
            Path path = Paths.get("arquivo/" + fileName);
            Files.write(path, data);
            System.out.println("Arquivo recebido: " + fileName);
        } catch (Exception e) {
            throw new RemoteException("Erro ao fazer upload do arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            FileTransferServer server = new FileTransferServer();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("FileTransferServer", server);
            System.out.println("Servidor pronto para receber arquivos.");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
