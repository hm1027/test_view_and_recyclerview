package com.bydauto.car.i_key.hmmm;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private OnItemClickListener listener;
    private OnItemLongClickListener longlistener;
    private List<String> mDatas;

    public CustomAdapter(List<String> datas) {
        this.mDatas = datas;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener longlistener) {
        this.longlistener = longlistener;
    }


    interface OnItemClickListener {
        void onClick(View v, int position, String str);
    }

    interface OnItemLongClickListener {
        void onLongClick(View v, int position, String str);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R
                        .layout.item_home,
                parent, false));
        return holder;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.item_num);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onClick(v, getLayoutPosition(), mDatas.get(getLayoutPosition()));
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (null != longlistener) {
                        longlistener.onLongClick(v, getLayoutPosition(), mDatas.get
                                (getLayoutPosition()));
                    }
                    return true;
                }
            });
        }
    }

}
