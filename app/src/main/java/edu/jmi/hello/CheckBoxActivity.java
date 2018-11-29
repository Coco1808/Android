package edu.jmi.hello;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.LinearLayout;
        import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox cbBasketball;//定义成员变量
    private CheckBox cbFootball;
    private CheckBox cbMusic;
    private CheckBox cbMoive;
    private LinearLayout lllikes;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //加载布局文件
        setContentView(R.layout.check_layout);
        lllikes = (LinearLayout) findViewById(R.id.ll_likes);
        cbBasketball = (CheckBox) findViewById(R.id.cd_basketball);
        cbFootball = (CheckBox) findViewById(R.id.cd_football);
        cbMusic = (CheckBox) findViewById(R.id.cd_music);
        cbMoive = (CheckBox) findViewById(R.id.cd_moive);


        //注册监听器
        cbBasketball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
                if(isCheck)
                    Toast.makeText(CheckBoxActivity.this,"你有打篮球的兴趣",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBoxActivity.this,"你没有打篮球的兴趣",Toast.LENGTH_SHORT).show();

            }
        });
        cbFootball.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
                if(isCheck)
                    Toast.makeText(CheckBoxActivity.this,"你有踢足球的兴趣",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBoxActivity.this,"你没有踢足球的兴趣",Toast.LENGTH_SHORT).show();

            }
        });
        cbMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
                if(isCheck)
                    Toast.makeText(CheckBoxActivity.this,"你有听音乐的兴趣",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBoxActivity.this,"你没有听音乐的兴趣",Toast.LENGTH_SHORT).show();
            }
        });
        cbMoive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isCheck) {
                if(isCheck)
                    Toast.makeText(CheckBoxActivity.this,"你有看电影的兴趣",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBoxActivity.this,"你没有看电影的兴趣",Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 全选功能
    public void selectAll(View view){
        //获得子主键的个数
        for(int i = 0; i<lllikes.getChildCount(); i++){
            CheckBox cb = (CheckBox) lllikes.getChildAt(i);
            cb.setChecked(true);
        }
    }
    //全不选
    public void selectAllNot(View view) {
        for (int i = 0; i < lllikes.getChildCount(); i++) {
            CheckBox cb = (CheckBox) lllikes.getChildAt(i);
            cb.setChecked(false);
        }
    }
    //反选
    public void reverseSelect(View view) {
        for (int i = 0; i < lllikes.getChildCount(); i++) {
            CheckBox cb = (CheckBox) lllikes.getChildAt(i);
            cb.toggle();

        }
    }
    public void displayLikes(View view) {
        int connt = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < lllikes.getChildCount(); i++) {
            CheckBox cb = (CheckBox) lllikes.getChildAt(i);
            if (cb.isChecked()) {
                connt++;
                sb.append(cb.getText() + ",");
            }
            if (connt > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (connt > 0) {
                Toast.makeText(this, "你有" + connt + "个兴趣" + sb.toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "你没有任何兴趣" + sb.toString(), Toast.LENGTH_SHORT).show();

            }
        }
    }
}
