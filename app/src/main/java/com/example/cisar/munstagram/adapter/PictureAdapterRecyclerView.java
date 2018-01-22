package com.example.cisar.munstagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cisar.munstagram.R;
import com.example.cisar.munstagram.model.Picture;
import com.example.cisar.munstagram.vista.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by cisar on 15/9/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{

    private ArrayList<Picture> pictures;
    private int resource; // nuestro card view que hicimos pro separado
    private Activity activity; // para pasar como parametro la actividad de donde se esta pasando el parametro

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        // se trabajo con el array list de cada objeto
        final Picture picture = pictures.get(position); // position obtiene uno a uno los objetos.
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        // holder.pictureCard

        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard); // picture.getPicture es la url como "http://i.imgur.com/DvpvklR.png"

        // detectar cuando se hace click en la imagen
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                // Agregando transicion
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //1
                //    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //    activity.getWindow().setStatusBarColor(getResources().getColor(R.color.fondo_transparente));
                //2
                //    activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

                    Explode explode = new Explode(); // se crea el objeto para cambiar la duracion
                    explode.setDuration(1000); // 1 segundo
                    // si estuvieras en la actividad ya no tendrias que llamar al metodo activity sino simplemente utilizar this
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                }else{
                    activity.startActivity(intent);
                }
                // fin transicion

                //activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size(); // retorna el conteo de cuantas veces debe recorrer ese arreglo
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;


        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard        = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard  = (TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
