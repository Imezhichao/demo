package com.studio.yanzhichao.multiplexingadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/8/28.
 */
public abstract class ComAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<Bean> mData;
    protected LayoutInflater mLayout;
    private int layoutID;

    public ComAdapter(Context mContext, List<Bean> listBean,int layoutID) {
        mLayout = LayoutInflater.from(mContext);
        this.mContext = mContext;
        this.mData = listBean;
        this.layoutID = layoutID;
    }
    @Override
    public int getCount() {
        return mData.size();
    }
    /*
    把Object修改成T
     */
    @Override
    public T getItem(int position) {
        return (T) mData.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder(mContext, parent, layoutID, position);
        convert(holder, getItem(position));

        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);

}
