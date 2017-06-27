package com.sda.thread;

import java.io.*;
import java.net.Socket;

/**
 * Created by KasiaiMichus on 27.06.2017.
 */
public class ClientHandler implements Runnable {


    private final Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            //ObjectInputStream.
            // sending pictures,files

            String line = reader.readLine(); //read message from client
            System.out.println("Received: " + line);
            printWriter.println("Response from server: " + line);
            //printWriter.flush();

            printWriter.close();
            reader.close();
            //Thread
        }catch (IOException e) {
            System.err.println(e);
        }
    }


}
