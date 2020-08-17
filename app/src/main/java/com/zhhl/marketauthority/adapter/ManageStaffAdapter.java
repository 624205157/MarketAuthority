package com.zhhl.marketauthority.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.Backlog;
import com.zhhl.marketauthority.bean.ManageStaffBean;

import java.util.List;

public class ManageStaffAdapter extends BaseQuickAdapter<ManageStaffBean.ObjBean.ResBean, BaseViewHolder> {

    public ManageStaffAdapter(List<ManageStaffBean.ObjBean.ResBean> data) {
        super(R.layout.item_managestaff, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ManageStaffBean.ObjBean.ResBean item) {
            helper.setText(R.id.tv_title,"作业项目："+item.getV_M_ITEM());
    }
}
