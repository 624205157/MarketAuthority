package com.zhhl.marketauthority.adapter;

import android.text.TextUtils;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.Finish;

import java.util.List;

/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:
 */
public class FinishAdapter extends BaseQuickAdapter<Finish, BaseViewHolder> {

    public FinishAdapter(List<Finish> data) {
        super(R.layout.item_finish_work_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Finish item) {
        helper.setText(R.id.year_month, item.getYear() + "/" + item.getMonth());
        helper.setText(R.id.day,item.getDay());
        helper.setText(R.id.title, item.getTitle());
        helper.setText(R.id.entity_name, "申请单位:" + item.getCompany());
        helper.setText(R.id.opinion,"评审意见:" + item.getOpinion());
        switch (item.getState()){
            case "1":
                helper.setBackgroundRes(R.id.state,R.drawable.background_corners_3);
                break;
            case "2":
                helper.setBackgroundRes(R.id.state,R.drawable.background_corners_4);
                break;
            case "3":
                helper.setBackgroundRes(R.id.state,R.drawable.background_corners_2);
                break;
        }
    }


}
