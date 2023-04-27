package com.example.speechapp;


//import static com.example.recyclerview.R.raw.yes;

import static com.example.speechapp.R.color.black;
import static com.example.speechapp.R.color.lightblue;
import static com.example.speechapp.R.color.lightgrey;
import static com.example.speechapp.R.color.purple_200;
import static com.example.speechapp.R.color.purple_500;
import static com.example.speechapp.R.color.white;
import static com.example.speechapp.R.layout.card_design;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    ArrayList<Data> data;
    MediaPlayer mediaPlayer ;

    RecycleAdapter(ArrayList<Data> data)
    {
        this.data = data;
    }


    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(card_design,parent,false);
        ViewHolder viewholder=new ViewHolder(view);
        return viewholder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder,int position) {
        holder.img.setImageResource(data.get(position).img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                if(position==0){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.yes);
                    mediaPlayer.start();

                }
                if(position==1){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.no);
                    mediaPlayer.start();
                }
                if(position==2){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.help);
                    mediaPlayer.start();
                }
                if(position==3){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.please);
                    mediaPlayer.start();
                }
                if(position==4){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.sorry);
                    mediaPlayer.start();
                }
                if(position==5){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.thank_you);
                    mediaPlayer.start();
                }
                if(position==6){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.stop);
                    mediaPlayer.start();
                }
                if(position==7){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.you_r_welcome);
                    mediaPlayer.start();
                }
                if(position==8){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.friends);
                    mediaPlayer.start();
                }
                if(position==9){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.time);
                    mediaPlayer.start();
                }
                if(position==10){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.believe);
                    mediaPlayer.start();
                }if(position==11){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.eat);
                    mediaPlayer.start();
                }if(position==12){
                    mediaPlayer=MediaPlayer.create(view.getContext(), R.raw.water);
                    mediaPlayer.start();
                }
            }
        });

//        holder.num.setText(data.get(position).num);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;

        //        TextView num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.image);

        }
    }
}
