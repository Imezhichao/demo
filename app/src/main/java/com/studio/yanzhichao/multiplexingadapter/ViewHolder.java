package com.studio.yanzhichao.multiplexingadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/28.
 */
public class ViewHolder {
    private SparseArray<View> mSparse; //存储id
    private int mPosition;
    private View mConvertView;

    /*
    初始化
     */
    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position)
    {
        this.mSparse = new SparseArray<>();
        this.mPosition = position;
        mConvertView = LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);
    }

    /*
    复用
     */
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position)
    {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position; //每次复用后更新ID位置，
            return holder;
        }
    }

    /*
    获取ID初始化
     */
    public <T extends View> T getView (int viewId)
    {
        T t = (T) mSparse.get(viewId);  //这里我用了另一种写法效果是一样的
        if (t ==null){
            t = (T) mConvertView.findViewById(viewId);
            mSparse.put(viewId,t);
        }
        return t;
    }
    /*
    返回ConvertView
     */
    public View getConvertView()
    {
        return mConvertView;
    }


    /*
    添加文字
     */
    public ViewHolder setText(int viewId,String Text){

        TextView tv = getView(viewId);
        tv.setText(Text);
        return this;
    }


    /*
    添加图片
     */
    public ViewHolder mImageView(int viewId,int srcitem){

        ImageView iV = getView(viewId);
        iV.setImageResource(srcitem);
        return this;
    }

    /*
    可以添加更多，自由开阔
     */

}
