package mobilecodecamp.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


public class GreetActivity extends Activity implements AdapterView.OnItemSelectedListener {

    private View greetView;

    private Spinner colorDropdown;

    private int blue;
    private int green;
    private int white;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Intialize color values
        blue = getResources().getColor(android.R.color.holo_blue_light);
        green = getResources().getColor(android.R.color.holo_green_light);
        white = getResources().getColor(android.R.color.background_light);

        setContentView(R.layout.activity_greet);
        greetView = getWindow().getDecorView().getRootView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView greetingText = (TextView) findViewById(R.id.greeting_text);
        greetingText.setText("Welcome " + name + "!!!");

        colorDropdown = (Spinner) findViewById(R.id.color_dropdown);

        colorDropdown.setOnItemSelectedListener(this);

        // Set color choices from the res/strings.xml and set display options
        ArrayAdapter<CharSequence> colorChoices = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        colorChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorDropdown.setAdapter(colorChoices);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greet, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // Get the color selected by the user
        String selectedColor = colorDropdown.getSelectedItem().toString();

        // Change the background color of the activity.
        if (selectedColor.equals("White")) {
            greetView.setBackgroundColor(white);
        } else if (selectedColor.equals("Green")) {
            greetView.setBackgroundColor(green);
        } else if (selectedColor.equals("Blue")) {
            greetView.setBackgroundColor(blue);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        
    }


}
