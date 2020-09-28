package com.example.maxithss.siacocktailapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {

    protected String SERVER = "localhost";
    protected int PORT = 5555;
    protected String id;


    public String getId() {
        return id;
    }

    protected String setConnection(Socket socket, int cocktailNumber) {
        id = null;
        try {
            //sending to the server
            socket = new Socket(SERVER, PORT);

            PrintWriter printWriter = new PrintWriter(
                    new BufferedWriter(
                            new OutputStreamWriter(socket.getOutputStream())),true);
            printWriter.println(cocktailNumber);
            //getting from the server


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id = bufferedReader.readLine();
            Log.i("TAG_ID", id);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            }catch (Exception e) {
                e.getMessage();
            }
        }
        return id;
    }
}
