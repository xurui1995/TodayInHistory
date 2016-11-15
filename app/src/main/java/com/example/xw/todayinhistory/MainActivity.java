package com.example.xw.todayinhistory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;
    FragmentManager mFragmentManager;
    FragmentA fa;
    FragmentB fb;
    FragmentC fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initView();
        initTab();
    }

    private void initTab() {
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                switch (position) {

                    case 0:
                        if (fc != null)
                            transaction.hide(fc);
                        if (fb != null)
                            transaction.hide(fb);
                        transaction.show(fa);
                        break;
                    case 1:
                        if (fb == null) {
                            fb = new FragmentB();
                            transaction.add(R.id.container, fb);
                        }
                        transaction.show(fb);
                        transaction.hide(fa);
                        if (fc != null) {
                            transaction.hide(fc);
                        }
                        break;
                    case 2:
                        if (fc == null) {
                            fc = new FragmentC();
                            transaction.add(R.id.container, fc);
                        }
                        transaction.show(fc);
                        transaction.hide(fa);
                        if (fb != null)
                            transaction.hide(fb);
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void initView() {
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_bar);
        bottomNavigationBar
                .setActiveColor(R.color.colorPrimary)
                .setInActiveColor(R.color.grey)
                .setBarBackgroundColor("#FFFFFF");
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.history, "历史"))
                .addItem(new BottomNavigationItem(R.drawable.girls, "美女"))
                .addItem(new BottomNavigationItem(R.drawable.news, "新闻"))
                .initialise();
        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(R.id.container);
        if (fragment == null) {
            fa = new FragmentA();
            fragment = fa;
            mFragmentManager.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }


}
