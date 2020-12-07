package com.zhhl.marketauthority.fragment;

import com.czy.commonlib.fragment.GroupPopFragment;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.center.WorkCenterFragment;

public class Fragment2 extends GroupPopFragment {

    @Override
    protected void lazyLoad() {
        if (findChildFragment(WorkCenterFragment.class) == null) {
            loadRootFragment(R.id.home, new WorkCenterFragment());
        }
    }

}
