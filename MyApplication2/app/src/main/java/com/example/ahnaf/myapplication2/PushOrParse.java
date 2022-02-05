package com.example.ahnaf.myapplication2;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import java.util.Map;

public  class PushOrParse{

    static JSONArray array;
    Context context;

     public static void getDataFromServer(String url, Map map, Context context){

         CustomJsonArrayRequest customJsonArrayRequest=new CustomJsonArrayRequest(Request.Method.POST, url, map, new Response.Listener<JSONArray>() {

             @Override
             public void onResponse(JSONArray response) {

                 array=response;

             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });



         MySingleton.getmInstance(context).AddToRequestQueue(customJsonArrayRequest);

         }


         public static JSONArray deliverData(){
         Log.d("Arry",array.toString());
           return  array;

         }
}
