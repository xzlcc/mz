package com.mz.xzlcc;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mz.xmz.utils.TextUtil;

public class MinaActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);



        String str = "ss";
        if(TextUtil.isEmpty(str)){
            str="1";
        }else{
            str="2";
        }


    }
}
