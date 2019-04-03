package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuTestActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
        setTitle("Menu Test");
        textView = findViewById(R.id.test_textview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.fontsize_small:
                textView.setTextSize(10);
                break;
            case R.id.fontsize_middle:
                textView.setTextSize(16);
                break;
            case R.id.fontsize_big:
                textView.setTextSize(20);
                break;
            case R.id.menuItem_plain:
                Toast.makeText(MenuTestActivity.this,"这是普通菜单项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fontcolor_red:
                textView.setTextColor(getResources().getColor(R.color.colorRed));
                break;
            case R.id.fontcolor_black:
                textView.setTextColor(getResources().getColor(R.color.colorBlack));
                break;
        }
            return super.onOptionsItemSelected(item);
    }
}
