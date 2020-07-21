package com.example.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String li[][];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        try {
            final Resources resources = this.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.mock);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            ArrayList<String> lines = new ArrayList<String>();
            while ((line = br.readLine()) != null)
            {
                lines.add(line);
            }

            br.close();

            int size=lines.size();
             li=new String[size][6];
            int i=0;
            for(String s:lines)
            {
                String a[]=s.split(",");
                for(int j=0;j<6;j++)
                {
                    li[i][j]=a[j];
                }
                i++;
            }

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;
        String g;
        double lat,log;
        for(int m=1;m<li.length;m++)
        {
            g=li[m][3];
            lat= Double.parseDouble(li[m][4]);
            log= Double.parseDouble(li[m][5]);

            LatLng uttarakhand = new LatLng(lat, log);
            if(g.equals("Female"))
            {
                mMap.addMarker(new MarkerOptions().position(uttarakhand).title(li[m][1]+"("+g+")").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

            }
            else if(g.equals("Male"))
            {
                mMap.addMarker(new MarkerOptions().position(uttarakhand).title(li[m][1]+"("+g+")").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }

            mMap.moveCamera(CameraUpdateFactory.newLatLng(uttarakhand));

        }

    }
}