# File Transfer usando Java RMI

Este é um simples exemplo de aplicação de transferência de arquivos usando Java RMI (Remote Method Invocation). O projeto consiste em um servidor que aceita uploads de arquivos e um cliente que pode fazer uploads e downloads de arquivos.

## Pré-requisitos

- Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina. Você pode baixá-lo em [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) ou [OpenJDK](https://openjdk.java.net/).

## Compilar e Executar

1. Abra um terminal na raiz do projeto.

2. Compile os arquivos usando o seguinte comando:

   ```bash
   javac server/FileTransfer.java server/FileTransferServer.java client/FileTransferClient.java
   ```

3. Inicie o servidor em um terminal:

   ```bash
   java server/FileTransferServer
   ```

4. Em outro terminal, inicie o cliente:

   ```bash
   java client/FileTransferClient
   ```

## Como usar

- **Upload de Arquivo (Cliente para Servidor):**

  - Defina o caminho do arquivo a ser transferido no cliente.
  - O arquivo será enviado para o servidor.

- **Download de Arquivo (Servidor para Cliente):**
  - O servidor recebe o arquivo e salva no diretório `arquivo/`.
  - Certifique-se de que o diretório de destino exista antes de iniciar o cliente.
