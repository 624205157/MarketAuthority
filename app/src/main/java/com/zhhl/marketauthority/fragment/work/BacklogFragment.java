package com.zhhl.marketauthority.fragment.work;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BacklogActivity;
import com.zhhl.marketauthority.adapter.BacklogAdapter;
import com.zhhl.marketauthority.bean.Backlog;
import com.zhhl.marketauthority.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:待办事项
 */
public class BacklogFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private BacklogAdapter mAdapter;
    private List<Backlog> mData = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.fragment_backlog;
    }

    @Override
    protected void lazyLoad() {

        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new BacklogAdapter(mData);
        mAdapter.openLoadAnimation();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mActivity, BacklogActivity.class);
                startActivity(intent);
            }
        });

        getData();
    }

    private void getData(){
        Backlog backlog1 = new Backlog();
        backlog1.setYear("2019");
        backlog1.setMonth("09");
        backlog1.setDay("01");
        backlog1.setCompany("长春市宏日新能源有限责任公司");
        backlog1.setTitle("特种设备（不含电梯）制作单位许可");
        backlog1.setState("1");
        mData.add(backlog1);

        Backlog backlog2 = new Backlog();
        backlog2.setYear("2019");
        backlog2.setMonth("09");
        backlog2.setDay("02");
        backlog2.setCompany("长春市宏日新能源有限责任公司");
        backlog2.setTitle("特种设备（不含电梯）制作单位许可");
        backlog2.setState("0");
        mData.add(backlog2);

        Backlog backlog3 = new Backlog();
        backlog3.setYear("2019");
        backlog3.setMonth("09");
        backlog3.setDay("03");
        backlog3.setCompany("长春市宏日新能源有限责任公司");
        backlog3.setTitle("特种设备（不含电梯）制作单位许可");
        backlog3.setState("1");
        mData.add(backlog3);

        Backlog backlog4 = new Backlog();
        backlog4.setYear("2019");
        backlog4.setMonth("09");
        backlog4.setDay("05");
        backlog4.setCompany("长春市宏日新能源有限责任公司");
        backlog4.setTitle("特种设备（不含电梯）制作单位许可");
        backlog4.setState("0");
        mData.add(backlog4);

        Backlog backlog5 = new Backlog();
        backlog5.setYear("2019");
        backlog5.setMonth("09");
        backlog5.setDay("09");
        backlog5.setCompany("长春市宏日新能源有限责任公司");
        backlog5.setTitle("特种设备（不含电梯）制作单位许可");
        backlog5.setState("0");
        mData.add(backlog5);

        mAdapter.notifyDataSetChanged();

    }
}
