package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOk;
    private Button btnName;
    private TextView tvName;
    private Button btnlogin;
    private Button userlogin,userclose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_name);
        //login_name
//        userlogin = (Button)findViewById(R.id.user_login1);
//        userclose = (Button)findViewById(R.id.user_login2);












        //1.
      //  btnlogin = (Button)findViewById(R.id.btn_login1);
       // btnlogin.setOnClickListener(new View.OnClickListener() {
           // @Override
//            public void onClick(View view) {
//                switch (view.getId()) {
//                    case R.id.btn_login;
//                }
//                Toast.makeText(MainActivity.this,"登陆",Toast.LENGTH_LONG).show();
//            }
//        });

//        btnOk = (Button) findViewById(R.id.btn_ok);
//        btnName = (Button) findViewById(R.id.btn_name);
//        tvName = (TextView) findViewById(R.id.tvName);
//// findViewById : 获取一个按钮或者文本输入框
//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"我被单机了",Toast.LENGTH_LONG).show();
//            }
//
//        });
//        // 创建一个按钮
//        btnName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tvName.setText("My name is ShangKe");
//            }
//        });
//    }
}

    //登陆内容，button_layout对应
//    public void login(View view) {
//
//              switch (view.getId()) {
//                  case R.id.btn_login1:
//                      Toast.makeText(this, "登陆1", Toast.LENGTH_LONG).show();
//
//                  case R.id.btn_login2:
//                      Toast.makeText(this, "登陆2", Toast.LENGTH_LONG).show();
//
//                }
//
//    }

    }
