package com.studio.yanzhichao.multiplexingadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mlistiview;
    private List<Bean> mData;
    private Bean bean;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initView();
    }


    private void initView() {
        mlistiview = (ListView)findViewById(R.id.id_list);
        //使用匿名内部类
        mlistiview.setAdapter(new ComAdapter<Bean>(MainActivity.this,mData,R.layout.item_listview) {

            @Override
            public void convert(ViewHolder holder, Bean bean) {
                holder.setText(R.id.text_title, bean.getTitle())
                        .setText(R.id.text_desc, bean.getDesc())
                        .setText(R.id.text_time, bean.getTime())
                        .setText(R.id.textView4, bean.getPhone());
            }
        });
    }

    private void initDatas() {
        mData = new ArrayList<>();
        bean = new Bean("数学","二次方程","人门","1");
        mData.add(bean);
        bean = new Bean("数学","三次方程","人门","2");
        mData.add(bean);
        bean = new Bean("数学","四次方程","人门","3");
        mData.add(bean);
        bean = new Bean("数学","二次方程","人门","4");
        mData.add(bean);
        bean = new Bean("数学","二次方程","人门","5");
        mData.add(bean);
        bean = new Bean("数学","二次方程","人门","6");
        mData.add(bean);

//        myAdapter = new MyAdapter(this,mData);

    }
}
