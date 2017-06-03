package com.dumeplus.ensurance;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://localhost/Projects/register.php";
    private Map<String, String> params;

    public RegisterRequest(String fname, String lname, String email, String password,Response.Listener<String> listener ){
        //Sending data to Register.php
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        //Create a map. Putting all data into the params
        params = new HashMap<>();
        params.put("fname",fname);
        params.put("lname",lname);
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
