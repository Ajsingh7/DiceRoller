package com.example.cs18aas2.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import static android.R.id.input;
import static com.example.cs18aas2.diceroller.R.id.numberTextView;

public class MainActivity extends AppCompatActivity {

    private int points = 0;
    private TextView pointview;
    private EditText input;
    private TextView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.ui);
        pointview = (TextView) findViewById(R.id.pview);
        lview = (TextView) findViewById(R.id.listview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void on_button_click(View view){

        TextView tv = (TextView) this.findViewById(numberTextView);



        Random r = new Random();

        int number = r.nextInt(6) + 1;



        tv.setText(Integer.toString(number));



        int n = Integer.parseInt(input.getText().toString());



        if (n < 1 || n > 6) {

            Toast.makeText(this, "numbers must be between 1 and 6", Toast.LENGTH_SHORT).show();

        } else if (n == number) {

            Toast.makeText(this, "Congratulations !", Toast.LENGTH_SHORT).show();

            points = points + 1;

            pointview.setText(Integer.toString(points));

        }

    }

    public void on_butoon_click2(View view){



        ArrayList<String> list = new ArrayList<>();

        list.add("1) If you could go anywhere in the world, where would you go?");

        list.add("2) If you were stranded on a desert island, what three things would you want to take with you?");

        list.add("3) If you could eat only one food for the rest of your life, what would that be?");

        list.add("4) If you won a million dollars, what is the first thing you would buy?");

        list.add("5) If you could spaned the day with one fictional character, who would it be?");

        list.add("6) If you found a magic lantern and a genie gave you three wishes, what would you wish?");



        Random rand = new Random();



        int elements = 1;



        for (int i = 0; i < elements; i++) {



            int ri = rand.nextInt(list.size());

            String randelement = list.get(ri);

            lview.setText(randelement);

        }

    }


}
