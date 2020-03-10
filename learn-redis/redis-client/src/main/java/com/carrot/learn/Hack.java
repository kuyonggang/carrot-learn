package com.carrot.learn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hack {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6379);
        Socket socket = serverSocket.accept();
        byte[] b = new byte[1024];
        socket.getInputStream().read(b);
        System.out.println(new String(b));

    }
}
