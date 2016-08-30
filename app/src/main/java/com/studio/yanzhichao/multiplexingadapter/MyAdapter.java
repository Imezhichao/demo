package com.studio.yanzhichao.multiplexingadapter;

import android.content.Context;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
public class MyAdapter extends ComAdapter<Bean> {


    public MyAdapter(Context mContext, List listBean) {
        super(mContext, listBean,R.layout.item_listview);
    }


    @Override
    public void convert(ViewHolder holder, Bean bean) {
        holder.setText(R.id.text_title, bean.getTitle())
                .setText(R.id.text_desc, bean.getDesc())
                .setText(R.id.text_time, bean.getTime())
                .setText(R.id.textView4, bean.getPhone());

    }

}
