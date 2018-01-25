package com.example.tmd.assets_sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static com.example.tmd.assets_sharepreferences.ChangeFont.FONT_NAME;
import static com.example.tmd.assets_sharepreferences.ChangeFont.FONT_SHARE_PREFERENCES;
import static com.example.tmd.assets_sharepreferences.ChangeFont.txtTestFont;

/**
 * Created by tmd on 22/04/2017.
 */

public class FontAdapter extends RecyclerView.Adapter<FontAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList;

    public FontAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = (String) mList.get(position);
        holder.blindData(item);
    }

    @Override
    public int getItemCount() {
        if (mList != null) return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view);
            mTextView.setOnClickListener(this);
        }

        public void blindData(String item) {
//            try {
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "font/" + mList.get(getAdapterPosition()));
            mTextView.setTypeface(typeface);
//            } catch (Exception e) {
//                mList.remove(getAdapterPosition());
//                notifyItemRemoved(getAdapterPosition());
//            }
            mTextView.setText(item);
        }

        @Override
        public void onClick(View v) {
//            try {
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "font/" + mList.get(getAdapterPosition()));
            txtTestFont.setTypeface(typeface);
//            } catch (Exception e) {
//                mList.remove(getAdapterPosition());
//                notifyItemRemoved(getAdapterPosition());
//                Toast.makeText(mContext, "Can't load this font", Toast.LENGTH_LONG).show();
//            }

            SharedPreferences preferences = mContext.getSharedPreferences(FONT_SHARE_PREFERENCES, MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.putString(FONT_NAME, "font/" + mList.get(getAdapterPosition()));
            editor.commit();

        }


    }
}
