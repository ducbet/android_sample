package com.example.tmd.fragment_p;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements View.OnClickListener {//// TODO: 27/03/2017 1
    private static final String BUNDLE_COUNT = "BUNDLE_COUNT";
    private int mCount;
    private TextView mTextCount;
    private OnSendResult mListener; // TODO: 27/03/2017 3_4

    public static QuestionFragment newInstance(int count) {
        // TODO: 27/03/2017 Truyền data từ Main sang Fragment và trả lại 2_1
        QuestionFragment fragment = new QuestionFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_COUNT, count);

        // set bundle cho fragment
        fragment.setArguments(bundle);
        return fragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // TODO: 27/03/2017 2_3
        View v = inflater.inflate(R.layout.fragment_question, container, false);
        mTextCount = (TextView) v.findViewById(R.id.text_view_count);
        mTextCount.setText(mCount + "");
        v.findViewById(R.id.button_send_result).setOnClickListener(this); // TODO: 27/03/2017 3_3
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // TODO: 27/03/2017 2_2
        if (getArguments() == null) return;
        mCount = getArguments().getInt(BUNDLE_COUNT);
    }

    @Override
    public void onClick(View v) {// TODO: 27/03/2017 3_2


        // TODO: 27/03/2017 3_5
        mListener.sendResult(mCount);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnSendResult) getActivity();
    }

    public interface OnSendResult {
        // TODO: 27/03/2017 Gửi data ngược từ fragment đến Main 3_1
        /*
            B1: Tạo interface
            B2: Activity sẽ impliments lại interface này
            B3: Khởi tạo 1 interface trong fragment thông qua onAttach
         */
        void sendResult(int result);
    }
}
