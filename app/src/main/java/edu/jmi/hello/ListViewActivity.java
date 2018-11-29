package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    private ArrayList<String> listBooks = new ArrayList<>();
    private ListView lvBooks;
    private ArrayAdapter<String> adapter;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initData(); //初始化数据
        initView();
    }
    public void initData(){
        for(int i=0;i<20;i++){
            count++;
            listBooks.add("Java程序设计"+(i+1));
        }
    }
    public void initView(){
        lvBooks = (ListView) findViewById(R.id.lv_books);
        adapter = new ArrayAdapter<String>(
                this, //上下文
                R.layout.lv_books_item,
                R.id.tv_book,

//                android.R.layout.simple_list_item_1, //列表项布局资源
//                android.R.id.text1, //存放数据的组件id
                listBooks
        );
        lvBooks.setAdapter(adapter);
    }
    //在数据模型中增加数据，通知试图显示最新数据。
    public void addItme(View view){
        count++;
        listBooks.add("Java程序设计"+count);
        adapter.notifyDataSetChanged();//通知adapter对应的视图。我的数据变化了要求试图显示最新数据。
    }
    public void delItme(View view){
        count--;
        listBooks.remove(count);
        adapter.notifyDataSetChanged();


    }

}
