package com.example.maxithss.siacocktailapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

@SuppressWarnings("HardcodedText")
@SuppressLint("HardcodedText")
public class cocktailDialog4 extends DialogFragment {

    private static boolean isConnected = false;
    private static final String SERVER_IP = "192.168.8.112"; //change ip if necessary
    private static final int SERVER_PORT = 49566;
    String ID;
    private TextView clientsID;
    private TextView mainText;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.cocktail_dialog1,null));
        return builder.create();

    }

    private class ConnectionThread implements Runnable {
        Socket clientSocket = null;
        @Override
        public void run() {
            try {
                clientSocket = new Socket(SERVER_IP,SERVER_PORT);
                //Sending message to server
                PrintWriter printWriter = new PrintWriter
                        (new BufferedWriter
                                (new OutputStreamWriter
                                        (clientSocket.getOutputStream())),true);
                printWriter.println("4");
                //Getting message from server
                InputStream inputStream = clientSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                ID = bufferedReader.readLine();
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    clientSocket.close();
                }catch (Exception e) {
                    e.getMessage();
                }
            }
        }
    }
    @Override
    public void onStart() {
        super.onStart();

        new Thread(new ConnectionThread()).start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mainText = getDialog().findViewById(R.id.mainText);
        mainText.setText("Cocktail wird zubereitet");

        clientsID = getDialog().findViewById(R.id.clientsID);
        clientsID.setText("ID: "+ ID);
    }
}