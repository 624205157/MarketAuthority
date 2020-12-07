package com.zhhl.marketauthority.fragment.work;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhhl.marketauthority.R;
import com.zhhl.marketauthority.activity.BacklogActivity;
import com.zhhl.marketauthority.adapter.BacklogAdapter;
import com.zhhl.marketauthority.bean.BacklogFraBean;
import com.czy.commonlib.UrlConfig;
import com.czy.commonlib.fragment.BaseFragment;
import com.czy.commonlib.listener.DealCount;
import com.czy.commonlib.nohttp.NohttpClient;
import com.czy.commonlib.nohttp.listener.HttpListener;
import com.czy.commonlib.util.GsonUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 陈泽宇 on 2019/12/5.
 * Describe:待办事项
 */
public class BacklogFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeLayout;
    private BacklogAdapter mAdapter;
    private List<BacklogFraBean.ObjBean.VarListBean> mData = new ArrayList<>();
    private int row = 1;
    private int page = 10;
    private DealCount dealCount;
    @Override
    protected int setContentView() {
        return R.layout.fragment_backlog;
    }

    @Override
    protected void lazyLoad() {

        recyclerView = findViewById(R.id.recyclerView);
        swipeLayout = findViewById(R.id.swipeLayout);
        swipeLayout.setColorSchemeColors(Color.rgb(47, 223, 189));
        mAdapter = new BacklogAdapter(mData);
        mAdapter.openLoadAnimation();
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

                Intent intent = new Intent(mActivity, BacklogActivity.class);
                intent.putExtra("N_L_ID",mAdapter.getItem(position).getN_L_ID().toString());
                intent.putExtra("N_B_ID",mAdapter.getItem(position).getN_B_ID().toString());
                startActivity(intent);
            }
        });
        initRefreshLayout();
        refresh();
    }

    @Override
    public void onStart() {
        super.onStart();
            refresh();
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
//        request.add("row",1);
//        request.add("page",10);
        request.add("SXLX","1");
        nohttpClient.request(0,request,httpListener,true,false);
    }
    private void loadMore() {
        NohttpClient nohttpClient = new NohttpClient(getActivity());
        Request<String> request = NoHttp.createStringRequest(UrlConfig.PATH_BACKLOG, RequestMethod.POST);
//        request.add("row",row);
//        request.add("page",page);
        request.add("SXLX","1");
        nohttpClient.request(1,request,httpListener,true,false);

    }
    private HttpListener<String> httpListener = new HttpListener<String>() {
        @Override
        public void onSucceed(int what, Response<String> response) {
            Log.e("待办事项：" , response.get());
            BacklogFraBean produce = GsonUtil.GsonToBean(response.get(), BacklogFraBean.class);
            List<BacklogFraBean.ObjBean.VarListBean> resBeans = produce.getObj().getVarList();

            if (produce!=null && produce.getCode().equals("200")){
                if (dealCount!=null){
                    dealCount.dealCount(produce.getObj().getDaiban(),produce.getObj().getYibanli());
                    Log.e("待办事项数据条数：",dealCount + "");
                }
                if (what==0){
                    setData(true,resBeans);
                    mAdapter.setEnableLoadMore(true);
                    swipeLayout.setRefreshing(false);
                }else{
                    setData(false,resBeans);
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
    public void setDealCount(DealCount dealCount){
        this.dealCount = dealCount;
    }
}
