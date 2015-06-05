package com.zeropol2.materialdesignsupportsample.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeropol2.materialdesignsupportsample.R;
import com.zeropol2.materialdesignsupportsample.dto.CardDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zeropol2 on 15. 6. 2..
 */
public class CardRecyclerView extends RecyclerView{
    private CardAdapter mAdapter;

    public CardRecyclerView(Context context) {
        super(context);
        init();
    }

    public CardRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CardRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.card_recycler_view, this, true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        setLayoutManager(layoutManager);
    }

    public void setData(ArrayList<CardDto> list) {
        mAdapter = new CardAdapter(list);
        setAdapter(mAdapter);
    }

    public static class CardAdapter extends RecyclerView.Adapter<CardItem.CardItemViewHolder>{

        private ArrayList<CardDto> cards;

        private CardAdapter(ArrayList<CardDto> cards){
            this.cards = cards;
        }

        @Override
        public int getItemCount() {
            return cards.size();
        }

        @Override
        public CardItem.CardItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = new CardItem(viewGroup.getContext());
            viewGroup.addView(v, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
            CardItem.CardItemViewHolder viewHolder = new CardItem.CardItemViewHolder(v);
            return viewHolder;
//            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
//            CardItem.CardItemViewHolder viewHolder = new CardItem.CardItemViewHolder(v);
//            return viewHolder;
        }

        @Override
        public void onBindViewHolder(CardItem.CardItemViewHolder viewHolder, int i) {
            viewHolder.setData(cards.get(i));
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
}
