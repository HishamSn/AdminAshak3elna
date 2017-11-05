package admin.ashak3lena.adminashak3elna.Auth;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.android.volley.*;
import com.android.volley.toolbox.*;

import org.json.*;

import java.util.*;

import admin.ashak3lena.adminashak3elna.R;
import admin.ashak3lena.adminashak3elna.utils.*;


public class login extends AppCompatActivity {

    EditText etUsername, etPass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void init(){
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPass = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }

        public void login () {

        final String username = etUsername.getText().toString();
        final String password = etPass.getText().toString();

        final StringRequest jsonObjectRequest = new StringRequest(Constatns.MAIN_API + Constatns.LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("messi", response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String f = jsonObject.getString("f");
                            if(f.equals("1")){
                                
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> params = new HashMap<>();
                params.put("uid", username);
                params.put("password", password);
                Log.e("uid", username);
                Log.e("password", password);
                return params;
            }
        };
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);

        }

}
