package edu.jmi.hello;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jet Shang on 2018/11/22.
 */

public class GridVeiwAdatper extends BaseAdapter {
    private ArrayList<Item> itemList;
    private Context context;


    public GridVeiwAdatper(ArrayList<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override

    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertVeiw, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.gv_item,null);//布局加载器
        ImageView ivImage = (ImageView) view.findViewById(R.id.iv_image);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        Item item = itemList .get(position);
        ivImage.setImageResource(item.getImgId());
        tvName.setText(item.getName());

        return view;



    }
}
