package com.example.maxithss.siacocktailapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.widget.TextView;
import java.net.Socket;

@SuppressWarnings("HardcodedText")
@SuppressLint("HardcodedText")
public class cocktailDialog3 extends DialogFragment {

    protected Connection connection = new Connection();
    protected TextView clientsID;
    protected TextView mainText;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.cocktail_dialog1,null));
        return builder.create();

    }

    private class ConnectionThread implements Runnable{
        Socket clientSocket = null;
        @Override
        public void run() {
            connection.setConnection(clientSocket, 3);
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
        clientsID.setText("ID: " + connection.getId());
    }
}