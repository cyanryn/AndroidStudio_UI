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
//    private View multiSelectActionBarView;
//    private TextView tv_selectedCount;
//    private TextView tv_selectedTitle;
    private Integer count = 0;
//    private LinearLayout linearLayout;
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
//                tv_selectedCount.setText(count + "");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_context,menu);
//                simpleAdapter.notifyDataSetChanged();
//                if(multiSelectActionBarView == null) {
//                    multiSelectActionBarView = LayoutInflater.from(ActionModeActivity.this).inflate(R.layout.layout_list_multi_select_actionbar,null);
//                    tv_selectedCount = multiSelectActionBarView.findViewById(R.id.selected_count);
//                }
//                mode.setCustomView(multiSelectActionBarView);
//
//                tv_selectedTitle = multiSelectActionBarView.findViewById(R.id.selected_title);
//                tv_selectedTitle.setText(R.string.selected);

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
