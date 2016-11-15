package com.example.xw.todayinhistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import RetrofitService.HistoriesService;
import adapter.HistoryRecyclerAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import model.Histories;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by xw on 2016/11/11.
 */
public class FragmentA extends Fragment {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.his_recycleview)
    RecyclerView mRecyclerView;
   @BindView(R.id.history_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    private HistoryRecyclerAdapter adapter;

    public static final String BASE_URL = "http://api.juheapi.com/";
    public static final String APIKEY = "c19d9cb3c78b1e3e4a4654ae7edd7183";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view=inflater.inflate(R.layout.history_fragment,container,false);
        ButterKnife.bind(this,view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        swipeRefreshLayout.setRefreshing(true);

        getDatas();
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPrimary));
        /* 设置下拉刷新 */
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mRecyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRecyclerView.setAdapter(null);  /* 模拟空白 */
                        getDatas();       /* 重新获取数据 */
                    }
                }, 1000);
            }
        });
        return view;
    }

    private void getDatas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        HistoriesService historiesService=retrofit.create(HistoriesService.class);
        Observable<Histories> observable=historiesService.getHistoriesDatas("1.0",11,15,APIKEY);
        observable.subscribeOn(Schedulers.io())
                .map(new Func1<Histories, List<Histories.HistoryBean>>() {
                    @Override
                    public List<Histories.HistoryBean> call(Histories histories) {
                        Log.d("AAA",histories.getReason());
                        return histories.getResult();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Histories.HistoryBean>>() {
                    @Override
                    public void onCompleted() {

                        mRecyclerView.setAdapter(adapter);
                        swipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("ERR",e.toString());
                    }

                    @Override
                    public void onNext(List<Histories.HistoryBean> historyBeans) {

                        adapter = new HistoryRecyclerAdapter(getActivity(), historyBeans);
                    }
                });



 }


}
