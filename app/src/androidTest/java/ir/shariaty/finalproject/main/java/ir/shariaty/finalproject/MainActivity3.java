package ir.shariaty.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import retrofit2.Callback;

//import retrofit2.RetrofitError;
//import retrofit.client.Response;

public class MainActivity3 extends AppCompatActivity {

    signUpResponse signUpResponsesData;

    public RequestQueue queue;
    ImageButton btnfav3;
    public TextView word3;
    TextView pronounse3;
   public TextView meaning3;
    TextView src3;

    public String word;

    retrofit2.Call<searchModel> searchModelCall = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnfav3 = (ImageButton) findViewById(R.id.btnfav3);
        word3 = (TextView) findViewById(R.id.word3);
        pronounse3 = (TextView) findViewById(R.id.pronounce3);
        meaning3 = (TextView) findViewById(R.id.meaning3);
        src3 = (TextView) findViewById(R.id.src3);

//        queue = Volley.newRequestQueue(this);

        word3.setText(word);

        getSearch(ApiUtilities.token,word,"like","dehkhoda");

        Intent intent = getIntent();
        Bundle b = intent.getBundleExtra("bundleData");
        word = b.getString("search");
        word3.setText(word);
    }


    private void getSearch(String token,String q,String type,String filter){
        ApiInterface apiInterface=ApiUtilities.getApiInterface(this).create(ApiInterface.class);
searchModelCall=apiInterface.search(token,q,type,filter);
searchModelCall.enqueue(new Callback<searchModel>() {
    @Override
    public void onResponse(retrofit2.Call<searchModel> call, retrofit2.Response<searchModel> response) {
        if (!response.isSuccessful() || response.body() == null || response.body().data == null) {
            Toast.makeText(MainActivity3.this, "error!", Toast.LENGTH_SHORT).show();
        }
        if (response.body() == null) {
            String content = "";
            for (int i = 0; i < response.body().data.results.size(); i++) {
                content += response.body().data.results.get(i).source + "\n" + response.body().data.results.get(i).text + "\n\n\n";
            }
            meaning3.setText(content);

        }
    }

    @Override
    public void onFailure(retrofit2.Call<searchModel> call, Throwable t) {
        Toast.makeText(MainActivity3.this, "ERROR HAPPEND!", Toast.LENGTH_SHORT).show();

    }
});
    }}

//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // validate the fields and call sign method to implement the api
//                if (validate(name) && validate(email) && validate(password)) {
//                    signUp();
//                }
//            }
//        });
//    }
//
//    private boolean validate(EditText editText) {
//        // check the lenght of the enter data in EditText and give error if its empty
//        if (editText.getText().toString().trim().length() > 0) {
//            return true; // returs true if field is not empty
//        }
//        editText.setError("Please Fill This");
//        editText.requestFocus();
//        return false;
//    }

//    private void signUp() {
//        // display a progress dialog
//        final ProgressDialog progressDialog = new ProgressDialog(MainActivity3.this);
//        progressDialog.setCancelable(false); // set cancelable to false
//        progressDialog.setMessage("Please Wait"); // set message
//        progressDialog.show(); // show progress dialog
//
//        // Api is a class in which we define a method getClient() that returns the API Interface class object
//        // registration is a POST request type method in which we are sending our field's data
//        Api.getClient().registration(word.trim(),
////                email.getText().toString().trim(),
////                password.getText().toString().trim(),
//"word",new Callback<signUpResponse>(){
//        @Override
////                    public void success(signUpResponse signUpResponse, Response response) {
////                        // in this method we will get the response from API
////                        progressDialog.dismiss(); //dismiss progress dialog
////                        signUpResponsesData = signUpResponse;
////                        // display the message getting from web api
////                        Toast.makeText(MainActivity3.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
////                    }
//
////                    @Override
//                    public void success(signUpResponse signUpResponse, retrofit.client.Response response) {
//                        // in this method we will get the response from API
//                        progressDialog.dismiss(); //dismiss progress dialog
//                        signUpResponsesData = signUpResponse;
//                        // display the message getting from web api
//                        Toast.makeText(MainActivity3.this, signUpResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    @Override
//                    public void failure(RetrofitError error) {
//                        // if error occurs in network transaction then we can get the error in this method.
//                        Toast.makeText(MainActivity3.this, error.toString(), Toast.LENGTH_LONG).show();
//                        progressDialog.dismiss(); //dismiss progress dialog
//
//                    }
//                });



















