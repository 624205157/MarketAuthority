package com.czy.jg.fragment;

import com.czy.commonlib.fragment.GroupPopFragment;
import com.czy.jg.R;

public class Fragment1 extends GroupPopFragment {

    @Override
    protected void lazyLoad() {
        if (findChildFragment(WorkFragment.class) == null) {
            loadRootFragment(R.id.home, new WorkFragment());
        }
    }


}
