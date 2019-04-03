# Android Studio UI 组件
![总布局](https://i.loli.net/2019/04/03/5ca42ae28fd40.jpg)
# ListView使用
```
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
```

```
<ListView
        android:id="@+id/list_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:divider="@color/colorGrey"
        android:dividerHeight="2dp"
        android:listSelector="@drawable/listview_item_selector"
        >
```
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" 
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp">
    <TextView
        android:id="@+id/item_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerVertical="true"
        android:textSize="18sp"

        />
    <ImageView
        android:id="@+id/item_image_view"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:layout_alignParentRight="true"/>
</RelativeLayout>
```
![ListView](https://i.loli.net/2019/04/03/5ca42ae34c1a2.jpg)



# 自定义布局AlertDialog
```
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
```
![AlertDialog](https://i.loli.net/2019/04/03/5ca42ae35c3d4.jpg)

# 使用XML定义菜单
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <group android:id="@+id/group_menu">
        <item android:id="@+id/menuItem_fontsize"
                android:title="@string/font_size">
            <menu >
                <group android:id="@+id/group_fontsize">
                    <item android:id="@+id/fontsize_small" android:title="@string/font_10"/>
                    <item android:id="@+id/fontsize_middle" android:title="@string/font_16"/>
                    <item android:id="@+id/fontsize_big" android:title="@string/font_20"/>
                </group>
            </menu>
        </item>
        <item android:id="@+id/menuItem_plain"
            android:title="@string/plain_item"/>

        <item android:id="@+id/menuItem_fontcolor"
            android:title="@string/font_color">
            <menu >
                <group android:id="@+id/group_fontcolor">
                    <item android:id="@+id/fontcolor_red" android:title="@string/red_title"/>
                    <item android:id="@+id/fontcolor_black" android:title="@string/black_title"/>
                </group>
            </menu>
        </item>
    </group>

</menu>
```

```
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
```
![](https://i.loli.net/2019/04/03/5ca42ae2e6ef3.jpg)
![颜色](https://i.loli.net/2019/04/03/5ca42ae2a78e7.jpg)
![普通菜单项](https://i.loli.net/2019/04/03/5ca42ae2d3762.jpg)

# 上下文操作模式(ActionMode)的上下文菜单
```
package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActionModeActivity extends AppCompatActivity {
    private ListView listView;
    private String[] desc = {"One","Two","Three","Four","Five"};

    private Integer count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);

        final List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0; i<desc.length; i++) {
            Map<String,Object> listItem = new HashMap<>();
            listItem.put("desc",desc[i]);
            listItems.add(listItem);
        }

        final SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.layout_menucontext_listview_item,
                new String[]{"desc"},new int[]{R.id.menuContext_tv});
        listView = findViewById(R.id.listview_actionmode);
        listView.setAdapter(simpleAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if(checked) {
                    listView.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorBlue));
                    count += 1;
                } else {
                    listView.getChildAt(position).setBackgroundColor(getResources().getColor(R.color.colorWhite));
                    count -= 1;
                }
                mode.setTitle(count + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_context,menu);LayoutInflater.from(ActionModeActivity.this).inflate(R.layout.layout_list_multi_select_actionbar,null);


                mode.setTitle(count + " selected");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                count = 0;
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_delete:
                        simpleAdapter.notifyDataSetChanged();
                        mode.invalidate();
                        mode.finish();
                        break;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                simpleAdapter.notifyDataSetChanged();
            }
        });
    }
}

```
![](https://i.loli.net/2019/04/03/5ca42ae34becc.jpg)







