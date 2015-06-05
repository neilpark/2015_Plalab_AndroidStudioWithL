package com.zeropol2.materialdesignsupportsample.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zeropol2.materialdesignsupportsample.R;
import com.zeropol2.materialdesignsupportsample.dto.CardDto;

/**
 * Created by zeropol2 on 15. 6. 2..
 */
public class CardItem extends LinearLayout{
    private LinearLayout mLayout;
    private CardView mCardView;
    private ImageView mPhoto;
    private TextView mName;
    private TextView mAge;

    public CardItem(Context context) {
        super(context);
        init();
    }

    public CardItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CardItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CardItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        this.setPadding(32,32,32,32);
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (LinearLayout) inflater.inflate(R.layout.card_item, this, true);
        mCardView = (CardView)mLayout.findViewById(R.id.card_view);
        mPhoto = (ImageView)mLayout.findViewById(R.id.photo);
        mName = (TextView)mLayout.findViewById(R.id.name);
        mAge = (TextView)mLayout.findViewById(R.id.age);
    }

    public void setData(CardDto data) {
        mPhoto.setImageResource(data.photo);
        mName.setText(data.name);
        mAge.setText(String.valueOf(data.age));
    }

    public static class CardItemViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        private ImageView photo;
        private TextView name;
        private TextView age;

        public CardItemViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView.findViewById(R.id.card_view);
            photo = (ImageView)itemView.findViewById(R.id.photo);
            name = (TextView)itemView.findViewById(R.id.name);
            age = (TextView)itemView.findViewById(R.id.age);
        }

        public void setData(CardDto data) {
            photo.setImageResource(data.photo);
            name.setText(data.name);
            age.setText(String.valueOf(data.age));
        }
    }
}
