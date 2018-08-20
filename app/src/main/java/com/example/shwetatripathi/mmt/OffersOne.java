package com.example.shwetatripathi.mmt;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class OffersOne {
/*

    private static final String mURL="http://54.242.83.222:8080/MakeMyTrip/mmt/blog/seeAllBlogs";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    TextView nameText;
    ImageView imageText;
    String name,image;
    BlogOne blogone;
    private List<BlogOne> blog_list;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);

        init();
        new fetchData().execute();
        //nameText=(TextView) findViewById(R.id.blog_title);

//        loadRecyclerViewData();
    }

    private void init() {
        imageText=(ImageView) findViewById(R.id.blog_img);

        recyclerView = findViewById(R.id.blog_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        blog_list = new ArrayList<>();
        adapter = new Blog_Recycler_Adapter(blog_list,this);
        recyclerView.setAdapter(adapter);

        blog_list = new ArrayList<>();

    }



    public class fetchData extends AsyncTask<Void, Void, Void> {
        private String mBlog;

        @Override
        protected Void doInBackground(Void... voids) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;
            Uri uri = Uri.parse(mURL);
            URL url;
            try{
                url = new URL(uri.toString());
                urlConnection = (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                if(inputStream == null){
                    return  null;
                }

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while(( line = reader.readLine()) != null){
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0){
                    return  null;
                }

                mBlog = buffer.toString();
                JSONObject jsonObject = new JSONObject(mBlog);

                JSONArray blogarray = jsonObject.getJSONArray("blogone");

                for (int i = 0; i < blogarray.length(); i++){
                    String blog;
                    String imageURL;


                    JSONObject jBlog = (JSONObject) blogarray.get(i);
                    jBlog = jBlog.getJSONObject("blog");
                    JSONObject jimageURL = jBlog.getJSONObject("imageURL");

                    blog = jBlog.getString("blogName");
                    imageURL = jimageURL.getString("imageURL");

                    BlogOne blogOne = new BlogOne();
                    blogOne.setBlogName(blog);
                    blogOne.setImgURL(imageURL);


                    blog_list.add(blogOne);


                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("MainActivity", "Error closing stream", e);
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            adapter.notifyDataSetChanged();

        }

    }
*/

//    private void loadRecyclerViewData() {
//        ProgressDialog progressDialog=new ProgressDialog(this);
//        progressDialog.setMessage("Loading Data...");
//        progressDialog.show();
//
//        jsonParse();
//


//
//JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, URL, null,
//        new Response.Listener<JSONObject>() {
//    @Override
//    public void onResponse(JSONObject response) {
//        try {
//
//            name=response.getString("blog_name");
//            image=response.getString("img_url");
//            nameText.setText(name);
////            imageText.setImage(image);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//}, new Response.ErrorListener() {
//    @Override
//    public void onErrorResponse(VolleyError error) {
//        Toast.makeText(Offers.this, "Something went wrong "+error.toString(), Toast.LENGTH_LONG).show();
//
//    }
//});
//
//
//        RequestQueue requestQueue= Volley.newRequestQueue(this);
//        requestQueue.add(jsonObjectRequest);
    //  }

//    private void jsonParse() {
//        StringRequest request = new StringRequest(URL, response -> {
//            Log.e("Code", response);
//
//            ObjectMapper mapper = new ObjectMapper();
//
//            try{
//
//                List<BlogOne> blogone = Arrays.asList(mapper.readValue(response, BlogOne[].class)) ;
//
//                    for(int i=0;i<response.length();i++)
//                    {
//
//
//                        BlogOne b = new BlogOne(
//                                blogone.get(i).getBlogName(),
//                                Glide.with(this).load(blogone.get(i).getImgURL()).into(imageText)
//                        );
//                        blog_list.add(b);
//
//                    }
//
///*
//                nameText.setText(blogone.get(0).getId() + ","+ blogone.get(0).getBlogName() + ","+ blogone.get(0).getBlogURL() + ","+ blogone.get(0).getImgURL());
//
//                nameText.append(blogone.get(1).getId() + ","+ blogone.get(1).getBlogName() + ","+ blogone.get(1).getBlogURL() + ","+ blogone.get(1).getImgURL());
//*/
//
//            }
//            catch (JsonParseException e){
//                e.printStackTrace();
//            }
//            catch (com.fasterxml.jackson.core.JsonParseException e) {
//                e.printStackTrace();
//            }
//            catch (JsonMappingException e) {
//                e.printStackTrace();
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//        }, error -> {
//            Toast.makeText(this, "Something went wrong " + error.getMessage(), Toast.LENGTH_LONG).show();
//        });
//            RequestQueue queue = Volley.newRequestQueue(this);
//            queue.add(request);
//
//
//    }
//}

}
