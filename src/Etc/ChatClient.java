package Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("서버에 연결되었습니다: " + serverAddress + ":" + serverPort);
            // 서버와 통신하는 부분
        } catch (IOException e) {
            System.err.println("서버에 연결할 수 없습니다: " + e.getMessage());
        }

        try(Socket socket = new Socket(serverAddress, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("채팅 서버에 연결되었습니다.");

            new Thread(() -> {
                try {
                    String receivedMessage;
                    while((receivedMessage = in.readLine()) != null) {
                        System.out.println(receivedMessage);
                    }
                } catch (IOException e) {
                    System.err.println("서버에서 메시지를 읽는 도중 오류가 발생했습니다.");
                }
            }).start();

            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(message);
            }
        }
    }
}