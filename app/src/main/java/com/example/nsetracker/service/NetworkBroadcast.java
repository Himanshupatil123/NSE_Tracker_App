package com.example.nsetracker.service;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.nsetracker.R;
import com.example.nsetracker.callBackListener;

public class NetworkBroadcast extends BroadcastReceiver {

    AlertDialog.Builder builder;
    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;
    boolean flag=false;

    Dialog dialog;
    public callBackListener listener;

    public NetworkBroadcast(callBackListener listener) {
        this.listener=listener;

    }

    @Override
    public void onReceive(Context context, Intent intent) {


        if(!isConnected(context) && (dialog==null || (dialog!=null && !dialog.isShowing())))
        {
             builder=new AlertDialog.Builder(context);
            //LayoutInflater inflater=LayoutInflater.from(context);
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view =inflater.inflate(R.layout.no_internet_connection,null);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button=view.findViewById(R.id.button);
            builder.setView(view);
            builder.setCancelable(false);
            dialog=builder.create();
            dialog.show();


            button.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                   if(isConnected(context))
                   {
                      button.setBackgroundColor(R.color.gray);
                      dialog.dismiss();
                   }

                }
            });



        }
        /*dialog!=null*/
         if(isConnected(context) /*&&dialog!=null && dialog.isShowing()*/)
        {
            if(dialog!=null && dialog.isShowing())
                dialog.dismiss();



            Runnable r1=new Runnable() {
                @Override
                public void run() {

                    if(dialog!=null && dialog.isShowing())
                        dialog.dismiss();
            //        Log.d("Aero","Aeroplanhe R1");
                    listener.connectionLost(true);
                    try {
                        String netsubtype=String.valueOf(networkInfo.getSubtype());
                        Thread.sleep(2000);
                        listener.connectionLost(false);
                        if (netsubtype != null && (netsubtype.equals("" + TelephonyManager.NETWORK_TYPE_GPRS) || netsubtype.equals("" + TelephonyManager.NETWORK_TYPE_EDGE) || netsubtype.equals("" + TelephonyManager.NETWORK_TYPE_1xRTT)))
                            listener.connectionSpeed(true);
                        else listener.connectionSpeed(false);

                    } catch (InterruptedException e) {

                    }
                }
            };

            Thread threadconn=new Thread(r1);
            threadconn.start();

        }

}

    public boolean isConnected(Context context)
    {
        try{
            connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            networkInfo=connectivityManager.getActiveNetworkInfo();

            if(networkInfo==null)
            {
                return false;
            }
            else
            {
                return networkInfo.isConnected();
            }

        }
        catch(Exception e)
        {
            //e.printStackTrace();
            return false;
        }

    }



}

