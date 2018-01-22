package com.example.cisar.munstagram.vista;

//import android.app.Fragment;
//import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.app.FragmentTransaction;
//import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.cisar.munstagram.R;
import com.example.cisar.munstagram.vista.fragment.HomeFragment;
import com.example.cisar.munstagram.vista.fragment.ProfileFragment;
import com.example.cisar.munstagram.vista.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

// Este activity se utiliza para determinar las acciones dentro de la actividad principal al ingresar a la aplicacion. Luego de LOGIN
public class ContainerActivity extends AppCompatActivity {


   // Intent intent = getIntent();
   // String message = intent.getStringExtra(MyActivity.EXTRA_MESSAGE);
   // TextView textView = new TextView(this);
   // textView.setTextSize(40);
   // textView.setText(message);
//
   // RelativeLayout layout = (RelativeLayout) findViewById(R.id.rl_Container);
   // layout.addView(textView);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        // Aca declaramos el bottombar
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        // Declaramos el TAB que estara seleccionado por default
        bottomBar.setDefaultTab(R.id.tab_home);

        // Se declara una funcion que escuche los cambios en la botonera de abajo utilizando los metodos propios de la libreria, OnTaReselectListener
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, homeFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.tab_profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                    case R.id.tab_search:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, searchFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();
                        break;
                }
            }
        });
    }

  //  public void agregarFragment(Fragment fragment){
  //      if (null != fragment){
  //          getSupportFragmentManager()
  //                  .beginTransaction()
  //                  .replace(R.id.container, fragment)
  //                  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
  //                  .addToBackStack(null)
  //                  .commit();
  //      }
  //  }
}
