package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_listview;
    private Button btn_alertlog;
    private Button btn_menu;
    private Button btn_actionmode;

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_listview = findViewById(R.id.btn_list_view);
        btn_listview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        btn_alertlog = findViewById(R.id.btn_alert_log);
        btn_alertlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AlertLogActivity.class);
                startActivity(intent);
            }
        });

        btn_menu = findViewById(R.id.btn_xml_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuTestActivity.class);
                startActivity(intent);
            }
        });

        btn_actionmode = findViewById(R.id.btn_action_mode);
        btn_actionmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ActionModeActivity.class);
                startActivity(intent);
            }
        });
    }
}
