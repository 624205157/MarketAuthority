package com.zhhl.marketauthority.listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * @describe：长按事件
 */
public interface OnItemLongClickListener {
    void onItemLongClick(RecyclerView.ViewHolder holder, int position, View v);
}
