package com.example.maxithss.siacocktailapp;


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

public class cocktailDialog1 extends DialogFragment {

    String ID;
    private TextView clientsID;
    private TextView mainText;

    private Connection connection = new Connection();


    //cocktail_click == new DialogWindow
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.cocktail_dialog1,null));
        return builder.create();
    }

    private class ConnectionThread implements Runnable {
        Socket socket = null;
        @Override
        public void run() {
            connection.setConnection(socket, 1);
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

        if (connection.getId() != null) {
            mainText = getDialog().findViewById(R.id.mainText);
            clientsID = getDialog().findViewById(R.id.clientsID);
            mainText.setText("Cocktail wird zubereitet");
            clientsID.setText("ID: " + connection.getId());
        } else {
            mainText = getDialog().findViewById(R.id.mainText);
            clientsID = getDialog().findViewById(R.id.clientsID);
            mainText.setText("Fehler");
            clientsID.setText("");
        }
    }
}