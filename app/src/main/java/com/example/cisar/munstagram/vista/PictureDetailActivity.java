package com.example.cisar.munstagram.vista;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.View;
import android.view.WindowManager;

import com.example.cisar.munstagram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar( "" , true );

        // Definiendo una transicion de entrada por defecto para los casos donde la version de android es menor a 5
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {

            getWindow().setEnterTransition(new Fade());
        }

    }

    public void showToolbar(String titulo, boolean upButton){ // se agrega VIEW porque es un fragment, no una actividad. Sin esto no funcionaria findViewById. Pero instanciado se lo puede llamar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //((AppCompatActivity) getActivity()) soporte del toolbar
        getSupportActionBar().setTitle(titulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }
}

