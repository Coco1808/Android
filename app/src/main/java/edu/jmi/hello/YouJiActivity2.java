package edu.jmi.hello;

        import android.media.Image;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AbsListView;
        import android.widget.AdapterView;
        import android.widget.BaseAdapter;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Random;

        import static edu.jmi.hello.R.id.cb_ok;
        import static edu.jmi.hello.R.id.tv_author;
        import static edu.jmi.hello.R.id.tv_pinglun;
        import static edu.jmi.hello.R.id.tv_title;
        import static edu.jmi.hello.R.id.tv_views;

        public class YouJiActivity2 extends AppCompatActivity implements AbsListView.OnScrollListener {

            private ArrayList<HashMap<String, Object>> data = new ArrayList<>();
            private int[] images = new int[]{R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4, R.drawable.item5, R.drawable.item6, R.drawable.item7};
            private ListView lvYouji;
            private YouJiAdapter adapter;
            private int total = 0;
            private int lastVisibleItem;//当前屏幕最后一个列表项的索引；
            private TextView tvToatal;
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
                View footerView = getLayoutInflater().inflate(R.layout.page_load_layout,null);
                lvYouji.addFooterView(footerView);
                adapter = new YouJiAdapter();
                lvYouji.setAdapter(adapter);
                lvYouji.setOnScrollListener(this);
                tvToatal = (TextView) findViewById(R.id.tv_total);
                lvYouji.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        HashMap<String, Object> map = data.get(position);
                        String title = (String) map.get("tv_title");
                        Toast.makeText(YouJiActivity2.this, title, Toast.LENGTH_SHORT).show();
                    }
                });
            }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("iv_tu", images[i % images.length]);
            map.put("tv_title", "江苏海事学院隆重召开了第二届党代会" + i);
            map.put("tv_author", "Jack" + i);

            map.put("tv_views", r.nextInt(10000));
            map.put("tv_pinglun", r.nextInt(1000));
            data.add(map);
        }
    }

    @Override
    //两个方法配合执行
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastVisibleItem  == adapter.getCount()){
            initData();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            adapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int VisibleItemCount, int totalItemCount) {
        lastVisibleItem = firstVisibleItem + VisibleItemCount - 1;

    }

    //map : 键值段方法存数据
    class YouJiAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
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
        //创建每个条目是调用该方法
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;
            ViewHodler holder;
            if (convertView == null){
                view = getLayoutInflater().inflate(R.layout.youji_list_item,null);
                holder = new ViewHodler();
                holder.iv_tu = (ImageView) view.findViewById(R.id.iv_tu);
                holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
                holder.tv_author = (TextView) view.findViewById(R.id.tv_author);
                holder.tv_views = (TextView) view.findViewById(R.id.tv_views);
                holder.tv_pinglun = (TextView) view.findViewById(R.id.tv_pinglun);
                holder.cb_ok = (CheckBox) view.findViewById(R.id.cb_ok);
                view.setTag(holder);//把绑定对象放置到列表项组件对象中

            }else {
                holder = (ViewHodler) convertView.getTag();
                view = convertView;
            }

            //1.加载列表项布局文件，返回该布局文件的视图
          //  View view = getLayoutInflater().inflate(R.layout.youji_list_item, null);
            //2.获取需要放置数据的子组件

//            ImageView iv_tu = (ImageView) view.findViewById(R.id.iv_tu);
//            TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
//            TextView tv_author = (TextView) view.findViewById(R.id.tv_author);
//            TextView tv_views = (TextView) view.findViewById(R.id.tv_views);
//            TextView tv_pinglun = (TextView) view.findViewById(R.id.tv_pinglun);
//            CheckBox cb_ok = (CheckBox) view.findViewById(R.id.cb_ok);
//            view.setTag(holder);
            //3.根据position获取对应数据
            HashMap<String, Object> map = data.get(position);
            //4.把数据放置到子组件上
            holder.iv_tu.setImageResource((Integer) map.get("iv_tu"));
            holder.tv_title.setText(map.get("tv_title").toString());
            holder.tv_author.setText(map.get("tv_author").toString());
            holder.tv_views.setText(map.get("tv_views").toString());
            holder.tv_pinglun.setText(String.valueOf(map.get("tv_pinglun")));
          holder.cb_ok.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                  if (isChecked){
                      total++;
                  }else
                      total--;
                  tvToatal.setText(String.valueOf(total));
              }
          });

            return view;
        }
    }
    //定义用于绑定列表项子主键的类
    class  ViewHodler{
        ImageView iv_tu;
        TextView tv_title;
        TextView tv_author;
        TextView tv_views;
        TextView tv_pinglun;
        CheckBox cb_ok;
    }
}
