package com.example.cisar.munstagram.vista.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
//import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cisar.munstagram.R;
import com.example.cisar.munstagram.adapter.PictureAdapterRecyclerView;
import com.example.cisar.munstagram.model.Picture;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View drawer =  inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home), false, drawer); // Home es una variables de string, false es para que no muestra el boton debug, drawer es el objeto inflado para que entienda android


       // Desde aqui los componentes recycler que se reutilizan para los demas fragments
        RecyclerView picturesRecycler = (RecyclerView) drawer.findViewById(R.id.pictureRecycler);

        //RecyclerView pictureRecycler = (RecyclerView) drawer.findViewById(android.R.id.list);

        //      final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        //      layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //      recyclerView.setLayoutManager(layoutManager);
        // zona azul, darle forma
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // produce una lista vertical.
       // pictureRecycler.setLayoutManager(linearLayoutManager);

        picturesRecycler.setLayoutManager(linearLayoutManager); // el linearLayoutManager declarado tiene la informacion de la tarjeta y su orientacion

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures() ,R.layout.cardview_picture, getActivity());

        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return drawer;
    }

    public ArrayList<Picture> buidPictures (){ // facilitar la obtencion de los array con este metodo
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://lajornadasanluis.com.mx/wp-content/uploads/2017/04/agujero.jpg", "Isaias Silva", "4 dias", "3 Me gusta"));
        pictures.add(new Picture("http://deimagen.mx/wp-content/uploads/2011/07/Imagen-Personal.jpg", "Cecilia Salgado", "2 dias", "9 Me gusta"));
        pictures.add(new Picture("http://www.changethethought.com/wp-content/firmoramaupdate.jpg", "Andy Gutierrez", "1 dias", "6 Me gusta"));

        return pictures;
    }

    public void showToolbar(String titulo, boolean upButton, View view){ // se agrega VIEW porque es un fragment, no una actividad. Sin esto no funcionaria findViewById. Pero instanciado se lo puede llamar
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar); //((AppCompatActivity) getActivity()) soporte del toolbar
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
