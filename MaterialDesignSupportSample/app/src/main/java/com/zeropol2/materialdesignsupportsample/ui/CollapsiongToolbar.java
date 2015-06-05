package com.zeropol2.materialdesignsupportsample.ui;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.zeropol2.materialdesignsupportsample.R;

/**
 * Created by zeropol2 on 15. 6. 2..
 */
public class CollapsiongToolbar extends AppBarLayout{

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;

    public CollapsiongToolbar(Context context) {
        super(context);
        init();
    }

    public CollapsiongToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.collapsing_toolbar, this, true);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar_layout);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);

    }

    public void setTitle(String title) {
        mCollapsingToolbarLayout.setTitle(title);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }



}
