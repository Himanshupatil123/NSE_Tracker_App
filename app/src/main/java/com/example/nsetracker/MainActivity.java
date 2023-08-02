package com.example.nsetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.example.nsetracker.service.NetworkBroadcast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements callBackListener {

    RecyclerView recyclerView;
    SearchView searchView;

    Toolbar toolbar;
    TextView optionchain;

    Spinner spinner;

    Dialog dialog1;
    Dialog dialog2;

    ProgressBar pgbar;
    int oldspinnerpos=0;
    ArrayList<Model> list;
    ArrayList<String> dropdown;
    ArrayList<Model> pack;

    Thread t0,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

    HashMap<Integer,Boolean> map;
    int spinnerposition;
    // ArrayList<String> price;
    customAdapter adapter;
    boolean flag=true;

    BroadcastReceiver broadcastReceiver;

    ExecutorService executorService;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///*********************************************************


                pgbar=findViewById(R.id.progressbar);
                recyclerView=findViewById(R.id.recyclerView);
                searchView=findViewById(R.id.searchView);
                toolbar=(Toolbar) findViewById(R.id.toolbar);
                optionchain=findViewById(R.id.optionschain);
                spinner=findViewById(R.id.spinner);
                list=new ArrayList();
                map=new HashMap<>();

                dropdown=new ArrayList<String>();

                //setting layout manager to recycler view
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.supportsPredictiveItemAnimations();
                recyclerView.setLayoutManager(linearLayoutManager);




                //registering broadcast receiver
                broadcastReceiver=new NetworkBroadcast(this);
                registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));


                //Executor Services
                executorService= Executors.newSingleThreadExecutor();


                dropdown.add("Nifty 50");
                dropdown.add("Nifty Bank");
                dropdown.add("Nifty Auto");
                dropdown.add("Nifty FMCG");
                dropdown.add("Nifty IT");
                dropdown.add("Nifty Media");
                dropdown.add("Nifty Metal");
                dropdown.add("Nifty Infra");
                dropdown.add("Nifty Pharma");
                dropdown.add("Nifty Energy");
                dropdown.add("Nifty PSU Bank");


                ArrayAdapter<String> dropAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,dropdown);
                dropAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setSelection(0);
                spinner.setAdapter(dropAdapter);

                //setting values of hashmap
                for(int i=0;i<11;i++)
                {
                    map.putIfAbsent(i,false);
                }



                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        spinnerposition=position;
                        if(position==0)
                        {
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            }
                            if(t5!=null && t5.isAlive())
                            {
                                t5.interrupt();
                            } if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY 50",0);

                            Runnable runnable=new Runnable() {
                                @Override
                                public void run() {
                                    while(true)
                                    {
                                        Log.d("thread 1","thread 1");
                                        try {
                                            Thread.sleep(5000);
                                           setApi("NIFTY 50",0);
                                        } catch (InterruptedException e) {
                                            // throw new RuntimeException(e);
                                            t0.interrupt();
                                            break;
                                        }
                                    }
                                }
                            };


                            t0=new Thread(runnable);
                            t0.start();
                        }
                        else  if(position==1)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        } if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }
                            connectApi("NIFTY BANK",1);

                            Runnable runnable=new Runnable() {
                                @Override
                                public void run() {
                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 2");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 2");

                                            setApi("NIFTY BANK",1);

                                        } catch (InterruptedException e) {
                                            t1.interrupt();
                                            break;
                                        }
                                    }


                                }
                            };


                            t1=new Thread(runnable);
                            t1.start();


                        }
                        else   if(position==2)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            }if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        } if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY AUTO",2);


                                 Runnable runnable=new Runnable() {
                                @Override
                                public void run() {
                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 3");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 3");
                                            setApi("NIFTY AUTO",2);

                                        } catch (InterruptedException e) {
                                            t2.interrupt();
                                            break;
                                        }
                                    }


                                }
                            };

                            t2=new Thread(runnable);
                            t2.start();

                        }
                        else   if(position==3)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            }
                            if(t5!=null && t5.isAlive())
                            {
                                t5.interrupt();
                            } if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }
                            connectApi("NIFTY FMCG",3);

                            Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 4");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 4");
                                            setApi("NIFTY FMCG",3);
                                        } catch (InterruptedException e) {
                                            t3.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t3=new Thread(runnable);
                            t3.start();

                        }
                        else   if(position==4)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t5!=null && t5.isAlive())
                            {
                                t5.interrupt();
                            } if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY IT",4);


                            Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {

                                            Log.d("thread 1","thread 5");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 5");
                                           setApi("NIFTY IT",4);

                                        } catch (InterruptedException e) {
                                            t4.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t4=new Thread(runnable);
                            t4.start();

                        }
                        else   if(position==5)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            }
                            if(t6!=null && t6.isAlive())
                            {
                                t6.interrupt();
                            } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY MEDIA",5);
                                Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 6");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 6");
      //                                    if(finalBool)
                                            setApi("NIFTY MEDIA",5);


                                        } catch (InterruptedException e) {
                                            t5.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t5=new Thread(runnable);
                            t5.start();


                        }
                        else   if(position==6)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        }  if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY METAL",6);
                               Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 7");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 7");
          //                                if(finalBool)
                                            setApi("NIFTY METAL",6);

                                        } catch (InterruptedException e) {
                                           t6.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t6=new Thread(runnable);
                            t6.start();



                        }
                        else if(position==7)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        }  if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY INFRA",7);
                               Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 8");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 8");
                                            setApi("NIFTY INFRA",7);


                                        } catch (InterruptedException e) {
                                            t7.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t7=new Thread(runnable);
                            t7.start();


                        }
                        else   if(position==8)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        }  if(t6!=null && t6.isAlive())
                        {
                            t6.interrupt();
                        } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            } if(t10!=null && t10.isAlive())
                        {
                            t10.interrupt();
                        }

                            connectApi("NIFTY PHARMA",8);
                               Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 9");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 9");
                                            setApi("NIFTY PHARMA",8);


                                        } catch (InterruptedException e) {
                                            t8.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t8=new Thread(runnable);
                            t8.start();

                        }
                        else   if(position==9)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        }
                            if(t6!=null && t6.isAlive())
                            {
                                t6.interrupt();
                            } if(t7!=null && t7.isAlive())
                        {
                            t7.interrupt();
                        }
                            if(t8!=null && t8.isAlive())
                            {
                                t8.interrupt();
                            }
                            if(t10!=null && t10.isAlive())
                            {
                                t10.interrupt();
                            }

                            connectApi("NIFTY ENERGY",9);


                            Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 10");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 10");
                                            setApi("NIFTY ENERGY",9);

                                        } catch (InterruptedException e) {
                                            t9.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t9=new Thread(runnable);
                            t9.start();


                        }
                        else   if(position==10)
                        {
                            if(t0!=null && t0.isAlive())
                            {
                                t0.interrupt();
                            }
                            if(t1!=null && t1.isAlive())
                            {
                                t1.interrupt();
                            }
                            if(t2!=null && t2.isAlive())
                            {
                                t2.interrupt();
                            }
                            if(t3!=null && t3.isAlive())
                            {
                                t3.interrupt();
                            }
                            if(t4!=null && t4.isAlive())
                            {
                                t4.interrupt();
                            } if(t5!=null && t5.isAlive())
                        {
                            t5.interrupt();
                        }
                            if(t6!=null && t6.isAlive())
                            {
                                t6.interrupt();
                            }
                            if(t7!=null && t7.isAlive())
                            {
                                t7.interrupt();
                            } if(t8!=null && t8.isAlive())
                        {
                            t8.interrupt();
                        }
                            if(t9!=null && t9.isAlive())
                            {
                                t9.interrupt();
                            }

                            connectApi("NIFTY PSU BANK",10);
                                Runnable runnable=new Runnable() {
                                @Override
                                public void run() {

                                    while(true)
                                    {
                                        try {
                                            Log.d("thread 1","thread 11");
                                            Thread.sleep(5000);
                                            Log.d("thread 1","after connect api thread 11");
    //                                      if(finalBool)
                                            setApi("NIFTY PSU BANK",10);


                                        } catch (InterruptedException e) {
                                            t10.interrupt();
                                            break;
                                        }
                                    }

                                }
                            };

                            t10=new Thread(runnable);
                            t10.start();

                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });




                // price=new ArrayList<>();

                //setting toolbar
                setSupportActionBar(toolbar);

                optionchain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("opt","Options called");
                        openActivity();
                    }
                });


                dialog1=new Dialog(this,R.style.mydialog);
                dialog1.setContentView(R.layout.custom_toast);

                dialog2=new Dialog(this,R.style.mydialog2);
                dialog2.setContentView(R.layout.custom_toast2);



