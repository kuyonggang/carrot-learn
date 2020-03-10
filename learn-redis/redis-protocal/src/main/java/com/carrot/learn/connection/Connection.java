package com.carrot.learn.connection;

import com.carrot.learn.protocal.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {

    private Socket socket;
    private String ip;
    private int port;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Connection(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void connect(){
        try {
            if(!isConnectd()){
                socket = new Socket(ip,port);
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isConnectd() {
        return socket != null
                && socket.isBound()
                && !socket.isClosed()
                && socket.isConnected()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown();
    }

    public Connection sendCommand(Protocol.Command command,byte[]...key){
        connect();
        Protocol.sendCommand(outputStream,command,key);
        return this;
    }

    public String getStatusReply(){
        byte[] b = new byte[1024];
        try {
            socket.getInputStream().read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}
