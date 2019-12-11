package com.zhhl.marketauthority.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.Backlog;

import java.util.List;

/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:
 */
public class BacklogAdapter extends BaseQuickAdapter<Backlog, BaseViewHolder> {

    public BacklogAdapter(List<Backlog> data) {
        super(R.layout.item_backlog_work_list, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Backlog item) {
        helper.setText(R.id.year_month, item.getYear() + "/" + item.getMonth());
        helper.setText(R.id.day, item.getDay());
        helper.setText(R.id.title, item.getTitle());
        helper.setText(R.id.entity_name, "申请单位:" + item.getCompany());
        if (TextUtils.equals(item.getState(), "1")) {
            helper.setVisible(R.id.state, true);
        } else {
            helper.setVisible(R.id.state, false);
        }
    }


}
