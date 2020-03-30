package com.zhhl.marketauthority.fragment.center;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.BaseFragment;

/**
 * Created by 陈泽宇 on 2019/12/4.
 * Describe:工作中心
 */
public class WorkCenterFragment extends BaseFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment_work_center;
    }


    @Override
    protected void lazyLoad() {
        setTitleText("工作中心");
    }
}
