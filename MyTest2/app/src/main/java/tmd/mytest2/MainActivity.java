package tmd.mytest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLoadImageInternet = (Button) findViewById(R.id.btnLoadImageInternet);
        btnLoadImageInternet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, LoadImageInternet.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button btnLoadXML_RSS = (Button) findViewById(R.id.btnReadXML_RSS);
        btnLoadXML_RSS.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ReadXML_RSS.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button btnPutExtra = (Button) findViewById(R.id.btnPutExtra);
        btnPutExtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PutExtraTest.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button btnAnimation = (Button) findViewById(R.id.btnAnimation);
        btnAnimation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AnimationTest.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
