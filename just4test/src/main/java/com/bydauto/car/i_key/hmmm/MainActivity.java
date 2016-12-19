package com.bydauto.car.i_key.hmmm;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    private List<String> mDatas;
    public CustomAdapter mCustomAdapter;
    public final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
        setContentView(R.layout.activity_main);

        initDatas();

        mRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCustomAdapter = new CustomAdapter(mDatas);
        mRecyclerView.setAdapter(mCustomAdapter);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL_LIST));
                mCustomAdapter.setOnItemClickListener(
                        new CustomAdapter.OnItemClickListener() {
                            @Override
                            public void onClick(View v, int position, String str) {
                                Toast.makeText(MainActivity.this, "短按 " + "string is " + str + ",position" +

                                        " is " + position, Toast
                                        .LENGTH_SHORT).show();
                            }
                        });
        mCustomAdapter.setOnItemLongClickListener(new CustomAdapter.OnItemLongClickListener() {
            @Override
            public void onLongClick(View v, int position, String str) {
                Toast.makeText(MainActivity.this, "长按 " + "string is " + str + ",position is " +
                        position, Toast
                        .LENGTH_SHORT).show();
                ;
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add(String.valueOf((char) i));
        }
    }


//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        // TODO Auto-generated method stub
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View
// .SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//    }


}
