package com.zhhl.marketauthority.activity.backlog;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BaseActivity;
import com.zhhl.marketauthority.adapter.GridImageAdapter;
import com.zhhl.marketauthority.util.ScreenUtils;
import com.zhhl.marketauthority.view.FullyGridLayoutManager;

import butterknife.BindView;

//申请单位资源
public class ApplyUnitResouse extends BaseActivity {

    private ImageView back;
    private ImageView change;
    GridImageAdapter adapter;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @Override
    protected int setContentView() {
        return R.layout.activity_applyunit_res;
    }

    @Override
    protected void onCreate() {
        addBack();
        setTitleText("申请单位资源");
        change = addChange();
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSate();
//                mAdapter.setToChange(true);
            }
        });
        init();
        setData();
    }

    private void init() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this,
                4, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
//        recyclerView.addItemDecoration(new GridSpacingItemNotBothDecoration(4,
//                ScreenUtils.dip2px(ApplyUnitResouse.this, 8), true, false));
        adapter = new GridImageAdapter(ApplyUnitResouse.this, onAddPicClickListener);
//      adapter.setList(selectList);//设置数据
        recycler.setAdapter(adapter);
    }
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {

        @Override
        public void onAddPicClick() {

        }
    };
    private void setData() {

    }

    private void changeSate() {

    }
}
