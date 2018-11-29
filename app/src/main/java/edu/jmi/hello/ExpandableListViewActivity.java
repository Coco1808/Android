package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpandableListViewActivity extends AppCompatActivity {
    private ArrayList<HashMap<String,String>> groupData = new ArrayList<>();
    private ArrayList<ArrayList<HashMap<String,String>>> childData = new ArrayList<>();
    private ExpandableListView elvProvince;
   // private SimpleExpandableListAdapter adapter;
    private MyAdaper myAdaper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        initDate();
        initView();

    }

    private void initView() {
        elvProvince = (ExpandableListView) findViewById(R.id.elv_province);

//        adapter = new SimpleExpandableListAdapter(this,
//                groupData,android.R.layout.simple_expandable_list_item_1,
//                new String[]{"province"},new int[]{android.R.id.text1},
//                childData,android.R.layout.simple_list_item_1,
//                new String[]{"city"},new int[]{android.R.id.text1}
//        );
        myAdaper = new MyAdaper();
        //elvProvince.setAdapter(adapter);
        elvProvince.setAdapter(myAdaper);

    }

    private void initDate() {
        HashMap<String,String> group1=new HashMap<>();
        group1.put("province","江苏");
        groupData.add(group1);

        HashMap<String,String> group2 = new HashMap<>();
        group2.put("province","浙江");
        groupData.add(group2);

        HashMap<String,String> group3 = new HashMap<>();
        group3.put("province","河北");
        groupData.add(group3);


        ArrayList<HashMap<String,String>> child1 = new ArrayList<>();
        HashMap<String,String> child11 = new HashMap<>();
        child11.put("city","南京");
        child1.add(child11);
        HashMap<String,String> child12 = new HashMap<>();
        child12.put("city","苏州");
        child1.add(child12);
        HashMap<String,String> child13 = new HashMap<>();
        child13.put("city","无锡");
        child1.add(child13);
        HashMap<String,String> child14 = new HashMap<>();
        child14.put("city","常州");
        child1.add(child14);
        childData.add(child1);




        ArrayList<HashMap<String,String>> child2 = new ArrayList<>();
        HashMap<String,String> child21=new HashMap<>();
        child21.put("city","杭州");
        child2.add(child21);
        HashMap<String,String> child22=new HashMap<>();
        child22.put("city","宁波");
        child2.add(child22);
        HashMap<String,String> child23=new HashMap<>();
        child23.put("city","温州");
        child2.add(child23);
        HashMap<String,String> child24=new HashMap<>();
        child24.put("city","金华");
        child2.add(child24);
        childData.add(child2);


        ArrayList<HashMap<String,String>> child3 = new ArrayList<>();
        HashMap<String,String> child31=new HashMap<>();
        child31.put("city","沧州");
        child3.add(child31);
        HashMap<String,String> child32=new HashMap<>();
        child32.put("city","石家庄");
        child3.add(child32);
        HashMap<String,String> child33=new HashMap<>();
        child33.put("city","衡水");
        child3.add(child33);
        HashMap<String,String> child34=new HashMap<>();
        child34.put("city","保定");
        child3.add(child34);
        childData.add(child3);


    }



    class MyAdaper extends BaseExpandableListAdapter{

        @Override
        public int getGroupCount() {
            return groupData.size();

        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childData.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return null;
        }

        @Override
        public Object getChild(int groupPosition, int i1) {
            return null;
        }

        @Override
        public long getGroupId(int i) {
            return 0;
        }

        @Override
        public long getChildId(int i, int i1) {
            return 0;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPoistion, boolean isExpanded, View convertView, ViewGroup parentGroup) {
            View view = getLayoutInflater().inflate(R.layout.group_item,null);
            ImageView ivGroupindicator = (ImageView) view.findViewById(R.id.iv_groupindicator);
            TextView tvProvince = (TextView) view.findViewById(R.id.tv_province);
            if (isExpanded){
                ivGroupindicator.setImageResource(R.drawable.arrow_red_up);
            }else {
                ivGroupindicator.setImageResource(R.drawable.arrow_green_down);
            }
            HashMap<String,String> map = groupData.get(groupPoistion);
            tvProvince.setText(map.get("province"));

            return view;
        }

        @Override
        public View getChildView(int groupPoistion, int childPoistion, boolean isLastChild, View convertView, ViewGroup parentGroup) {
            View view = getLayoutInflater().inflate(R.layout.child_item,null);
            TextView tvCity = (TextView) view.findViewById(R.id.tv_city);
            HashMap<String,String> map = childData.get(groupPoistion).get(childPoistion);
            tvCity.setText(map.get("city"));
            return view;
        }


        @Override
        public boolean isChildSelectable(int groupPoistion, int childPoistion) {
            return false;
        }

    }


    }

