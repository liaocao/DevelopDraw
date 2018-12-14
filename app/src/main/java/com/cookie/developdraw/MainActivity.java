package com.cookie.developdraw;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cookie.developdraw.A.ADrawLineActivity;
import com.cookie.developdraw.A.ADrawRegionActivity;
import com.cookie.developdraw.A.ADrawRegionClipActivity;
import com.cookie.developdraw.A.ADrawSimpleActivity;
import com.cookie.developdraw.A.ADrawTextPathActivity;
import com.cookie.developdraw.B.BBezierActivity;
import com.cookie.developdraw.B.BBezierAnimationActivity;
import com.cookie.developdraw.B.BClipRectActivity;
import com.cookie.developdraw.B.BDrawTextActivity;
import com.cookie.developdraw.B.BDrawTranslateActivity;
import com.cookie.developdraw.B.BPathSmoothActivity;
import com.cookie.developdraw.B.BPathTouchActivity;
import com.cookie.developdraw.C.CDrawLineActivity;

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
        addItem(myData, "BDrawTextActivity", new Intent(this, BDrawTextActivity.class));
        addItem(myData, "BBezierActivity", new Intent(this, BBezierActivity.class));
        addItem(myData, "BPathTouchActivity", new Intent(this, BPathTouchActivity.class));
        addItem(myData, "BPathSmoothActivity", new Intent(this, BPathSmoothActivity.class));
        addItem(myData, "BBezierAnimationActivity", new Intent(this, BBezierAnimationActivity.class));
        addItem(myData, "CDrawLineActivity", new Intent(this, CDrawLineActivity.class));
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