/*

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                while(true)
                {
                    try {
                        connectApi();
                        Thread.sleep(70000);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

    Thread t=new Thread(runnable);
    t.start();
*/

           adapter=new customAdapter(this,list);
           recyclerView.setAdapter(adapter);
           recyclerView.setHasFixedSize(true);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        //  adapter.getFilter().filter(newText);
                        pack=new ArrayList<Model>();
                        if(newText.length()>0)
                        {
                            for(int i=0;i<list.size();i++)
                            {
                                if(list.get(i).getNames().toLowerCase().contains(newText.toLowerCase()))
                                {
                                    Model model=new Model();
                                    model.setPrices(list.get(i).getPrices());
                                    model.setNames(list.get(i).getNames());
                                    model.setPrevclose(list.get(i).getPrevclose());
                                    model.setPerchange(list.get(i).getPerchange());
                                    model.setPricechange(list.get(i).getPricechange());
                                    pack.add(model);

                                }
                            }
                            adapter=new customAdapter(MainActivity.this,pack);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();
                        }
                        else
                        {
                            adapter=new customAdapter(MainActivity.this,list);
                            recyclerView.setAdapter(adapter);
                            adapter.notifyDataSetChanged();

                        }

                        return false;
                    }

                });


               /* recyclerView.se(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("hi","So high");
                        TextView tv=view.findViewById(R.id.nameTxtView);
                        String str=tv.getText().toString();
                        Intent i=new Intent(MainActivity.this, chartActivity.class);
                        i.putExtra("name",str);
                        startActivity(i);
                    }
                });
*/
              /*  recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        TextView tv=view.findViewById(R.id.nameTxtView);
                        String str=tv.getText().toString();
                        Intent i=new Intent(MainActivity.this, chartActivity.class);
                        i.putExtra("name",str);
                        startActivity(i);
                    }
                });*/


            }


            public void openActivity()
            {
                Intent intent=new Intent(this, option.class);
                //     Intent intent=new Intent(this,optActivity.class);
                startActivity(intent);
            }


            public void connectApi(String indices,int pos) {

                Log.d("connect","I am in connect");
                //**************************************************************************************************

  /*  list.clear();
        Log.d("visible spinner position",""+spinnerposition);
        Log.d("visible position",""+pos);

    if(spinnerposition!=oldspinnerpos)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("visible","Visibily of page loader");
                pgbar.setVisibility(View.VISIBLE);
            }
        });

    }


    //price.clear();
        String url = "https://latest-stock-price.p.rapidapi.com/price";

        AndroidNetworking.initialize(MainActivity.this);

        AndroidNetworking.get(url)
                .addQueryParameter("Indices", indices)
                .addHeaders("content-type", "application/octet-stream")
                .addHeaders("X-RapidAPI-Key", "e7ab830660msh9402983ba0488cdp1c17fajsn254504e26472")
                .addHeaders("X-RapidAPI-Host", "latest-stock-price.p.rapidapi.com")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @SuppressLint("SuspiciousIndentation")
                    @Override
                    public void onResponse(JSONArray response) {


                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);

                                if(object!=null)
                                {
                                    String stockname = object.getString("symbol");
                                    String stockprice = String.valueOf(object.getInt("lastPrice"));
                                    String stockchange = String.valueOf(object.getInt("change"));
                                    String stockperchange = String.valueOf(object.getString("pChange"));
                               //     Log.d("changes",stockperchange);
                                    String prevValue=String.valueOf(object.getInt("previousClose"));

                                //    Log.d("Stock", stockname);
                                //    Log.d("Stock", stockprice);
                                //    Log.d("Klist",String.valueOf(list));
                                    //list.add(stockname);
                                    // price.add(stockprice);
                                    Model model=new Model();
                                    model.setPrices(stockprice);
                                    model.setNames(stockname);
                                    model.setPrevclose(prevValue);
                                    double value=Integer.parseInt(stockchange);
                                    value=Math.round(value*Math.pow(10,2))/Math.pow(10,2);
                                    model.setPricechange(value+"");
                                    model.setPerchange(stockperchange);
                                    list.add(model);
                                    oldspinnerpos=pos;

                                 runOnUiThread(new Runnable() {
                                     @Override
                                     public void run() {
                                         if(list.size()==response.length())
                                         {
                                             adapter.notifyDataSetChanged();
                                             pgbar.setVisibility(View.GONE);
                                         }
                                     }
                                 });


                                }


                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }


                        }
                       // adapter.notifyDataSetChanged();
                    //    Log.d("List", "" + list);


                    }

                    @Override
                    public void onError(ANError anError) {

                        anError.printStackTrace();
                   //     Toast.makeText(getApplicationContext(), "Can't fetch data from API", Toast.LENGTH_LONG).show();
                        connectApi(indices, pos);

                    }
                });*/
//***************************************************************************************************************8

               executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        //background tasks
                       list.clear();
                              recyclerView.getRecycledViewPool().clear();
                              runOnUiThread(new Runnable() {
                                  @Override
                                  public void run() {
                                      adapter.notifyDataSetChanged();
                                  }
                              });



                        Log.d("Inconn","new connection method");


                        Log.d("myvisible spinner position",""+spinnerposition);
                        Log.d("myvisible position",""+pos);

                      /*  if(spinnerposition!=oldspinnerpos)
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("visible","Visibily of page loader");
                                    pgbar.setVisibility(View.VISIBLE);
                                }
                            });

                        }*/

                        ///

                        String url = "https://latest-stock-price.p.rapidapi.com/price";

                        AndroidNetworking.initialize(MainActivity.this);

                        AndroidNetworking.get(url)
                                .addQueryParameter("Indices", indices)
                                .addHeaders("content-type", "application/octet-stream")
                                .addHeaders("X-RapidAPI-Key", "e7ab830660msh9402983ba0488cdp1c17fajsn254504e26472")
                                .addHeaders("X-RapidAPI-Host", "latest-stock-price.p.rapidapi.com")
                                .setPriority(Priority.HIGH)
                                .build()
                                .getAsJSONArray(new JSONArrayRequestListener() {
                                    @SuppressLint("SuspiciousIndentation")
                                    @Override
                                    public void onResponse(JSONArray response) {


                                        for (int i = 0; i < response.length(); i++) {
                                            try {
                                                JSONObject object = response.getJSONObject(i);

                                                if(object!=null)
                                                {
                                                    String stockname = object.getString("symbol");
                                                    String stockprice = String.valueOf(object.getInt("lastPrice"));
                                                    String stockchange = String.valueOf(object.getInt("change"));
                                                    String stockperchange = String.valueOf(object.getString("pChange"));
                                                    //     Log.d("changes",stockperchange);
                                                    String prevValue=String.valueOf(object.getInt("previousClose"));
                                                    Model model=new Model();
                                                    model.setPrices(stockprice);
                                                    model.setNames(stockname);
                                                    model.setPrevclose(prevValue);
                                                    double value=Integer.parseInt(stockchange);
                                                    value=Math.round(value*Math.pow(10,2))/Math.pow(10,2);
                                                    model.setPricechange(value+"");
                                                    model.setPerchange(stockperchange);
                                                    list.add(model);
                                                    adapter.notifyItemInserted(i);


                                                   //  adapter.notifyDataSetChanged();
                                                    Log.d("mylist",""+stockname);
                                                    oldspinnerpos=pos;

                              /*                      runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            //on post method
                                                            Log.d("mylist","in post method");
                                                            adapter.notifyDataSetChanged();
                                                            pgbar.setVisibility(View.GONE);
                                                        }


                                                    });
*/

                                                }


                                            } catch (JSONException e) {
                                                throw new RuntimeException(e);
                                            }


                                        }

                                  //      recyclerView.getRecycledViewPool().clear();
                                    //    adapter.notifyDataSetChanged();


                                        Log.d("mylist",""+list);
                                        adapter.notifyDataSetChanged();

                                    }

                                    @Override
                                    public void onError(ANError anError) {

                                        anError.printStackTrace();
                                             Toast.makeText(getApplicationContext(), "Can't fetch data from API", Toast.LENGTH_LONG).show();

                                              recyclerView.getRecycledViewPool().clear();
                                            adapter.notifyDataSetChanged();

                                        connectApi(indices, pos);

                                    }
                                });

                        ///


                    }
                });

            }


       public void setApi(String indices,int pos)
            {



                        Log.d("thread 1","In set API");
                        Log.d("myvisible spinner position",""+spinnerposition);
                        Log.d("myvisible position",""+pos);

                        if(spinnerposition!=oldspinnerpos)
                        {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d("visible","Visibily of page loader");
                                    pgbar.setVisibility(View.VISIBLE);
                                }
                            });

                        }

                        ///

                        String url = "https://latest-stock-price.p.rapidapi.com/price";

                        AndroidNetworking.initialize(MainActivity.this);

                        AndroidNetworking.get(url)
                                .addQueryParameter("Indices", indices)
                                .addHeaders("content-type", "application/octet-stream")
                                .addHeaders("X-RapidAPI-Key", "e7ab830660msh9402983ba0488cdp1c17fajsn254504e26472")
                                .addHeaders("X-RapidAPI-Host", "latest-stock-price.p.rapidapi.com")
                                .setPriority(Priority.HIGH)
                                .build()
                                .getAsJSONArray(new JSONArrayRequestListener() {
                                    @SuppressLint("SuspiciousIndentation")
                                    @Override
                                    public void onResponse(JSONArray response) {


                                        for (int i = 0; i < response.length(); i++) {
                                            try {
                                                JSONObject object = response.getJSONObject(i);

                                                if(object!=null)
                                                {
                                                    String stockname = object.getString("symbol");
                                                    String stockprice = String.valueOf(object.getInt("lastPrice"));
                                                    String stockchange = String.valueOf(object.getInt("change"));
                                                    String stockperchange = String.valueOf(object.getString("pChange"));
                                                    //     Log.d("changes",stockperchange);
                                                    String prevValue=String.valueOf(object.getInt("previousClose"));
                                                    Model model=new Model();
                                                    model.setPrices(stockprice);
                                                    model.setNames(stockname);
                                                    model.setPrevclose(prevValue);
                                                    double value=Integer.parseInt(stockchange);
                                                    value=Math.round(value*Math.pow(10,2))/Math.pow(10,2);
                                                    model.setPricechange(value+"");
                                                    model.setPerchange(stockperchange);
                                                    try {
                                                        list.set(i, model);
                                                    }catch(Exception e)
                                                    {
                                                        Log.d("pogo","POGO");
                                               //        connectApi(indices,pos);
                                                   //     throw new JSONException(e);
                                                    }
                                                   adapter.notifyItemChanged(i);
                                                    //adapter.notifyDataSetChanged();
                                                    oldspinnerpos=pos;



                                                }


                                            } catch (JSONException e) {
                                                Log.d("cartoon","cart");
                                                throw new RuntimeException(e);

                                                //connectApi(indices,pos);
                                            }


                                        }



                                    }

                                    @Override
                                    public void onError(ANError anError) {

                                        anError.printStackTrace();
                                         //    Toast.makeText(getApplicationContext(), " cartoon Can't fetch data from API", Toast.LENGTH_LONG).show();
                                             //connectApi(indices,pos);

                                    }
                                });

                        ///




            }

            public void connectionSpeed(boolean flag)
            {
                //   Log.d("Rose","Your jack is dead");


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(flag==true)
                        {
                            pgbar.setVisibility(View.VISIBLE);
                        }
                        else
                            pgbar.setVisibility(View.GONE);

                    }
                });

                Thread threaddialog2 = new Thread(){
                    public void run(){
                        runOnUiThread(new Runnable() {
                            @SuppressLint({"ResourceAsColor", "SuspiciousIndentation"})
                            public void run() {
                                Toast.makeText(MainActivity.this, "Slow Speed", Toast.LENGTH_LONG).show();
                                if(dialog1.isShowing())
                                    dialog1.dismiss();
                                if(!dialog2.isShowing())
                                    dialog2.show();
                                Window window=dialog2.getWindow();
                                window.setGravity(Gravity.BOTTOM);
                                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

                                //   connectApi(dropdown.get(spinner.getSelectedItemPosition()),spinner.getSelectedItemPosition());


                                if(dialog2.isShowing() && flag==false)
                                    dialog2.dismiss();
                                Thread.currentThread().interrupt();

                            }
                        });
                    }
                };
                threaddialog2.start();


                //   Toast.makeText(this,"slow Speed of VI network",Toast.LENGTH_SHORT).show();

            }



            @SuppressLint("ResourceAsColor")
            public  void connectionLost(boolean flag)
            {
        /*if(t0!=null && t0.isAlive())
        {
            Log.d("myinfo thread"+"t0", String.valueOf(t0));
            Log.d("myinfo thread alive", String.valueOf(t0.isAlive()));
            t0.interrupt();

        }
        if(t1!=null && t1.isAlive())
        {

            Log.d("myinfo thread"+"t1", String.valueOf(t1));
            Log.d("myinfo thread alive", String.valueOf(t1.isAlive()));
            t1.interrupt();

        }
        if(t2!=null && t2.isAlive())
        {

            Log.d("myinfo thread"+"t2", String.valueOf(t2));
            Log.d("myinfo thread alive", String.valueOf(t2.isAlive()));
            t2.interrupt();

        }
        if(t3!=null && t3.isAlive())
        {

            Log.d("myinfo thread"+"t3", String.valueOf(t3));
            Log.d("myinfo thread alive", String.valueOf(t3.isAlive()));
            t3.interrupt();

        }
        if(t4!=null && t4.isAlive())
        {

            Log.d("myinfo thread"+"t4", String.valueOf(t4));
            Log.d("myinfo thread alive", String.valueOf(t4.isAlive()));
            t4.interrupt();
        }
        if(t5!=null && t5.isAlive())
        {

            Log.d("myinfo thread"+"t5", String.valueOf(t5));
            Log.d("myinfo thread alive", String.valueOf(t5.isAlive()));
            t5.interrupt();
        }
        if(t6!=null && t6.isAlive())
        {

            Log.d("myinfo thread"+"t6", String.valueOf(t6));
            Log.d("myinfo thread alive", String.valueOf(t6.isAlive()));
            t6.interrupt();
        }
        if(t7!=null && t7.isAlive())
        {

            Log.d("myinfo thread"+"t7", String.valueOf(t7));
            Log.d("myinfo thread alive", String.valueOf(t7.isAlive()));
            t7.interrupt();
        }
        if(t8!=null && t8.isAlive())
        {

            Log.d("myinfo thread"+"t8", String.valueOf(t8));
            Log.d("myinfo thread alive", String.valueOf(t8.isAlive()));
            t8.interrupt();
        }
        if(t9!=null && t9.isAlive())
        {

            Log.d("myinfo thread"+"t9", String.valueOf(t9));
            Log.d("myinfo thread alive", String.valueOf(t9.isAlive()));
            t9.interrupt();
        }
        if(t10!=null && t10.isAlive())
        {

            Log.d("myinfo thread"+"t10", String.valueOf(t10));
            Log.d("myinfo thread alive", String.valueOf(t10.isAlive()));
            t10.interrupt();
        }
*/
                //    connectApi(dropdown.get(spinner.getSelectedItemPosition()),spinner.getSelectedItemPosition());



                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(flag==true)
                        {
                            pgbar.setVisibility(View.VISIBLE);
                        }
                        else
                            pgbar.setVisibility(View.GONE);

                    }
                });

                Handler handler=new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //         Toast.makeText(MainActivity.this,"I am Looser",Toast.LENGTH_LONG).show();
                        if(dialog2.isShowing())
                            dialog2.dismiss();
                        if(!dialog1.isShowing()) {
                            dialog1.show();

                        }

                        Window window = dialog1.getWindow();
                        window.setGravity(Gravity.BOTTOM);
                        window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                        //       Log.d("catdogall showing",""+dialog1.isShowing());
                        //     Log.d("catdogall flag",""+flag);



                        if(flag==false) {
                            dialog1.dismiss();

                            //       Log.d("cat","catttyyyyy");

                        }


                    }
                });




       /* Thread threaddialog1 = new Thread(){
            public void run(){
                runOnUiThread(new Runnable() {
                    @SuppressLint({"ResourceAsColor", "SuspiciousIndentation"})
                    public void run() {
                        Toast.makeText(MainActivity.this, "Slow Speed VI Network", Toast.LENGTH_LONG).show();
                        if(dialog2.isShowing())
                            dialog2.dismiss();
                        if(!dialog1.isShowing()) {
                            dialog1.show();
                            Window window = dialog1.getWindow();
                            window.setGravity(Gravity.BOTTOM);
                            window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                        }
                        Log.d("catdogall showing",""+dialog1.isShowing());
                        Log.d("catdogall flag",""+flag);

                        try {
                            Log.d("catdogoff flag",""+flag);
                            Thread.sleep(3000);
                            Log.d("catdogON flag",""+flag);
                        } catch (InterruptedException e) {
                         //   throw new RuntimeException(e);
                        }

                        if(dialog1.isShowing()) {
                                dialog1.dismiss();

                                Log.d("cat","catttyyyyy");

                            }
                                Thread.currentThread().interrupt();


                    }
                });
            }
        };
        threaddialog1.start();
*/





       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // dialog.dismiss();
                View view=getLayoutInflater().inflate(R.layout.custom_toast,findViewById(R.id.toast_container));
                dialog1.show();
                Window window=dialog1.getWindow();
                window.setGravity(Gravity.BOTTOM);
                window.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);

            }
        },4000);*/

                // dialog1.dismiss();
                // Log.d("Dog","Iam in connection lost");




                //spinner.setSelection(spinnerposition);

            }



            @Override
            protected void onDestroy() {
                super.onDestroy();
                unregisterReceiver(broadcastReceiver);
                if(t0!=null && t0.isAlive())
                {
                    t0.interrupt();
                }
                if(t1!=null && t1.isAlive())
                {
                    t1.interrupt();
                }
                if(t2!=null && t2.isAlive())
                {
                    t2.interrupt();
                }
                if(t3!=null && t3.isAlive())
                {
                    t3.interrupt();
                }
                if(t4!=null && t4.isAlive())
                {
                    t4.interrupt();
                }
                if(t5!=null && t5.isAlive())
                {
                    t5.interrupt();
                } if(t6!=null && t6.isAlive())
                {
                    t6.interrupt();
                } if(t7!=null && t7.isAlive())
                {
                    t7.interrupt();
                } if(t8!=null && t8.isAlive())
                {
                    t8.interrupt();
                }
                if(t9!=null && t9.isAlive())
                {
                    t9.interrupt();
                } if(t10!=null && t10.isAlive())
                {
                    t10.interrupt();
                }

            }













        //****************************************************************

}