package com.example.planets;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static MyCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //1--> AdapterView: a ListView
        listView=findViewById(R.id.listView);
        //2- Data Source: Arraylis<Planet>
        planetsArrayList=new ArrayList<>();
        Planet planet1=new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet2=new Planet("Mercury","0 Moon",R.drawable.mercury);
        Planet planet3=new Planet("Venus","0 Moon",R.drawable.venus);
        Planet planet4=new Planet("Mars","2 Moons",R.drawable.mars);
        Planet planet5=new Planet("Jupiter","79 Moons",R.drawable.jupiter);
        Planet planet6=new Planet("Saturn","89 Moons",R.drawable.saturn);
        Planet planet7=new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet planet8=new Planet("Neptune","14 Moons",R.drawable.neptune);
        planetsArrayList.add(planet1 );
        planetsArrayList.add(planet2 );
        planetsArrayList.add(planet3 );
        planetsArrayList.add(planet4 );
        planetsArrayList.add(planet5 );
        planetsArrayList.add(planet6 );
        planetsArrayList.add(planet7 );
        planetsArrayList.add(planet8 );

        //Adapter
        adapter=new MyCustomAdapter(planetsArrayList,getApplicationContext());
        listView.setAdapter(adapter);
    //Handling Click events
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this,
                        "Planet Name: "+ adapter.getItem(position).getPlanetName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}