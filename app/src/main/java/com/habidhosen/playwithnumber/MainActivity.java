package com.habidhosen.playwithnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*declare variable*/
    private EditText editText;
    private Button checkBtn;
    private TextView result1, result2;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*hide title bar*/
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        /*finding all variable*/
        editText = findViewById(R.id.editTextId);
        checkBtn = findViewById(R.id.checkBtnId);
        result1 = findViewById(R.id.result1TextViewId);
        result2 = findViewById(R.id.result2TextViewId);
        image = findViewById(R.id.imageViewId);

        /*check button listener*/
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //getting EditText number
                String guessNumberString = editText.getText().toString();


                /*condition check*/
                if (guessNumberString.isEmpty()){
                    editText.setError("Enter value");
                }

                else{
                    //EditText guess number convert to integer number
                    int guessNumber = Integer.parseInt(guessNumberString);

                    //if guess number is greater than 10
                    if (guessNumber > 10){
                        //show Toast message
                        Toast.makeText(MainActivity.this, "Enter a number between 1 to 10", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        //generate random number
                        Random random = new Random();
                        int randomNumber = random.nextInt(10)+1;

                        if (randomNumber == guessNumber){
                            //result show
                            result1.setText("Congratulations!");
                            result2.setText("You have won");
                            //image show
                            image.setImageResource(R.drawable.ic_win);
                        }
                        else {
                            //result show
                            result1.setText("Try again!");
                            result2.setText("Random number was : "+randomNumber);
                            //image show
                            image.setImageResource(R.drawable.ic_lose);
                        }
                    }
                }
            }
        });
    }
}