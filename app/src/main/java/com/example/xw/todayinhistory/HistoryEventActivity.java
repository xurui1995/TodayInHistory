package com.example.xw.todayinhistory;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryEventActivity extends AppCompatActivity {
    @BindView(R.id.event_image_view)
    ImageView mImageView;
    @BindView(R.id.event_textview)
    TextView mTextView;
    @BindView(R.id.event_collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.event_tool_bar)
    Toolbar mToolbar;

    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_history_event);
        ButterKnife.bind(this);
        bundle = getIntent().getExtras();
        initView();

    }

    private void initView() {
        mCollapsingToolbarLayout.setTitle(bundle.getString("Title"));

        if (!TextUtils.isEmpty(bundle.getString("PicUrl"))){

                Glide.with(this).load(bundle.getString("PicUrl"))
                        .error(R.drawable.nopic)
                        .into(mImageView);
        }
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
