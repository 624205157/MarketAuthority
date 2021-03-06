package com.zhhl.marketauthority.activity;


import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.Fragment1;
import com.zhhl.marketauthority.fragment.Fragment2;
import com.zhhl.marketauthority.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class MainActivity extends BaseActivity {

    private RadioGroup rg;
    private List<SupportFragment> fragments;
    private int index = 0;
//    private ShareHelper shareHelper;


    @Override
    protected int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate() {


        rg = findViewById(R.id.rg);

        initData();
    }

    private void initData() {
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());

        loadMultipleRootFragment(R.id.frag, 0,
                fragments.get(0),
                fragments.get(1),
                fragments.get(2)
        );


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.tab_1:
                        index = 0;
                        showHideFragment(fragments.get(0));
                        break;
                    case R.id.tab_2:
                        index = 1;
                        showHideFragment(fragments.get(1));
                        break;
                    case R.id.tab_3:
                        index = 2;
                        showHideFragment(fragments.get(2));
                        break;
                }
            }
        });
        rg.check(R.id.tab_1);

        showHideFragment(fragments.get(0));

    }

}
