package com.carrot.learn;

import com.carrot.learn.api.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = new Client("182.92.171.123",6379);
        client.set("name","kuyonggang");
        String name = client.get("name");
        System.out.println(name);
        System.out.println(client.ping("ping"));
    }
}
