package com.tubequiz.tubequiz03;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
//import android.widget.EditText;
import android.widget.TextView;

public class StationQuiz extends Activity {

    TextView stationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_quiz);

        stationName = (TextView) findViewById(R.id.tvStation);
        stationName.setText("");
    }

    public void startCountdown (View v){

        final Button startButton = (Button) findViewById(R.id.startbutton);

        new CountDownTimer(3100, 1000) { // see http://stackoverflow.com/questions/10032003/how-to-make-a-countdown-timer-in-android

            public void onTick(long millisUntilFinished) {
                startButton.setText((millisUntilFinished / 1000) + "");
            }

            public void onFinish() {
                startButton.setText("Go!");
                start_quiz();
            }
        }.start();

    }

    public void start_quiz() {

        stationName.setText("Elephant & Castleish");
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lines_quiz, menu);
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
*/
}