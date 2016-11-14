package com.example.xw.todayinhistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by xw on 2016/11/11.
 */
public class FragmentA extends Fragment {
    RecyclerView mRecyclerView;
    String[] datas={"111","222","333","111","222","333","111","222","333","111",
            "222","333","111","222","333","111","222","333","111","222","333","111","222","333"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.history_fragment,container,false);
        Toolbar toolbar= (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.his_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new HisAdapter());
        return view;
    }
    private class HisHoider extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public HisHoider(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView;
        }
    }
    private class HisAdapter extends RecyclerView.Adapter<HisHoider>{

        @Override
        public HisHoider onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(getActivity());
            View view=layoutInflater.inflate(android.R.layout.simple_list_item_1,parent,false);
            return new HisHoider(view);
        }

        @Override
        public void onBindViewHolder(HisHoider holder, int position) {
            holder.mTextView.setText(datas[position]);
        }

        @Override
        public int getItemCount() {
            return datas.length;
        }
    }

}
