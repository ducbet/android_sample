package tmd.mytest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetExtrasTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_extras_test);

        TextView txtvName = (TextView)findViewById(R.id.textViewName);
        Button btnReturn = (Button)findViewById(R.id.buttonReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GetExtrasTest.this, PutExtraTest.class);
                startActivity(myIntent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String strName = bundle.getString("hoten");
            txtvName.setText(strName);
        }
    }
}
