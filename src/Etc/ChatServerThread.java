package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerThread extends Thread{
    private Socket socket; // 클라이언트와 연결된 소켓
    private ChatServer server; // 채팅 서버 객체
    private PrintWriter writer; // 클라이언트에게 메시지를 보내기 위한 출력 스트림

    public ChatServerThread(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 클라이언트로부터 메시지를 읽기 위한 입력 스트림을 생성합니다.
            writer = new PrintWriter(socket.getOutputStream(), true);
            // 클라이언트에게 메시지를 보내기 위한 출력 스트림을 생성합니다.

            while (true) {
                String message = reader.readLine(); // 클라이언트로부터 메시지를 읽습니다.
                if (message == null) {
                    break;
                }
                server.broadcastMessage(this, message); // 모든 클라이언트에게 메시지를 전달합니다.
            }
        } catch (IOException e) {
            System.err.println("클라이언트와의 연결 오류: " + e.getMessage());
        } finally {
            closeConnection(); // 연결을 종료합니다.
        }
    }

    public void sendMessage(String message) {
        writer.println(message);
    }

    public void closeConnection() {
        try {
            socket.close();
            server.removeClient(this);
        } catch (IOException e) {
            System.out.println("소켓 닫기 오류: " + e.getMessage());
        }
    }
}
