package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;
import java.util.logging.StreamHandler;

public class YouJiActivity extends AppCompatActivity {

    private ArrayList<HashMap<String,Object>> data = new ArrayList<>();
    private int[] images= new int[]{R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5 };
    private ListView lvYouji;
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youji);
        initData();
        initView();



        //new String[]{"iv_tu"}
    }

    private void initView() {
        lvYouji = (ListView) findViewById(R.id.lv_youji);
        simpleAdapter = new SimpleAdapter(
            this,
            data,
            R.layout.youji_list_item,
                    new String[]{"iv_tu","tv_title","tv_author","tv_views","tv_pinglun"},
                new int[]{R.id.iv_tu,R.id.tv_title,R.id.tv_author,R.id.tv_views,R.id.tv_pinglun}
        );
        lvYouji.setAdapter(simpleAdapter);
        lvYouji.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,Object>  map =data.get(position);
                String title = (String) map.get("tv_title");
                Toast.makeText(YouJiActivity.this,title,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        Random r = new Random();
        for(int i = 0;i < 20; i++){
            HashMap<String,Object>map = new HashMap<>();
            map.put("iv_tu",images[i%images.length]);
            map.put("tv_title","江苏海事职业技术学院隆重召开了第二届党代会"+i);
            map.put("tv_author","Jack"+i);

            map.put("tv_views",r.nextInt(10000));
            map.put("tv_pinglun",r.nextInt(1000));
            data.add(map);
        }
    }
    //map : 键值段方法存数据

}
