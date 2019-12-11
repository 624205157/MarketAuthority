package com.zhhl.marketauthority.fragment.work;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.adapter.FinishAdapter;
import com.zhhl.marketauthority.bean.Finish;
import com.zhhl.marketauthority.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:已办事项
 */
public class FinishFragment extends BaseFragment {

    private RecyclerView recyclerView;

    private FinishAdapter mAdapter;
    private List<Finish> mData = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.fragment_finish_work;
    }

    @Override
    protected void lazyLoad() {

        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new FinishAdapter(mData);
        mAdapter.openLoadAnimation();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);

        getData();

    }

    private void getData(){
        Finish backlog1 = new Finish();
        backlog1.setYear("2019");
        backlog1.setMonth("09");
        backlog1.setDay("01");
        backlog1.setCompany("长春市宏日新能源有限责任公司");
        backlog1.setTitle("特种设备（不含电梯）制作单位许可");
        backlog1.setOpinion("评审意见：整体良好，部分有待加强");
        backlog1.setState("1");
        mData.add(backlog1);

        Finish backlog2 = new Finish();
        backlog2.setYear("2019");
        backlog2.setMonth("09");
        backlog2.setDay("02");
        backlog2.setCompany("长春市宏日新能源有限责任公司");
        backlog2.setTitle("特种设备（不含电梯）制作单位许可");
        backlog2.setOpinion("评审意见：整体良好，部分有待加强");
        backlog2.setState("3");
        mData.add(backlog2);

        Finish backlog3 = new Finish();
        backlog3.setYear("2019");
        backlog3.setMonth("09");
        backlog3.setDay("03");
        backlog3.setCompany("长春市宏日新能源有限责任公司");
        backlog3.setTitle("特种设备（不含电梯）制作单位许可");
        backlog3.setOpinion("评审意见：整体良好，部分有待加强");
        backlog3.setState("1");
        mData.add(backlog3);

        Finish backlog4 = new Finish();
        backlog4.setYear("2019");
        backlog4.setMonth("09");
        backlog4.setDay("05");
        backlog4.setCompany("长春市宏日新能源有限责任公司");
        backlog4.setTitle("特种设备（不含电梯）制作单位许可");
        backlog4.setOpinion("评审意见：整体良好，部分有待加强");
        backlog4.setState("2");
        mData.add(backlog4);

        Finish backlog5 = new Finish();
        backlog5.setYear("2019");
        backlog5.setMonth("09");
        backlog5.setDay("09");
        backlog5.setCompany("长春市宏日新能源有限责任公司");
        backlog5.setTitle("特种设备（不含电梯）制作单位许可");
        backlog5.setOpinion("评审意见：整体良好，部分有待加强");
        backlog5.setState("3");
        mData.add(backlog5);

        mAdapter.notifyDataSetChanged();

    }
}
