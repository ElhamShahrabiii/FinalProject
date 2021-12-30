package ir.shariaty.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtsearch;
    ImageButton btnserach;
    Spinner firstSpinner,secondSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtsearch = (EditText) findViewById(R.id.txtsearch1);
        btnserach = (ImageButton) findViewById(R.id.btnsearch);

//        btnserach.setOnClickListener(this::onClickSecond);


        firstSpinner = (Spinner) findViewById(R.id.firstSpinner);
        secondSpinner = (Spinner) findViewById(R.id.secondSpinner);

                // Class Spinner implementing onItemSelectedListener
                firstSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        // do something upon option selection
                        String selectedDiv1 = parent.getItemAtPosition(position).toString();
// creating Toast
                        Toast.makeText(MainActivity.this, selectedDiv1 , Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {
                        // can leave this empty
                    }
                });

                // Div Spinner implementing onItemSelectedListener
                secondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                    {
                        // do something upon option selection
                       String selectedDiv2 = parent.getItemAtPosition(position).toString();
// creating Toast
                        Toast.makeText(MainActivity.this,  selectedDiv2, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent)
                    {
                        // can leave this empty
                    }

                });
            }

    public void onClickSecond(View v) {

             String search = txtsearch.getText().toString();
                Intent intent = new Intent(this,MainActivity3.class);
                Bundle b = new Bundle();
                b.putString("search", search);
                intent.putExtra("bundleData", b);
                startActivity(intent);

            }



}