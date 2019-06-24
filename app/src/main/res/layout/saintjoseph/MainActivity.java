package com.example.saintjoseph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.saintjoseph.R.id.action_settings;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  LinearLayout option1,option2,option3,option4,option5;
    private Toolbar toolbar;
    private TextView mTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mTitle=toolbar.findViewById(R.id.title);

        option1=(LinearLayout)findViewById(R.id.accueil);
        option2=(LinearLayout)findViewById(R.id.etab_sante);
        option3=(LinearLayout)findViewById(R.id.urgences);
        option4=(LinearLayout)findViewById(R.id.ambulances);
        option5=(LinearLayout)findViewById(R.id.plan);
        
       
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
        showFragment(new RechercheFragment());
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()){
            case action_settings:
                try {
                    mTitle.setText("Mentions Légales");
                    showFragment(Mentions_fragment.class.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }// Insert the fragment by replacing any existing fragment
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);


        }
        return super.onOptionsItemSelected(item);
    }


    public void ClickNavigation(View view){
        Fragment fragment = null;
        Class fragmentClass =  RechercheFragment.class;

        switch (view.getId()){
            case R.id.accueil:
                mTitle.setText("HPSJ ANNUAIRE");
                fragmentClass = RechercheFragment.class;
                option1.setBackgroundColor(Color.parseColor("#FA9A41"));
                option2.setBackgroundColor(Color.parseColor("#C4A580"));
                option3.setBackgroundColor(Color.parseColor("#455a64"));
                option4.setBackgroundColor(Color.parseColor("#6C5A38"));
                option5.setBackgroundColor(Color.parseColor("#264463"));
                break;
            case R.id.etab_sante:
                mTitle.setText("HPSJ ANNUAIRE");
                fragmentClass = RechercheFragment.class;
                option2.setBackgroundColor(Color.parseColor("#FA9A41"));
                option1.setBackgroundColor(Color.parseColor("#141C34"));
                option3.setBackgroundColor(Color.parseColor("#455a64"));
                option4.setBackgroundColor(Color.parseColor("#6C5A38"));
                option5.setBackgroundColor(Color.parseColor("#264463"));
                break;
            case R.id.urgences:
                mTitle.setText("HPSJ ANNUAIRE");
                fragmentClass = RechercheFragment.class;
                option3.setBackgroundColor(Color.parseColor("#FA9A41"));
                option2.setBackgroundColor(Color.parseColor("#C4A580"));
                option1.setBackgroundColor(Color.parseColor("#141C34"));
                option4.setBackgroundColor(Color.parseColor("#6C5A38"));
                option5.setBackgroundColor(Color.parseColor("#264463"));

                break;
            case R.id.ambulances:
                mTitle.setText("HPSJ ANNUAIRE");
                fragmentClass = RechercheFragment.class;
                option4.setBackgroundColor(Color.parseColor("#FA9A41"));
                option1.setBackgroundColor(Color.parseColor("#141C34"));
                option2.setBackgroundColor(Color.parseColor("#C4A580"));
                option3.setBackgroundColor(Color.parseColor("#455a64"));
                option5.setBackgroundColor(Color.parseColor("#264463"));

                break;
            case R.id.plan:
                mTitle.setText("PLAN HPSJ");
                fragmentClass = PlanFragment.class;
                option5.setBackgroundColor(Color.parseColor("#FA9A41"));
                option4.setBackgroundColor(Color.parseColor("#6C5A38"));
                option1.setBackgroundColor(Color.parseColor("#141C34"));
                option2.setBackgroundColor(Color.parseColor("#C4A580"));
                option3.setBackgroundColor(Color.parseColor("#455a64"));

                break;
        }
        try {
            showFragment((Fragment) fragmentClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }// Insert the fragment by replacing any existing fragment
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_main, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }
}
