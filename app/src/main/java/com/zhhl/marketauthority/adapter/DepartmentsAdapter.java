package com.zhhl.marketauthority.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.bean.Backlog;
import com.zhhl.marketauthority.bean.DepartmentsBean;
import com.zhhl.marketauthority.bean.SubcontractBean;

import java.util.List;

public class DepartmentsAdapter extends BaseQuickAdapter<DepartmentsBean.ObjBean.ResBean, BaseViewHolder> {

    public DepartmentsAdapter(List<DepartmentsBean.ObjBean.ResBean> data) {
        super(R.layout.item_subcontrat, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, DepartmentsBean.ObjBean.ResBean item) {
        helper.setText(R.id.tv_title,"分包外协项目："+item.getV_D_DEPARTMENT());
    }
}
