package week12;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private List<ClientHandler> clients;

    public void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server is running on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                username = reader.readLine(); // Read username
                System.out.println(username + " has joined the chat.");
                broadcastMessage(username + " has joined the chat.", this);

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println(username + ": " + message);
                    broadcastMessage(username + ": " + message, this);
                }
            } catch (IOException e) {
                System.out.println(username + " has disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                clients.remove(this);
                broadcastMessage(username + " has left the chat.", this);
            }
        }

        public void sendMessage(String message) {
            writer.println(message);
        }
    }
}

class ChatApplication {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        int port = 12345;
        chatServer.start(port);
    }
}

class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server-ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 12345;

        try (Socket socket = new Socket(serverIp, port);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            serverWriter.println(username);

            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            readThread.start();

            String clientMessage;
            while ((clientMessage = consoleReader.readLine()) != null) {
                serverWriter.println(clientMessage);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
