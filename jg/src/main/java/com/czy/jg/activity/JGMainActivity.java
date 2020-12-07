package com.czy.jg.activity;


import android.widget.RadioGroup;

import com.czy.commonlib.activity.BaseActivity;
import com.czy.jg.R;
import com.czy.jg.fragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

public class JGMainActivity extends BaseActivity {

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

        loadMultipleRootFragment(R.id.frag, 0,
                fragments.get(0)
        );


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.tab_1) {
                    index = 0;
                    showHideFragment(fragments.get(0));
                }
            }
        });
        rg.check(R.id.tab_1);

        showHideFragment(fragments.get(0));

    }

}
