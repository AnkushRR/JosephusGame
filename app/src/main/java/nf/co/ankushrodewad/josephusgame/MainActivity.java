package nf.co.ankushrodewad.josephusgame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.icu.text.DisplayContext.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int[] ids= new int[46];

            ids[1]=R.id.imageView1;
            ids[2]=R.id.imageView2;
            ids[3]=R.id.imageView3;
            ids[4]=R.id.imageView4;
            ids[5]=R.id.imageView5;
            ids[6]=R.id.imageView6;
        ids[7]=R.id.imageView7;
        ids[8]=R.id.imageView8;
        ids[9]=R.id.imageView9;
        ids[10]=R.id.imageView10;
        ids[11]=R.id.imageView11;
        ids[12]=R.id.imageView12;
        ids[13]=R.id.imageView13;
        ids[14]=R.id.imageView14;
        ids[15]=R.id.imageView15;
        ids[16]=R.id.imageView16;
        ids[17]=R.id.imageView17;
        ids[18]=R.id.imageView18;
        ids[19]=R.id.imageView19;
        ids[20]=R.id.imageView20;
        ids[21]=R.id.imageView21;
        ids[22]=R.id.imageView22;
        ids[23]=R.id.imageView23;
        ids[24]=R.id.imageView24;
        ids[25]=R.id.imageView25;
        ids[26]=R.id.imageView26;
        ids[27]=R.id.imageView27;
        ids[28]=R.id.imageView28;
        ids[29]=R.id.imageView29;
        ids[30]=R.id.imageView30;
        ids[31]=R.id.imageView31;
        ids[32]=R.id.imageView32;
        ids[33]=R.id.imageView33;
        ids[34]=R.id.imageView34;
        ids[35]=R.id.imageView35;
        ids[36]=R.id.imageView36;
        ids[37]=R.id.imageView37;
        ids[38]=R.id.imageView38;
        ids[39]=R.id.imageView39;
        ids[40]=R.id.imageView40;
        ids[41]=R.id.imageView41;
        ids[42]=R.id.imageView42;
        ids[43]=R.id.imageView43;
        ids[44]=R.id.imageView44;
        ids[45]=R.id.imageView45;
        final TextView textView = findViewById(R.id.t1);
        textView.setText("Player 1's turn");


        final int[] id = {0};
        final boolean[] is_blue = new boolean[46];
        final int[] values = new int[46];
        for(int i=0; i<46; i++)
            is_blue[i]=false;
        for(int i=1; i<46; i++){
            TextView textView1 = findViewById(ids[i]);
            textView1.setBackgroundResource(R.mipmap.ic_launcher_round);
        }
        final Button b1 = (Button) findViewById(R.id.button);
        final Button b2 = findViewById(R.id.button2);
        final Button b3 = findViewById(R.id.button3);
        final Button b4 = findViewById(R.id.button4);
        final int[] p1_score = {0};
        final int[] p2_score={0};

        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                int rand = generate_random();
                id[0]++;
                if(id[0]<46) {
                    Log.v("The id was: ", "" + id[0]);
                    textView.setText("Player 2's turn");
                    TextView t = (TextView) findViewById(ids[id[0]]);
                    int i = R.raw.iu;
                    if (!is_blue[id[0]]) {
                        t.setBackgroundResource(i);
                        is_blue[id[0]] = true;
                        t.setText("" + rand);
                        p1_score[0] +=rand;
                    }
                }else{
                    textView.setText("It's results Time!!!");
                    b1.setVisibility(View.GONE);
                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.VISIBLE);
                }


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View view) {
                int rand = generate_random();
                id[0]++;
                if(id[0]<46) {
                    Log.v("The id was: ", "" + id[0]);
                    textView.setText("Player 1's turn");
                    TextView t = (TextView) findViewById(ids[id[0]]);
                    int i = R.raw.iu2;
                    if (!is_blue[id[0]]) {
                        t.setBackgroundResource(i);
                        is_blue[id[0]] = true;
                        t.setText("" + rand);
                        p2_score[0]+=rand;
                    }
                }else{
                    textView.setText("It's results Time!!!");
                    b1.setVisibility(View.GONE);
                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.VISIBLE);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Player 1 score is: ", ""+p1_score[0]);
                Log.v("player 2 score is: ", ""+p2_score[0]);
                if(p1_score[0]>p2_score[0])
                    textView.setText("Player 1 Wins by "+(p1_score[0]-p2_score[0]+" points"));
                else if(p2_score[0]>p1_score[0])
                    textView.setText("Player 2 Wins by "+(p2_score[0]-p1_score[0])+" points");
                else
                    textView.setText("It's a Draw");
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, "Designed and Developed by Ankush Rodewad", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1_score[0]=0;p2_score[0]=0;
                for(int i=0; i<46; i++)
                    is_blue[i]=false;
                for(int i=1; i<46; i++){
                    TextView textView1 = findViewById(ids[i]);
                    textView1.setBackgroundResource(R.mipmap.ic_launcher_round);
                    textView1.setText("");
                    id[0]=0;
                }
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.GONE);
                textView.setText("Player 1's turn");
            }
        });


    }
    public int generate_random(){
        Random rand = new Random();
        int i= rand.nextInt(6);
        i++;
        return i;
    }
    public String setString(int i){
        String str = new String();
        str="imageView"+i;
        return str;
    }

    public void setBox(int k){

    }
}
