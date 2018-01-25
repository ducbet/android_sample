package com.example.dc.retrofit_lib;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
     https://api.github.com/users/list?sort=desc
     xác định base url: https://api.github.com
    */

    private Button mBtnGetData;
    private TextView mTxtResult;
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        mBtnGetData.setOnClickListener(this);
    }

    private void addControls() {

        mBtnGetData = (Button) findViewById(R.id.button_get_data);
        mTxtResult = (TextView) findViewById(R.id.text_view_result);
    }

    @Override
    public void onClick(View v) {
        // TODO: 25/04/2017 5

        createProgressDialog();

        // Khoi tao service
        GithubService service = ServiceGenerator.createService(GithubService.class);
//        service.getGithub().enqueue(new Callback<ResponseBody>() {
        service.getGithub("desc").enqueue(new Callback<GithubModel>() {
            @Override
            public void onResponse(Call<GithubModel> call, Response<GithubModel> response) {
                // connect thanh cong
                if (response != null) {
                    GithubModel model = response.body();
                    // update len giao dien
//                    mTxtResult.setText(model.getUrl() + "\n" + model.getFollowUrl());
                    // get response
                    // mTxtResult.setText(response.body().string()); // + try catch
                    mTxtResult.setText(model.getUrl());
                }
                mDialog.dismiss();
            }

            @Override
            public void onFailure(Call<GithubModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                mDialog.dismiss();
            }
        });
    }


    private void createProgressDialog() {
        mDialog = new ProgressDialog(MainActivity.this);
        mDialog.show();
    }
}
