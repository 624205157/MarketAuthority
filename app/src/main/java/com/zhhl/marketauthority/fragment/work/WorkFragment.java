package com.zhhl.marketauthority.fragment.work;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.zhhl.marketauthority.R;
import com.czy.commonlib.fragment.BaseFragment;
import com.czy.commonlib.listener.DealCount;

import java.util.ArrayList;
import java.util.List;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by 陈泽宇 on 2019/12/4.
 * Describe:待办事项
 */
public class WorkFragment extends BaseFragment implements View.OnClickListener {


    private TextView backlogNum;
    private TextView backlogText;
    private View backlogLine;
    private TextView finishNum;
    private TextView finishText;
    private View finishLine;

    private LinearLayout backlog;
    private LinearLayout finish;

    private List<SupportFragment> fragments;

    @Override
    protected int setContentView() {
        return R.layout.fragment_work;
    }

    @Override
    protected void lazyLoad() {

        backlogNum = findViewById(R.id.backlog_num);
        backlogText = findViewById(R.id.backlog_text);
        backlogLine = findViewById(R.id.backlog_line);
        finishNum = findViewById(R.id.finish_num);
        finishText = findViewById(R.id.finish_text);
        finishLine = findViewById(R.id.finish_line);

        backlog = findViewById(R.id.backlog);
        finish = findViewById(R.id.finish);

        backlog.setOnClickListener(this);
        finish.setOnClickListener(this);

        fragments = new ArrayList<>();
//        fragments.add(new BacklogRootFragment());
//        fragments.add(new FinishRootFragment());
        BacklogFragment backlogFragment = new BacklogFragment();
        FinishFragment finishFragment = new FinishFragment();
        fragments.add(backlogFragment);
        fragments.add(finishFragment);
        loadMultipleRootFragment(R.id.frag, 0,
                fragments.get(0),
                fragments.get(1)
        );
        backlogFragment.setDealCount(new DealCount() {
            @Override
            public void dealCount(String dealcount,String donecount) {
                System.out.println("WorkFragment：数据条数"+dealcount);
                System.out.println("WorkFragment：数据条数"+donecount);
                backlogNum.setText(dealcount);
                finishNum.setText(donecount);
            }
        });
    }



    private void resetView(){
        backlogNum.setTextColor(getResources().getColor(R.color.write_half));
        backlogText.setTextColor(getResources().getColor(R.color.write_half));
        backlogLine.setVisibility(View.INVISIBLE);

        finishNum.setTextColor(getResources().getColor(R.color.write_half));
        finishText.setTextColor(getResources().getColor(R.color.write_half));
        finishLine.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View view) {
        resetView();
        switch (view.getId()) {
            case R.id.backlog:
                backlogNum.setTextColor(getResources().getColor(R.color.write));
                backlogText.setTextColor(getResources().getColor(R.color.write));
                backlogLine.setVisibility(View.VISIBLE);
                showHideFragment(fragments.get(0));
                break;
            case R.id.finish:
                finishNum.setTextColor(getResources().getColor(R.color.write));
                finishText.setTextColor(getResources().getColor(R.color.write));
                finishLine.setVisibility(View.VISIBLE);
                showHideFragment(fragments.get(1));
                break;
        }
    }


}
