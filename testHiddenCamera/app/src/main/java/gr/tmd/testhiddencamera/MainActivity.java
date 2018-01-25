package gr.tmd.testhiddencamera;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static boolean IS_WALKING = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IS_WALKING = true;
        startService(new Intent(this, BackgroundTakePicturesService.class));
    }
}
