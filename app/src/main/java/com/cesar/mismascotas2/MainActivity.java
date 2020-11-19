
package com.cesar.mismascotas2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cesar.mismascotas2.activitys.ActivityContacto;
import com.cesar.mismascotas2.activitys.MisFavoritos;
import com.cesar.mismascotas2.adaptador.ViewPagerAdaptador;
import com.cesar.mismascotas2.fragments.Dogfilefragment;
import com.cesar.mismascotas2.fragments.RecyclerViewfragment;
import com.cesar.mismascotas2.activitys.ActivityAcercade;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        setUpViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, ActivityContacto.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcerca:
                Intent intentAcerca = new Intent(this, ActivityAcercade.class);
                startActivity(intentAcerca);
                break;
            case R.id.mFavoritos:
                Intent intentConfig = new Intent(this, MisFavoritos.class);
                startActivity(intentConfig);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments= new ArrayList<>();
        fragments.add(new RecyclerViewfragment());
        fragments.add(new Dogfilefragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new ViewPagerAdaptador(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_home_24_9);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_dog_26_9);
    }

}