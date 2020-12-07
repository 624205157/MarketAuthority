package com.zhhl.marketauthority.fragment;

import com.czy.commonlib.fragment.GroupPopFragment;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.fragment.work.WorkFragment;

public class Fragment1 extends GroupPopFragment {

    @Override
    protected void lazyLoad() {
        if (findChildFragment(WorkFragment.class) == null) {
            loadRootFragment(R.id.home, new WorkFragment());
        }
    }


}
