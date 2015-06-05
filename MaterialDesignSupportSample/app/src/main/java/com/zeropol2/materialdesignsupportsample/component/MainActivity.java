package com.zeropol2.materialdesignsupportsample.component;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zeropol2.materialdesignsupportsample.R;
import com.zeropol2.materialdesignsupportsample.datamanager.AsyncDataLoader;
import com.zeropol2.materialdesignsupportsample.datamanager.CardDataManager;
import com.zeropol2.materialdesignsupportsample.dto.CardDto;
import com.zeropol2.materialdesignsupportsample.ui.CardRecyclerView;
import com.zeropol2.materialdesignsupportsample.ui.CollapsiongToolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private CardRecyclerView mCardRecyclerView;
    private CollapsiongToolbar mCollapsiongToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initActionBar();
        loadData();
    }

    private void findView() {
        mCollapsiongToolbar = (CollapsiongToolbar)findViewById(R.id.collapsing_toolbar);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mCardRecyclerView = (CardRecyclerView)findViewById(R.id.card_recycler_view);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.fab);
    }

    private void initActionBar() {
        mCollapsiongToolbar.setTitle("샘플앱");

//        mDrawerToggle = new ActionBarDrawerToggle(
//                this,  mDrawerLayout, mCollapsiongToolbar.getToolbar(),
//                R.string.hello_world, R.string.hello_world
//        );
//        setSupportActionBar(mCollapsiongToolbar.getToolbar());
        setSupportActionBar(mCollapsiongToolbar.getToolbar());
        mDrawerToggle = new ActionBarDrawerToggle(
                this,  mDrawerLayout, mCollapsiongToolbar.getToolbar(),
                R.string.hello_world, R.string.hello_world
        );

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    private void loadData() {
        CardDataManager.getInstance().loadCards(mDataLoadListener);
    }

    private AsyncDataLoader.OnDataLoadListener<ArrayList<CardDto>> mDataLoadListener = new AsyncDataLoader.OnDataLoadListener<ArrayList<CardDto>>() {
        @Override
        public void onDataLoad(ArrayList<CardDto> data) {
            mCardRecyclerView.setData(data);
        }

        @Override
        public void onDataLoadFail(int code, String message) {

        }
    };
}
