package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    TextView headerGuess;
    TextView responseGuess;
    EditText editGuess;
    Button buttonGuess;
    Button buttonReset;

    static final int NUMBER = 22;

    static final int CORRECT = 0;
    static final int LOW = 1;
    static final int HIGH = 2;
    static final int RESET = 3;

    private static int checkGuess(int guess) {
        if (guess > NUMBER) {
            Log.i("Demo", "Too High");
            return 2;
        } else if (guess < NUMBER) {
            Log.i("Demo", "Too Low");
            return 1;
        } else {
            Log.i("Demo", "Correct");
            return 0;
        }
    };

    private void updateUI(int result) {
        switch (result) {
            case 0: responseGuess.setText("You have found the number!"); break;
            case 1: responseGuess.setText("Number is too Low"); break;
            case 2: responseGuess.setText("Number is too High"); break;
            case 3:
//                headerGuess.setText("Guess Number!");
                responseGuess.setText("Please guess number");
                editGuess.setText("");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        headerGuess = findViewById(R.id.header_guess);
        responseGuess = findViewById(R.id.response_guess);
        editGuess = findViewById(R.id.edit_guess);
        buttonGuess = findViewById(R.id.button_guess);
        buttonReset = findViewById(R.id.button_reset);

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int content = Integer.parseInt(editGuess.getText().toString());
                Log.i("Demo", String.valueOf(content));
                int result = checkGuess(content);
                updateUI(result);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI(3);
            }
        });
    }
}