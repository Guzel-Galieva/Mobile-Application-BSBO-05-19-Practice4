package ru.mirea.galieva.looper;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.logging.Handler;

public class MyLooper extends Thread{
    private int number = 0;
    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("Name: Galieva Guzel", 20 + "sec:"+ msg.getData().getString("KEY"));
                number++;
            }
        };
        Looper.loop();
    }
}
