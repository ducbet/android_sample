package com.kimdung.kimdungtronbo.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimdung.kimdungtronbo.R;
import com.kimdung.kimdungtronbo.models.Paragraph;

import java.util.List;

/**
 * Created by tmd on 02/05/2017.
 */

public class ReadingAdapter extends RecyclerView.Adapter<ReadingAdapter.ViewHoler> {

    private static final String TAG = "MY_TAG_ReadingAdapter";
    private Context mContext;
    private List<Paragraph> mListParagraph;
    private float mCurrentTextSize = 15;


    public ReadingAdapter(Context context, List<Paragraph> listParagraph) {
        mContext = context;
        mListParagraph = listParagraph;
    }

    public void setListParagraph(List<Paragraph> listParagraph) {
        mListParagraph = listParagraph;
    }

    @Override
    public ViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_row_paragraph, parent, false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(ViewHoler holder, int position) {
        Paragraph paragraph = mListParagraph.get(position);
        holder.blindData(paragraph);
    }

    @Override
    public int getItemCount() {
        if (mListParagraph != null) return mListParagraph.size();
        return 0;
    }

    public List<Paragraph> getListParagraph() {
        return mListParagraph;
    }


    public void setDataSource(List<Paragraph> listParagraph) {
        mListParagraph = listParagraph;
        notifyDataSetChanged();
    }

    public void setCurrentTextSize(float currentTextSize) {
        mCurrentTextSize = currentTextSize;
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        private TextView mTextView;

        public void setTextSize() {
            mTextView.setTextSize(mCurrentTextSize);
        }

        public ViewHoler(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_view_paragraph);

            // nếu tạo mới thì setTextSize luôn
            // với những viewHolder đã tạo rôi thì phải lấy được holder rồi set lại
            mTextView.setTextSize(mCurrentTextSize);
//            Log.d(TAG, "ViewHoler: ");
        }

        public void blindData(Paragraph paragraph) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                Toast.makeText(this, "fromHtml with 2 params", Toast.LENGTH_SHORT).show();
                mTextView.setText(Html.fromHtml(paragraph.toString(), Html.FROM_HTML_MODE_COMPACT));
            } else {
//                Toast.makeText(this, "fromHtml with 1 param", Toast.LENGTH_SHORT).show();
                mTextView.setText(Html.fromHtml(paragraph.toString()));
            }
//            Log.d(TAG, "blindData: " + mTextView.getText().toString());
        }
    }
}
