package com.czy.jg.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.czy.commonlib.fragment.BaseFragment;
import com.czy.commonlib.listener.DoneCount;
import com.czy.commonlib.nohttp.NohttpClient;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.GsonUtil;
import com.czy.jg.R;
import com.czy.jg.UrlConfig;
import com.czy.jg.adapter.FinishAdapter;
import com.czy.jg.bean.FinishFraBean;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:已办事项
 */
public class JGFinishFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeLayout;
    private FinishAdapter mAdapter;
    private List<FinishFraBean.ObjBean.VarListBean> mData = new ArrayList<>();
    private int row = 1;
    private int page = 10;
    private RadioGroup rg_state;
    private DoneCount doneCount;

    @Override
    protected int setContentView() {
        return R.layout.jg_fragment_finish_work;
    }

    @Override
    protected void lazyLoad() {
        rg_state = findViewById(R.id.rg_state);
        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swipeLayout);
        mAdapter = new FinishAdapter(mData);
        initEvent();
        refresh();

    }

    private void initEvent() {
        mAdapter.openLoadAnimation();
        swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(mAdapter);
        swipeLayout.setRefreshing(true);
//        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
//            @Override
//            public void onLoadMoreRequested() {
//                loadMore();
//            }
//        });
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
//        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
//            @Override
//            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                switch (view.getId()){
//                    case R.id.tv_preview:
//                        System.out.println("索引位置："+position);
//                        String N_L_ID = ((FinishFraBean.ObjBean.VarListBean) adapter.getItem(position)).getN_L_ID();
//                        Intent intent = new Intent(mContext,PreviewReport.class);
//                        intent.putExtra("N_L_ID",N_L_ID);
//                        startActivity(intent);
//                        break;
//                }
//            }
//        });
//        rg_state.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkId) {
//                switch (checkId){
//                    case R.id.all://全部
//                        CXLX = 1;
//                        break;
//                    case R.id.type_1://合格
//                        CXLX = 2;
//                        break;
//                    case R.id.type_2://整改
//                        CXLX = 3;
//                        break;
//                    case R.id.type_3://不合格
//                        CXLX = 4;
//                        break;
//                }
//                swipeLayout.setRefreshing(true);
//                refresh();
//            }
//        });
        initRefreshLayout();
    }

    private void initRefreshLayout() {
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
    }

    private void refresh() {
        mAdapter.setEnableLoadMore(false);//这里的作用是防止下拉刷新的时候还可以上拉加载
        NohttpClient nohttpClient = new NohttpClient(getActivity());
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_BACKLOG, RequestMethod.POST);
        request.add("blType", "2");
        nohttpClient.request(0, request, httpListener, true, false);
    }

    private void loadMore() {
        NohttpClient nohttpClient = new NohttpClient(getActivity());
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_BACKLOG, RequestMethod.POST);
//        request.add("row",row);
//        request.add("page",page);
        request.add("SXLX", "2");
        nohttpClient.request(1, request, httpListener, true, false);

    }

    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            System.out.println("已完成数据：" + response.get());
            FinishFraBean finish = GsonUtil.GsonToBean(response.get(), FinishFraBean.class);
            List<FinishFraBean.ObjBean.VarListBean> resBeans = finish.getObj().getVarList();
            if (finish != null && finish.getCode().equals("200")) {
                if (what == 0) {
                    setData(true, resBeans);
                    mAdapter.setEnableLoadMore(true);
                    swipeLayout.setRefreshing(false);
                } else {
                    setData(false, resBeans);
                }
                mAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onFailed(int what, Response<String> response) {
            mAdapter.setEnableLoadMore(true);
            swipeLayout.setRefreshing(false);
        }
    };

    private void setData(boolean isRefresh, List data) {
        row++;
        final int size = data == null ? 0 : data.size();
        if (isRefresh) {
            mAdapter.setNewData(data);
        } else {
            if (size > 0) {
                mAdapter.addData(data);
            }
        }
        if (size < page) {
            //第一页如果不够一页就不显示没有更多数据布局
            mAdapter.loadMoreEnd(isRefresh);
            //MyToast.makeText(AgencyActivity.this, "no more data", MyToast.LENGTH_SHORT).show();
        } else {
            mAdapter.loadMoreComplete();
        }
    }

    public void setDoneCount(DoneCount doneCount) {
        this.doneCount = doneCount;
    }
}
