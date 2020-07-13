package com.example.dan.Android_Chess;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Worker.MakeField();
    }

    public static String coor = "";
    public static Button lastButton;
    public static String last = "";
    public static boolean side=false;
    public static ChessFigure[][] Field;
    public static int color;
    public static ColorDrawable buttonColor;


    public void onMyButtonClick(View view) {
        Button button = (Button) findViewById(view.getId());
        TextView view1 = (TextView) findViewById(R.id.textView2);
        TextView view2 = (TextView) findViewById(R.id.textView4);
        if (coor.equals("")&&button.getText()!="") {
            coor = button.getHint().toString() + "-";
            last = button.getText().toString();
            lastButton = findViewById(view.getId());
            buttonColor = (ColorDrawable) button.getBackground();
            color= buttonColor.getColor();
            lastButton.setBackgroundColor(Color.GREEN);}
        else {
            coor = coor + button.getHint().toString();
            int flag = Worker.main();
                if(flag==0) {
                    Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show();}
                if(flag==1) {
                    if (button.getText().toString().equals("")) {
                        button.setText(last);
                        lastButton.setText("");
                        if (side) side = false;
                        else side = true;}
                    else {
                        if (side)
                            view1.setText(view1.getText().toString() + button.getText().toString());
                        else
                            view2.setText(view2.getText().toString() + button.getText().toString());

                            button.setText(last);
                            lastButton.setText("");
                        if (side) side = false;
                        else side = true;
                    }
                }
            if(flag==2) {Toast.makeText(this, "YOU WIN!!!", Toast.LENGTH_LONG).show();}
            lastButton.setBackgroundColor(color);
            coor = "";
            }

        }
    }