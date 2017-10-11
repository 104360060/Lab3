package com.example.user.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    int gamerMora = -1;
    String[] stringMora = {"剪刀", "石頭", "布"};

    EditText gamer;
    TextView status;
    Button play;

    RadioGroup radioGroup;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    TextView name;
    TextView winner;
    TextView myMora;
    TextView computerMora;


    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gamer = (EditText)findViewById(R.id.gamer);
        status = (TextView)findViewById(R.id.status);
        play = (Button)findViewById(R.id.play);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);

        name = (TextView)findViewById(R.id.name);
        winner = (TextView)findViewById(R.id.winner);
        myMora = (TextView)findViewById(R.id.myMora);
        computerMora = (TextView)findViewById(R.id.computerMora);






        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId)
            {
                switch (radioGroup.getCheckedRadioButtonId())
                {
                    case R.id.radioButton1:
                        gamerMora = 0;
                        break;
                    case R.id.radioButton2:
                        gamerMora = 1;
                        break;
                    case R.id.radioButton3:
                        gamerMora = 2;
                        break;
                }

            }
        });

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(gamer.getText().toString().equals(""))
                    status.setText("請選擇玩家名稱");
                else if(gamerMora == -1)
                    status.setText("請選擇出拳的種類");
                else
                {
                    name.setText(gamer.getText());
                    myMora.setText(stringMora[gamerMora]);

                    int mora_computer = (int)(Math.random() * 3);
                    computerMora.setText(stringMora[mora_computer]);

                    if((mora_computer == 0 && gamerMora == 2) || (mora_computer == 1 && gamerMora == 0) || (mora_computer == 2 && gamerMora == 1))
                    {
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    }
                    else if((mora_computer == gamerMora))
                    {
                        winner.setText("平局");
                        status.setText("平局！再試一場看看");
                    }
                    else
                    {
                        winner.setText(gamer.getText());
                        status.setText("恭喜你獲勝了");
                    }
                }
            }
        });
    }
}
