package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    boolean active=true;
    //0-X
    //1-O
    int curr=0;
    int[] grid={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    String strx="Reset";
    int[][] winposn={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void buttonclick(View view)
    {

        TextView button=findViewById(R.id.button);
        button.setText(strx);
        reset(view);
        active=true;
        curr=0;
    }
    public void click(View view)
    {
        ImageView img=(ImageView) view;
        int tappedImg= Integer.parseInt(img.getTag().toString());
        if(!active)
        {
            reset(view);
        }
        if(grid[tappedImg]==-1)
        {
            grid[tappedImg]=curr;
            img.setTranslationY(-1000f);
            if(curr==0)
            {
                img.setImageResource(R.drawable.img_2);
                curr=1;
                TextView status=findViewById(R.id.status);
                status.setText("O's Turn:");
            }
            else
            {
                img.setImageResource(R.drawable.img_1);
                curr=0;
                TextView status=findViewById(R.id.status);
                status.setText("X's Turn:");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winpos: winposn)
        {
            if(grid[winpos[0]]==grid[winpos[1]] && grid[winpos[1]]==grid[winpos[2]] && grid[winpos[0]]!=-1)
            {
                String winstr;
                active=false;
                if(grid[winpos[0]]==0)
                {
                    winstr="X won the game";
                }
                else
                {
                    winstr="O won the game";
                }
                TextView status=findViewById(R.id.status);
                status.setText(winstr);
            }
        }
    }
    public  void reset(View view)
    {
        //active=true;
        //curr=0;
        for(int i=0;i< grid.length;i++)
        {
            grid[i]=-1;
        }
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView15)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView17)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView18)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView19)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView20)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView21)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView22)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("X's Turn:");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}