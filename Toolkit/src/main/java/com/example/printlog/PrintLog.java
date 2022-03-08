package com.example.printlog;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.io.PrintWriter;
import java.io.StringWriter;

    public class PrintLog {

        public static void logResponse(String TAG, Object response){
            if (response!=null){
                if (response instanceof String){
                    Log.e(TAG,(String)response);
                }else if (response instanceof Integer){
                    Log.e(TAG, new Gson().toJson(response.toString()));
                }else if(response instanceof Float){
                    Log.e(TAG, new Gson().toJson(response.toString()));
                }
                else{
                    Log.e(TAG, new Gson().toJson(response.toString()));
                }
            }else{
                Log.e(TAG,"Response is Null");
            }
        }





        public static void  toastStyle(Activity activity, Toast toast){
            try {
                LinearLayout toastLayout = (LinearLayout) toast.getView();
                TextView toastTV = (TextView) toastLayout.getChildAt(0);
                toastTV.setTextSize(15);
                Typeface face = ResourcesCompat.getFont(activity,R.font.myriadpro_regular);
                toastTV.setTypeface(face);
                toast.show();
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }


        public static void toast(Activity activity,Object message){
            if (message !=null){
                if (message instanceof String){
                    Toast toast=Toast.makeText(activity, (String)message, Toast.LENGTH_SHORT);
                    toastStyle(activity,toast);
                }else if(message instanceof Integer){
                    Toast toast=Toast.makeText(activity, String.valueOf(message), Toast.LENGTH_SHORT);
                    toastStyle(activity,toast);
                }else if (message instanceof Float){
                    Toast toast= Toast.makeText(activity, new Gson().toJson(message.toString()), Toast.LENGTH_SHORT);
                    toastStyle(activity,toast);
                }
                else{
                    Toast toast= Toast.makeText(activity, new Gson().toJson(message.toString()), Toast.LENGTH_SHORT);
                    toastStyle(activity,toast);
                }
            }else{
                Toast toast= Toast.makeText(activity, "Null", Toast.LENGTH_SHORT);
                toastStyle(activity,toast);
            }

        }


        public static void showsnackbar(Activity activity,String message){
            try{
                Snackbar snack = Snackbar.make(
                        ((activity).findViewById(android.R.id.content)),
                        message, Snackbar.LENGTH_SHORT);
                snack.setDuration(2000);
                snack.setBackgroundTint(activity.getResources().getColor(R.color.gray));
                View view = snack.getView();
                TextView tv = (TextView) view.findViewById(R.id.snackbar_text);
                tv.setTextColor(Color.WHITE);//change textColor
                Typeface face = ResourcesCompat.getFont(activity,R.font.myriadpro_regular);
                tv.setTypeface(face);
                snack.show();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }


        public static String logException(Throwable t){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            Log.e("###App Exception  ",sw.toString());
            return sw.toString(); // stack trace as a string
        }

    }
