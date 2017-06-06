package com.android.robust;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.meituan.robust.patch.annotaion.Add;
import com.meituan.robust.patch.annotaion.Modify;

public class SecondActivity extends AppCompatActivity {

    @Override
    @Modify
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView txt = (TextView) findViewById(R.id.txt);
        txt.setText(getTxt());
    }

    @Add
    private String getTxt(){
        return "Robust successs...";
    }
}
