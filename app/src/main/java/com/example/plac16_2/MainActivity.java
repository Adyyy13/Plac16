package com.example.plac16_2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Fragment mfragment=null;
        Class fragmentClass;
        switch (item.getItemId()) {
            case R.id.StronaGlowna: {
                fragmentClass = StronaGlowna.class;
                break;
            }
            case R.id.NaszeMenu: {
                fragmentClass = NaszeMenu.class;
                break;
            }
            case R.id.Galeria: {
                fragmentClass = Galeria.class;
                break;
            }
            case R.id.Praca: {
                fragmentClass = Praca.class;
                break;
            }
            case R.id.Opinie: {
                fragmentClass = Opinie.class;
                break;
            }
            default:
                fragmentClass = StronaGlowna.class;
        }
        try {
            mfragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        
        transaction.replace(R.id.fragment_container_view, mfragment, null);
                
        transaction.commit();
    return true;
    }



}
