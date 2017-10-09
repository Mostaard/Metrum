package be.mosterd.metrum.model;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;

import be.mosterd.metrum.R;

/**
 * Created by jonas on 9/10/2017.
 */

public class Metronome {

    private TimeSignature timeSignature;
    private int tempo;
    private int delay;
    private boolean isRunning;
    private Context context;


    private static final int MILISEC_IN_MINUTE = 60_000;

    public Metronome(Context context){
        this.timeSignature = new TimeSignature(4, 4);
        this.context = context;
        tempo = 60;
        delay = MILISEC_IN_MINUTE / tempo;
    }

    public void start(){
        isRunning = true;
        metronomeRunnable.run();
    }

    public void stop(){
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public TimeSignature getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(TimeSignature timeSignature) {
        this.timeSignature = timeSignature;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    public int getDelay() {
        return delay;
    }

    private void playSound(){
        MediaPlayer mPlayer = MediaPlayer.create(context, R.raw.geiger);
        mPlayer.start();

    }

    private Runnable metronomeRunnable = new Runnable() {
        @Override
        public void run() {
            while(isRunning){
                playSound();
                try {
                    Thread.sleep(getDelay());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    };
}
