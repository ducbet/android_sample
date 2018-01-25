package tmd.mytest2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PutExtraTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_extra_test);

        Button btnPutExtra = (Button)findViewById(R.id.buttonPutExtra);
        final EditText edtName = (EditText)findViewById(R.id.editTextName);

        btnPutExtra.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(PutExtraTest.this, GetExtrasTest.class);
                myIntent.putExtra("hoten", edtName.getText().toString());
                startActivity(myIntent);
            }
        });
    }
}
