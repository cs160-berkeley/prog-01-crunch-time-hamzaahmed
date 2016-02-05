package com.example.hamza.crunchtime;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Spinner exerciseSpinner = (Spinner) findViewById(R.id.ExerciseSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.exercise_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        exerciseSpinner.setAdapter(adapter);

        final TextView conversion1 = (TextView) findViewById(R.id.Conversion1);
        final TextView conversion2 = (TextView) findViewById(R.id.Conversion2);
        final TextView conversion3 = (TextView) findViewById(R.id.Conversion3);
        final TextView conversion4 = (TextView) findViewById(R.id.Conversion4);
        final TextView conversion5 = (TextView) findViewById(R.id.Conversion5);
        final TextView conversion6 = (TextView) findViewById(R.id.Conversion6);
        final TextView conversion7 = (TextView) findViewById(R.id.Conversion7);
        final TextView conversion8 = (TextView) findViewById(R.id.Conversion8);
        final TextView conversion9 = (TextView) findViewById(R.id.Conversion9);
        final TextView conversion10 = (TextView) findViewById(R.id.Conversion10);
        final TextView conversion11= (TextView) findViewById(R.id.Conversion11);
        final TextView conversion12 = (TextView) findViewById(R.id.Conversion12);
        final TextView outputText = (TextView) findViewById(R.id.Output);
        final EditText amountVal = (EditText) findViewById(R.id.AmountInput);

        exerciseSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                outputText.setText("0");
                conversion1.setText("0");
                conversion2.setText("0");
                conversion3.setText("0");
                conversion4.setText("0");
                conversion5.setText("0");
                conversion6.setText("0");
                conversion7.setText("0");
                conversion8.setText("0");
                conversion9.setText("0");
                conversion10.setText("0");
                conversion11.setText("0");
                conversion12.setText("0");
                String exercise = exerciseSpinner.getSelectedItem().toString();

                amountVal.setText("");
                if (exercise.equalsIgnoreCase("Pushup") || exercise.equalsIgnoreCase("Situp")
                        || exercise.equalsIgnoreCase("Squats") ||
                        exercise.equalsIgnoreCase("Pullup")) {
                    amountVal.setHint("How many reps?");
                } else {
                    amountVal.setHint("How many minutes?");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                return;
            }

        });


        Button button = (Button) findViewById(R.id.CalculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                String exercise = exerciseSpinner.getSelectedItem().toString();
                String val = amountVal.getText().toString();
                double i = Double.parseDouble(val);
                double result = 0;
                int result2 = 0;
                double temp;

                if (exercise.equalsIgnoreCase("Pushup")) {
                    result = (i*100)/350;
                } else if (exercise.equalsIgnoreCase("Situp")) {
                    result = (i*100)/200;
                }  else if (exercise.equalsIgnoreCase("Squats")) {
                    result = (i*100)/225;
                }   else if (exercise.equalsIgnoreCase("Leg-lift")) {
                    result = (i*100)/25;
                }  else if (exercise.equalsIgnoreCase("Plank")) {
                    result = (i*100)/25;
                } else if (exercise.equalsIgnoreCase("Jumping Jacks")) {
                    result = (i*100)/10;
                } else if (exercise.equalsIgnoreCase("Pullup")) {
                    result = (i*100)/100;
                }  else if (exercise.equalsIgnoreCase("Cycling")) {
                    result = (i*100)/12;
                }  else if (exercise.equalsIgnoreCase("Walking")) {
                    result = (i*100)/20;
                } else if (exercise.equalsIgnoreCase("Jogging")) {
                    result = (i*100)/12;
                } else if (exercise.equalsIgnoreCase("Swimming")) {
                    result = (i*100)/13;
                }  else if (exercise.equalsIgnoreCase("Stair-Climbing")) {
                    result = (i*100)/15;
                }
                temp = result/100;
                int conversion1val = (int) Math.round(temp * 350); //Pushup
                int conversion2val = (int) Math.round(temp * 200); //Situp
                int conversion3val = (int) Math.round(temp * 225); //Squats
                int conversion4val = (int) Math.round(temp * 25); //Leg-lift
                int conversion5val = (int) Math.round(temp * 25); //Plank
                int conversion6val = (int) Math.round(temp * 10); //Jumping Jacks
                int conversion7val = (int) Math.round(temp * 100); //Pullup
                int conversion8val = (int) Math.round(temp * 12); //Cycling
                int conversion9val = (int) Math.round(temp * 20); //Walking
                int conversion10val = (int) Math.round(temp * 12); //Jogging
                int conversion11val = (int) Math.round(temp * 13); //Swimming
                int conversion12val = (int) Math.round(temp * 15); //Stair Climbing
                conversion1.setText(conversion1val + "");
                conversion2.setText(conversion2val + "");
                conversion3.setText(conversion3val + "");
                conversion4.setText(conversion4val + "m");
                conversion5.setText(conversion5val + "m");
                conversion6.setText(conversion6val + "m");
                conversion7.setText(conversion7val + "");
                conversion8.setText(conversion8val + "m");
                conversion9.setText(conversion9val + "m");
                conversion10.setText(conversion10val + "m");
                conversion11.setText(conversion11val + "m");
                conversion12.setText(conversion12val + "m");
                result2 = (int) Math.round(result);
                outputText.setText(result2 + "");
            }
        });

        amountVal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                outputText.setText("0");
                conversion1.setText("0");
            conversion2.setText("0");
            conversion3.setText("0");
            conversion4.setText("0");
            conversion5.setText("0");
            conversion6.setText("0");
            conversion7.setText("0");
            conversion8.setText("0");
            conversion9.setText("0");
            conversion10.setText("0");
            conversion11.setText("0");
            conversion12.setText("0");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
