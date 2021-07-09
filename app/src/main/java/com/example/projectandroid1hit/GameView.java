package com.example.projectandroid1hit;

import android.content.Context;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{
    public GameView(Context context) {
        super(context);
    }

    private Thread thread;
    private boolean isPlaying;

    @Override
    public void run() {

        while (isPlaying){
            update();
            drew();
            sleep();
        }
    }

    private void update(){


    }
    private void drew(){


    }
    private void sleep(){


    }


    public void resume() { //resume or start the game

        isPlaying = true;
        thread = new Thread(this);
        thread.start(); // start the run function
    }
    public void pause (){ //pause the game

        try {       // stop the thread
            isPlaying = false;
            thread.join();
        }    catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}

