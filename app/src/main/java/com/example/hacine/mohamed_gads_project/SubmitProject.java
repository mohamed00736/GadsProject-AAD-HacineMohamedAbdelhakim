package com.example.hacine.mohamed_gads_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SubmitProject extends AppCompatActivity {
    EditText tvname, tvlast , tvlink , tvemail ;
    Button btnsubmit  ;
    ProgressDialog progressDialog;
    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_project);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");


        tvemail= findViewById(R.id.email);
        tvname= findViewById(R.id.edtName);
        tvlast= findViewById(R.id.lastname);
        queue = Volley.newRequestQueue(getApplicationContext());
        tvlink= findViewById(R.id.link);
        btnsubmit= findViewById(R.id.btnsubmit);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
openDialog();
            }
        });



    }



    public void postData(final String name, final String email , final  String link , final String lastname) {
        progressDialog.show();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                Constants.url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {
                            ShowSuccesDialog();

                            tvemail.setText(null);
                            tvname.setText(null);
                            tvlast.setText(null);
                            tvlink.setText(null);
                        } else {
                            // Snackbar.make(fab, "Try Again", Snackbar.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                ShowFailedDialog();

                // Snackbar.make(fab, "Error while Posting Data", Snackbar.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(Constants.nameField, name);
                params.put(Constants.emailField, email);
                params.put(Constants.lastnameField, lastname);
                params.put(Constants.projectlink, link);
                return params;
            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }

    private void openDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.areusure);

        Button btndialogyes = dialog.findViewById(R.id.btnyes);
        Button btndialogclose = dialog.findViewById(R.id.imgclose);
        btndialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btndialogyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                postData(tvname.getText().toString().trim(), tvemail.getText().toString().trim(), tvlink.getText().toString().trim(),tvlast.getText().toString().trim());
                dialog.dismiss();

            }


        });
        dialog.show();

    }

    private void ShowSuccesDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.sucess);

        Button btndialogyes = dialog.findViewById(R.id.suucesclose);
        Button btndialogclose = dialog.findViewById(R.id.imgsuc);
        btndialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btndialogyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void ShowFailedDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.failed);

        Button btndialogyes = dialog.findViewById(R.id.failedclose);
        Button btndialogclose = dialog.findViewById(R.id.imgfai);
        btndialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btndialogyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}