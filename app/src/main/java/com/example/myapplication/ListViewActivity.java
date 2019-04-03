package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity extends AppCompatActivity {
    private String[] name = {"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imageId = {R.drawable.lion,R.drawable.tiger,R.drawable.monkey,
            R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<name.length;i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("name",name[i]);
            listItem.put("image",imageId[i]);
            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.layout_listview_item,
                new String[]{"name","image"},new int[]{R.id.item_text_view,R.id.item_image_view});
        listView = findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,""+listItems.get(position).get("name") ,Toast.LENGTH_SHORT).show();
            }
        }
    );

    }
}
