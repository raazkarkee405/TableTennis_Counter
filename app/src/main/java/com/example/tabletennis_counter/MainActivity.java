package com.example.tabletennis_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsForPlayerA;
    int pointsForPlayerB;
    int setsForPlayerA;
    int setsForPlayerB;
    int pointsForWin = 11;
    private TextView textViewPlayerA;
    private TextView textViewPlayerB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayerA = findViewById(R.id.Player_a_score);
        textViewPlayerB = findViewById(R.id.Player_b_score);
    }

    /**
     * Increase the score for Player A by 1 point.
     */

    public void addOneForPlayerA(View view) {
        pointsForPlayerA = pointsForPlayerA + 1;
        displayForPlayerA(pointsForPlayerA);
        if ( pointsForPlayerA >= pointsForWin && (pointsForPlayerA - pointsForPlayerB) >= 2){
            setsForPlayerA = setsForPlayerA + 1;
            displaySetsForPlayerA(setsForPlayerA);
            pointsReset();
        }
    }


    /**
     * Increase the score for Player B by 1 points.
     */
    public void addOneForPlayerB(View view) {
        pointsForPlayerB = pointsForPlayerB + 1;
        displayForPlayerB(pointsForPlayerB);
        if (pointsForPlayerB >= pointsForWin && (pointsForPlayerB - pointsForPlayerA) >= 2) {
            setsForPlayerB = setsForPlayerB + 1;
            displaySetsForPlayerB(setsForPlayerB);
            pointsReset();
        }
    }

    /**
     * Reset the score for both Players back to 0.
     */
    public void pointsReset () {
        pointsForPlayerA = 0;
        displayForPlayerA(pointsForPlayerA);
        pointsForPlayerB = 0;
        displayForPlayerB(pointsForPlayerB);
    }

    /**
     * Reset sets for Player A and Player B.
     */

    public void setsReset () {
        setsForPlayerA = 0;
        displaySetsForPlayerA(setsForPlayerA);
        setsForPlayerB = 0;
        displaySetsForPlayerB(setsForPlayerB);
    }

    /**
     * Reset points and sets for Player A and Player B.
     */

    public void resetScore(View view) {
        pointsReset();
        setsReset();
    }

    /**
     * Displays the given score for Player A.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Player B.
     */
    public void displayForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.Player_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays sets for Player A.
     */
    public void displaySetsForPlayerA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_a_player);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays sets for Player B.
     */
    public void displaySetsForPlayerB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.sets_b_player);
        scoreView.setText(String.valueOf(score));
    }
}
