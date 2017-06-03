package com.dumeplus.ensurance;


import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends StringRequest{

    private static final String LOGIN_REQUEST_URL="http://localhost/Projects/login.php";
    private Map<String, String> params;

    public LoginRequest(String email, String password,Response.Listener<String> listener ){

        //Sending data to Register.php
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        //Create a map. Putting all data into the params
        Log.d("message","loginrequestcalled");
        params = new HashMap<>();
        params.put("email",email);
        params.put("password",password);
    }

    //Volley access to the data
    //When the request is executed, volley calls getparams() which returns all the params
    @Override
    public Map<String,String> getParams(){
        return params;
    }

}
