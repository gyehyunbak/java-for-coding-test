package Etc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private int port; // 서버 포트 번호
    private List<ChatServerThread> clients; // 연결된 클라이언트 목록

    public ChatServer(int Port) {
        this.port = port;
        this.clients = new ArrayList<>();
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // 서버 소켓을 생성하고 포트에 바인딩합니다.
            System.out.println("채팅 서버가 시작되었습니다");

            while (true) {
                // 클라이언트의 연결을 계속 수락합니다.
                Socket clientSocket = serverSocket.accept();
                ChatServerThread clientThread = new ChatServerThread(clientSocket, this);
                clients.add(clientThread); // 새 클라이언트를 목록에 추가합니다.
                clientThread.start(); // 클라이언트 스레드를 시작합니다.
            }
        } catch (IOException e) {
            System.out.println("서버 오류: " + e.getMessage());
        }
    }

    public void broadcastMessage(ChatServerThread sender, String message) {
        for (ChatServerThread client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    public void removeClient(ChatServerThread client) {
        clients.remove(client);
    }

    public static void main(String[] args) {
        int port = 8080;
        ChatServer server = new ChatServer(port);
        server.startServer();
    }

}