//        StringRequest stringRequest = searchword(word);
//stringRequest.setTag(TAG_SEARCH_NAME);
//        queue.add(stringRequest);



//    private JsonObjectRequest searchword() {
////        private String searchword(String search1){
//        final String URLPREFIX = "http://api.vajehyab.com/v3/";
//        final String TOKEN = "token=";
//        final String API = "68372.KmVovB43vrMzRNgCU5g85UyoJJqgUzoyhDNZVfjH";
//
//        final String qurl = "&q=";
//        final String wordurl = word;
//        final String filterurl = "&filter=en2fa";
//        final String num = "&num=1";
//        final String type = "&type=like";
////        String url = URLPREFIX + TOKEN + API + qurl + wordurl + filterurl + num + type;
//        String url = URLPREFIX+ API + qurl + wordurl + filterurl + num + type;
//
//        //    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
////                            JSONObject result = new JSONObject(response).getJSONObject("list");
////                            int maxItems = result.getInt("end");
////                            JSONArray resultlist = result.getJSONArray("item");
//
//////////////////////////////////////////////////////////////
//                            JSONArray dataArray = response.getJSONArray("meta");
//                            for (int i = 0; i < dataArray.length(); i++) {
//                                JSONObject dataobj = dataArray.getJSONObject(i);
//                                String word = dataobj.getString("q");
//                                String src = dataobj.getString("filter");
//
//                                JSONObject data = dataobj.getJSONObject("data");
//                                JSONObject result = data.getJSONObject("result");
//                                String text = result.getString("text");
////                    String src= dataobj.getString("filter");
////                    String text = dataobj.getString("src");
//                                Toast.makeText(MainActivity3.this, " translated", Toast.LENGTH_SHORT).show();
//
//                                word3.setText(word);
//                                src3.setText(src);
//                                meaning3.setText(text);
//
//                            }
//                        } catch (JSONException e) {
//                            Toast.makeText(MainActivity3.this, "failed to translate", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(MainActivity3.this, "An Error Happened!", Toast.LENGTH_SHORT).show();
//
//                    }
//                }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap();
//
//                headers.put("search", "token=");
//                return headers;
//            }
//        };
//        requestQueue.add(jsonObjectRequest);
//return  (jsonObjectRequest);
//    }
//
//}


//private void searchword() {
//    String url = "http://api.vajehyab.com/v3/search?";
//    RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//        @Override
//        public void onResponse(JSONObject response) {
//            try {
//                JSONArray dataArray = response.getJSONArray("meta");
////                for (int i = 0; i < dataArray.length(); i++) {
//                JSONObject dataobj = dataArray.getJSONObject(Integer.parseInt(word));
//                String word = dataobj.getString("q");
//                String src = dataobj.getString("filter");
//
//                JSONObject data = dataobj.getJSONObject("data");
//                JSONObject result = data.getJSONObject("result");
////                    String text = result.getString("text");
////                    String src= dataobj.getString("filter");
////                    String text = dataobj.getString("src");
////                }
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Toast.makeText(MainActivity3.this, "translated", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            Toast.makeText(MainActivity3.this, "failed to translate", Toast.LENGTH_SHORT).show();
//        }
//
//
//    }) {
//        @Override
//        public Map<String, String> getHeaders() throws AuthFailureError {
//            HashMap<String, String> headers = new HashMap();
//
//            headers.put("token", "68372.KmVovB43vrMzRNgCU5g85UyoJJqgUzoyhDNZVfjH");
//            return headers;
//        }
//    };
//    requestQueue.add(jsonObjectRequest);
//}
//    }

