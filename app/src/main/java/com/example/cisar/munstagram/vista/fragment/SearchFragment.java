package com.example.cisar.munstagram.vista.fragment;


import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
//import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cisar.munstagram.R;
import com.example.cisar.munstagram.adapter.PictureAdapterRecyclerView;
import com.example.cisar.munstagram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View drawer =  inflater.inflate(R.layout.fragment_search, container, false);
        showToolbar("", false, drawer);

        // Desde aqui los componentes de RecyvlerView para reutilizar en los demas fragments
        RecyclerView picturesRecycler = (RecyclerView) drawer.findViewById(R.id.pictureRecycler);

        // Implementacion aparte. Personalizacion de espaciado en items dentro del recyclerview
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.xxspacing);
        picturesRecycler.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        // fin espaciado interno de recycler view


//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2, GridLayoutManager.VERTICAL, false);

        picturesRecycler.setLayoutManager(gridLayoutManager); // el linearLayoutManager declarado tiene la informacion de la tarjeta y su orientacion
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures() ,R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return drawer;
     // original   return inflater.inflate(R.layout.fragment_search, container, false);
    }
    public ArrayList<Picture> buildPictures (){ // facilitar la obtencion de los array con este metodo
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

    // Implementacion complementaria. Personalizacion
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }
}
