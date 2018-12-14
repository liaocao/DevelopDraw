package com.cookie.developdraw;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new SimpleAdapter(this, getData(), android.R.layout.simple_list_item_1, new String[] {"title"}, new int[] {android.R.id.text1}));
    }

    protected List<Map<String, Object>> getData(){
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();
        addItem(myData, "ADrawSimpleActivity", new Intent(this, ADrawSimpleActivity.class));
        addItem(myData, "ADrawLineActivity", new Intent(this, ADrawLineActivity.class));
        addItem(myData, "ADrawTextPathActivity", new Intent(this, ADrawTextPathActivity.class));
        addItem(myData, "ADrawRegionActivity", new Intent(this, ADrawRegionActivity.class));
        addItem(myData, "ADrawRegionClipActivity", new Intent(this, ADrawRegionClipActivity.class));
        addItem(myData, "BDrawTranslateActivity", new Intent(this, BDrawTranslateActivity.class));
        addItem(myData, "BClipRectActivity", new Intent(this, BClipRectActivity.class));
        return myData;
    }

    private void addItem(List<Map<String, Object>> data, String title, Intent intent){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", title);
        map.put("intent", intent);

        data.add(map);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        Map<String, Object> map = (Map<String, Object>) l.getItemAtPosition(position);

        Intent i = (Intent) map.get("intent");
        if(i != null)
            startActivity(i);
    }
}
