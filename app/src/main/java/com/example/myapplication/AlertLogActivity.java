package com.example.myapplication;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class AlertLogActivity extends AppCompatActivity {
    private Button btn_customer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_log);


        LayoutInflater inflater = LayoutInflater.from(AlertLogActivity.this);
        View view_dialog = inflater.inflate(R.layout.layout_dialog,null);
        View view_title = inflater.inflate(R.layout.layout_dialog_view_title,null);
        AlertDialog.Builder  builder = new AlertDialog.Builder(this);
        builder.setCustomTitle(view_title)
                .setView(view_dialog)
                .setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton(R.string.sign_in, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();


    }
}
