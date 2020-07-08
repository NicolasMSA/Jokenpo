package com.example.jokenpo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.Random;


public class JogoService implements Runnable {

    Context context;
    Activity activity;
    int contUser = 0;
    int contComp = 0;

    public JogoService(Context context) {
        this.context = context;
        this.activity = ((Activity) context);
    }

    @Override
    public void run() {
        int escolhaUser = new Random().nextInt(3) + 1;

        if (escolhaUser == 1) {
            activity.findViewById(R.id.imageUser).setBackgroundResource(R.drawable.papel);
        } else if (escolhaUser == 2) {
            activity.findViewById(R.id.imageUser).setBackgroundResource(R.drawable.pedra);
        } else if (escolhaUser == 3) {
            activity.findViewById(R.id.imageUser).setBackgroundResource(R.drawable.tesoura);
        }

        int escolhaComp = new Random().nextInt(3) + 1;

        if (escolhaComp == 1) {
            activity.findViewById(R.id.imageComp).setBackgroundResource(R.drawable.papel);
        } else if (escolhaComp == 2) {
            activity.findViewById(R.id.imageComp).setBackgroundResource(R.drawable.pedra);
        } else if (escolhaComp == 3) {
            activity.findViewById(R.id.imageComp).setBackgroundResource(R.drawable.tesoura);
        }


        if (escolhaUser == escolhaComp) {

        } else if (escolhaUser == 3 && escolhaComp == 2) {
            contComp++;
        } else if (escolhaUser == 1 && escolhaComp == 3) {
            contComp++;
        } else if (escolhaUser == 2 && escolhaComp == 1) {
            contComp++;
        } else {
            contUser++;
        }

        if (contComp == 1) {
            activity.findViewById(R.id.placar1Comp).setBackgroundResource(R.drawable.trofeu);
        } else if (contComp == 2) {
           activity.findViewById(R.id.placar1Comp).setBackgroundResource(R.drawable.trofeu);
           activity.findViewById(R.id.placar2Comp).setBackgroundResource(R.drawable.trofeu);

        } else if (contComp == 3) {
            activity.findViewById(R.id.placar1Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3Comp).setBackgroundResource(R.drawable.trofeu);
        } else if (contComp == 4) {
            activity.findViewById(R.id.placar1Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar4Comp).setBackgroundResource(R.drawable.trofeu);

        } else if (contComp == 5) {
            activity.findViewById(R.id.placar1Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar4Comp).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar5Comp).setBackgroundResource(R.drawable.trofeu);

            Intent intent = new Intent(context, UserLost.class);
            activity.startActivity(intent);

        }if (contUser == 1)
            activity.findViewById(R.id.placar1User).setBackgroundResource(R.drawable.trofeu);
        else if (contUser == 2) {
            activity.findViewById(R.id.placar1User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2User).setBackgroundResource(R.drawable.trofeu);
        } else if (contUser == 3) {
            activity.findViewById(R.id.placar1User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3User).setBackgroundResource(R.drawable.trofeu);
        } else if (contUser == 4) {
            activity.findViewById(R.id.placar1User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar4User).setBackgroundResource(R.drawable.trofeu);

        } else if (contUser == 5) {
            activity.findViewById(R.id.placar1User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar2User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar3User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar4User).setBackgroundResource(R.drawable.trofeu);
            activity.findViewById(R.id.placar5User).setBackgroundResource(R.drawable.trofeu);

            Intent intent = new Intent(context, UserWon.class);
            activity.startActivity(intent);
        }
    }
}