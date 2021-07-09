package com.example.projectandroid1hit;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;


public class GameView extends SurfaceView implements Runnable{
    public GameView(Context context) {
        super(context);
    }

    private Thread thread;
    private boolean isPlaying;
    private int screenX,screenY;
    private Background background1,background2; //2 background to mack the background move


    public GameView(Context context,int screenX,int screenY){
        super(context);

        this.screenX=screenX;
        this.screenY=screenY;

        background1= new Background(screenX, screenY, getResources());
        background2= new Background(screenX, screenY, getResources());

        background2.x = screenX;
    }

    @Override
    public void run() {

        while (isPlaying){
            update();
            drew();
            sleep();
        }
    }

    private void update(){
        background1.x -=10;     //movement to left by 10pix
        background2.x -=10;

        if (background1.x+background1.background.getWidth() < 0) {//if is off the screen
            background1.x=screenX;
        }
        if (background2.x+background2.background.getWidth() < 0) {//if is off the screen
            background2.x=screenX;
        }
    }
    private void drew(){
        if (getHolder().getSurface().isValid()){
            Canvas canvas= getHolder().lockCanvas();  //Returns the canvas displayed on the screen

        }

    }
    private void sleep(){
        try {
            Thread.sleep(17);
        }        catch (InterruptedException e){
            e.printStackTrace();
        }
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

