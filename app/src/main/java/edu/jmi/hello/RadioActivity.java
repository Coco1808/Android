package edu.jmi.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity {
    private RadioGroup rgSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rgSex = (RadioGroup) findViewById(R.id.rg_sex);
        rgSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(RadioActivity.this,rb.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void displaySex(View view){
//        for(int i = 0; i < rgSex.getChildCount();i ++){
//            RadioButton rb = (RadioButton) rgSex.getChildAt(i);
//            if(rb.isChecked()){
//                Toast.makeText()
//            }
//        }
        RadioButton rb = (RadioButton) findViewById(rgSex.getCheckedRadioButtonId());
        Toast.makeText(this,rb.getText(),Toast.LENGTH_SHORT).show();
    }
}
