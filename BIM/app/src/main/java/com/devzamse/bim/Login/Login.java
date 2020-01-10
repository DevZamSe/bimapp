package com.devzamse.bim.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.devzamse.bim.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Login extends AppCompatActivity {

    Button button;
    //RequestQueue requestQueue;
    String api = "iGtSVuBWw99skT61O6xHS8OjWaCgHPEgeXJfkbif";
    String url = "https://hks6xivfr8.execute-api.us-east-1.amazonaws.com/dev/awspdp/appbim/valida-disp";
    private static final String TAG = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Login.this, TokenIngreso.class);
                //startActivity(intent);
                //PostOperation();
                try {
                    Posman();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void Posman() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"traza_app\":\"ewoJJ3Jlc291cmNlJzogJy9hd3NwZHAvZ2V0YmFsYW5jZScsCgkncGF0aCc6ICcvYXdzcGRwL2dldGJhbGFuY2UnLAoJJ2h0dHBNZXRob2QnOiAnUE9TVCcsCgknaGVhZGVycyc6IHsKCQknQWNjZXB0JzogJyovKicsCgkJJ0FjY2VwdC1FbmNvZGluZyc6ICdnemlwLCBkZWZsYXRlJywKCQknQXV0aG9yaXphdGlvbic6ICdCYXNpYyBjR1J3TFhSbGMzUTZXV2NrU2s5aWJVQkRVQzQxY0VSUmR5RXlZa3M9JywKCQknQ2FjaGUtQ29udHJvbCc6ICduby1jYWNoZScsCgkJJ0NvbnRlbnQtVHlwZSc6ICdhcHBsaWNhdGlvbi9qc29uJywKCQknSG9zdCc6ICc2b2d3bWt0dnU4LmV4ZWN1dGUtYXBpLnVzLWVhc3QtMS5hbWF6b2\",\n\t\"msisdn\":\"NTE5NTkyNjI3MDQ=\",\n\t\"id_tel\":\"NTE5NTkyNjI3OTA1\",\n\t\"_comment\": \"msisdn:51959262705:error 500 * msisdn:51959262704:status 200 'TOKEN' * otro num: status 200 'PIN' \"\n}\n");
        Request request = new Request.Builder()
                .url("https://hks6xivfr8.execute-api.us-east-1.amazonaws.com/dev/awspdp/appbim/valida-disp")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", "iGtSVuBWw99skT61O6xHS8OjWaCgHPEgeXJfkbif")
                .build();

            Response response = client.newCall(request).execute();

    }
}
/*
    public void PostOperation() {
        requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("login output", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("x-api-key", api);
                headers.put("Authorization","Basic cGRwOjEyMzQ=");
                Log.e("api", headers+ "");
                return headers;
            }
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> map = new HashMap<String, String>();

                //"{\n\t\"traza_app\":\"SG9sYQ\",\n\t\"msisdn\":\"NTE5Nzc3Mjc2MzI\",\n\t\"id_tel\":\"NTE5Nzc3Mjc2MzI\",\n\t\"_comment\": \"msisdn:51959262705:error 500 ** msisdn:51959262704:status 200 'TOKEN' ** otro num: status 200 'PIN' \"\n}"

                map.put("\"traza_app\"", "\"ImhvbGEi\"");
                map.put("\"msisdn\"", "\"Ijk3NzcyNzYzMiI\"");
                map.put("\"id_tel\"", "\"Ijk3NzcyNzYzMiI\"");
                map.put("\"_comment\"", "\"msisdn:51959262705:error 500 ** msisdn:51959262704:status 200 'TOKEN' ** otro num: status 200 'PIN'\"");
                Log.e("para", map + "");
                return map;
            }

        };
        requestQueue.add(stringRequest);
        Log.e("hola",stringRequest.toString());

    */