package com.sda.server;

import com.sda.thread.ClientHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        Executor pool = Executors.newCachedThreadPool();
        int port = 4444;
        //long SLEEP_TIME  = 10_000L;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Started server on port " + port);

        while (true) {

            System.out.println("Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(clientSocket);

                //Thread.sleep(SLEEP_TIME);
                pool.execute(clientHandler);
        }
    }
}
