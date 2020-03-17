package chat.server.core;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ChatServer {

    public void start(int port) {
        System.out.println("Server started at port: " + port);
    }

    public void stop() {
        System.out.println("Server stopped");
    }


    public void writeMessage(String message) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("chatLog.txt", true)));
            out.println(message);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
