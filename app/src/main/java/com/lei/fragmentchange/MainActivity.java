package com.lei.fragmentchange;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lei.fragment.GiftFragment;
import com.lei.fragment.OrderFragment;
import com.lei.fragment.ShareFragment;
import com.lei.fragment.ShopRankFragment;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    private FragmentManager manager;       //声明管理和事务
    private FragmentTransaction transaction;

    private RadioButton rb_shoprank,rb_share,rb_gift,rb_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();

        transaction.add(R.id.content_layout,new ShopRankFragment());
        transaction.commit();
        initView();
    }
    //初始化view视图
    public void initView(){
        rb_shoprank = findViewById(R.id.rb_shoprank);
        rb_share = findViewById(R.id.rb_share);
        rb_gift = findViewById(R.id.rb_gift);
        rb_order = findViewById(R.id.rb_order);

        rb_order.setOnClickListener(this);
        rb_gift.setOnClickListener(this);
        rb_share.setOnClickListener(this);
        rb_shoprank.setOnClickListener(this);
    }

    /*
    点击RadioButton 时触发的事件
     */
    @Override
    public void onClick(View v) {
        transaction = manager.beginTransaction();
        switch(v.getId()) {
            case R.id.rb_shoprank:
                transaction.replace(R.id.content_layout,new ShopRankFragment());
                Toast.makeText(this, "热销排行", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_share:
                transaction.replace(R.id.content_layout,new ShareFragment());
                Toast.makeText(this, "手机专享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_gift:
                transaction.replace(R.id.content_layout,new GiftFragment());
                Toast.makeText(this, "未来礼品", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_order:
                transaction.replace(R.id.content_layout,new OrderFragment());
                Toast.makeText(this, "我的订单", Toast.LENGTH_SHORT).show();
                break;
        }
        transaction.commit();
    }
}
