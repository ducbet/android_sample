package com.example.tmd.kakukube;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.tmd.kakukube.MainActivity.LOSE;
import static com.example.tmd.kakukube.MainActivity.MAX_PROGRESS;
import static com.example.tmd.kakukube.MainActivity.countDownTimer;
import static com.example.tmd.kakukube.MainActivity.mDecreaseProgress;
import static com.example.tmd.kakukube.MainActivity.mKakukubeAdapter;
import static com.example.tmd.kakukube.MainActivity.mLevel;
import static com.example.tmd.kakukube.MainActivity.mProgress;
import static com.example.tmd.kakukube.MainActivity.mTxtLevel;


/**
 * Created by tmd on 24/03/2017.
 */

public class KakukubeAdapter extends RecyclerView.Adapter<KakukubeAdapter.ViewHolder> {


    private ArrayList<ItemKakukube> mListItem;
    private Context mContext;

    public Context getContext() {
        return mContext;
    }

    public KakukubeAdapter(Context context, ArrayList<ItemKakukube> listItem) {
        mListItem = listItem;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kakukube, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemKakukube item = mListItem.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mListItem.size() != 0) {
            return mListItem.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTxtCard;
        private ItemKakukube item;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTxtCard = (TextView) itemView.findViewById(R.id.text_view_kakukube);

        }

        public void blindData(ItemKakukube item) {
            this.item = item;
            mTxtCard.setBackgroundColor(item.getColor());
            mTxtCard.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (item.isCorrect()) {
                mLevel.loadNewLevel();

                // Chỉnh lại progress bar
                mProgress = MAX_PROGRESS;
                mDecreaseProgress -= 1;
                countDownTimer.cancel();
                countDownTimer.start();
                mTxtLevel.setText("Level: " + mLevel.getmLevel());

            } else {
                Toast.makeText(mContext, "WRONG", Toast.LENGTH_SHORT).show();
            }

        }
    }


}
