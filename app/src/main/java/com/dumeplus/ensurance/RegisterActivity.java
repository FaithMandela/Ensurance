package com.dumeplus.ensurance;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity{

    Button btnSignUp;
    EditText txtFName,txtLName,txtEmail1,txtPwb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        txtFName = (EditText) findViewById(R.id.txtFName);
        txtLName = (EditText) findViewById(R.id.txtLName);
        txtEmail1 = (EditText) findViewById(R.id.txtEmail1);
        txtPwb= (EditText) findViewById(R.id.txtPwd);

        btnSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("message","sucess");
                //Getting texts from the text fields
                final String fname = txtFName.getText().toString();
                final String lname = txtLName.getText().toString();
                final String email = txtEmail1.getText().toString();
                final String password = txtPwb.getText().toString();


                //Creating a response listener
               Response.Listener<String> responseListener= new Response.Listener<String>(){

                    //This happens when the response from Register.php has been executed
                    @Override
                    public void onResponse(String response) {
                        //Converting to a JSON object because in Register.php the output was in JSON
                        Log.d("response",response.toString());
                     /*   try {
                            JSONObject JSONresponse = new JSONObject(response);
                            //When the response is executed and a response is given, volley checks the value of success and makes it
                            //egual to the variable 'success'
                            boolean success = JSONresponse.getBoolean("Success");

                            if(success){
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                          }else{
                                //Displaying message in case Registration fails
                                AlertDialog.Builder builder= new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Registration failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(fname,lname,email,password, responseListener);
                //Add the request to a request queue
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);


            }
        });
    }


}
