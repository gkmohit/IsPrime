package com.gkmohit.unknown.isprime;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;


public class isPrime extends Activity {

    Button mButton = null;
    TextView resultText = null;
    EditText mInput = null;
    RelativeLayout myLayout = null;
    long input ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        mButton = (Button)findViewById(R.id.myButton);
        resultText = (TextView)findViewById(R.id.resultAnswer);
        mInput = (EditText) findViewById(R.id.inNumber);
        myLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        // Look up the AdView as a resource and load a request.

        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    input = Integer.parseInt(mInput.getText().toString());
                    if(input == 1){
                        resultText.setText("1 is neither a prime number nor composite number.");
                    }
                    if(input == 2){
                        resultText.setText("The integer is a Prime Number.");
                    }
                    else{
                        for(int i = 2; i < input; i++){
                            if( input % i == 0){
                                resultText.setText("The integer is not a Prime Number.\nIt is a composite number and is divisible by : " + i);
                                break;
                            }
                            else{
                                resultText.setText("The integer is a Prime Number.");
                            }
                        }
                    }

                }
                catch( NumberFormatException e){
                    resultText.setText("Please enter an integer.");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
