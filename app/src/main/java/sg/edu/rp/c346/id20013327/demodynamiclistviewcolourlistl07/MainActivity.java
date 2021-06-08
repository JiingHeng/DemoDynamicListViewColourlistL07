package sg.edu.rp.c346.id20013327.demodynamiclistviewcolourlistl07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement,etIndex;
    Button btnAdd, btnRemove, btnUpdate;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        btnRemove = findViewById(R.id.buttonRemoveItem);
        btnUpdate = findViewById(R.id.buttonUpdate);
        etIndex = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<String>();
        //add
        alColours.add("Red");
        alColours.add("Orange");

        aaColour = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());
                alColours.add(index, colour);
                aaColour.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colour = alColours.get(position);
                Toast.makeText(MainActivity.this, colour,Toast.LENGTH_LONG).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                String index = etIndex.getText().toString();
                if(colour.isEmpty() == false && index.isEmpty() == false) {
                    alColours.set(Integer.parseInt(index), colour);
                    aaColour.notifyDataSetChanged();
                } else if(colour.isEmpty() == false && index.isEmpty() == true) {
                    Toast.makeText(MainActivity.this, "Please put in the index", Toast.LENGTH_LONG).show();
                } else if (colour.isEmpty() == true && index.isEmpty() == false) {
                    Toast.makeText(MainActivity.this, "Please put in the colour", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Please put in the index and the colour", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String colour = etElement.getText().toString();
                int index = Integer.parseInt(etIndex.getText().toString());
                if(colour.isEmpty() == false) {
                    if (aaColour.getCount() > index) {
                        alColours.remove(index);
                    }
                    aaColour.notifyDataSetChanged();
                    etElement.setText("");
                }                 
            }
        });

    }
}