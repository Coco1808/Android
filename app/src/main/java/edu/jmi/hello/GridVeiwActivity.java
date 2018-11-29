package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

public class GridVeiwActivity extends AppCompatActivity {
    private ArrayList<Item>  itemList = new ArrayList<>();
    private GridView gvImages;
    private GridVeiwAdatper adatper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_veiw);
        initDate();
        initView();

    }

    private void initView() {
        gvImages = (GridView) findViewById(R.id.gv_images);
        adatper = new GridVeiwAdatper(itemList,this);
        gvImages.setAdapter(adatper);
    }



    private void initDate() {
        for(int i = 0;i<20;i++){
            Item item = new Item();
            item.setImgId(R.drawable.fengjing);
            item.setName("Image"+i);
            itemList.add(item);
        }
    }
}
