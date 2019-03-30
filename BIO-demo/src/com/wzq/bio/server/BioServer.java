package com.wzq.bio.server;

import com.wzq.bio.server.handler.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket server = null;

        try {

            server = new ServerSocket(PORT);
            System.err.println("the time server is start in port : " + PORT);

            Socket socket = null;
            while(true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (server != null) {
                System.err.println("the time server close...");
                server.close();
            }
        }

    }

}
