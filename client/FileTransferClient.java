package client;

import java.rmi.Naming;

import server.FileTransfer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTransferClient {

    public static void main(String[] args) {
        try {
            FileTransfer server = (FileTransfer) Naming.lookup("rmi://localhost/FileTransferServer");

            String fileName = "testando.txt";

            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);
            server.uploadFile(fileName, data);

            byte[] downloadedData = server.downloadFile(fileName);
            Path downloadedPath = Paths.get("server/testando.txt");
            Files.write(downloadedPath, downloadedData);

            System.out.println("Arquivo baixado com sucesso: " + downloadedPath);
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}