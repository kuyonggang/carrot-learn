package com.carrot.learn.api;

import com.carrot.learn.connection.Connection;
import com.carrot.learn.protocal.Protocol;

public class Client {
    private Connection connection;

    public Client(String ip,int port) {
        connection = new Connection(ip,port);
    }

    public void set(String key,String value){
        connection.sendCommand(Protocol.Command.SET,SafeEncode.encode(key),SafeEncode.encode(value));
    }

    public String get(String key){
        connection.sendCommand(Protocol.Command.GET,SafeEncode.encode(key));
        return connection.getStatusReply();
    }

    public String ping(String key){
        connection.sendCommand(Protocol.Command.PING,SafeEncode.encode(key));
        return connection.getStatusReply();
    }
}
