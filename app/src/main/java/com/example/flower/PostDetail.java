package com.example.flower;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PostDetail extends AppCompatActivity {

    private ListView commentListView;
    private CommentListAdapter adapter;
    private List<Comment> commentList;
    private Button btn_send;
    private EditText commentText;
    private TextView postName,postText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Intent PostMake = getIntent();

        commentText = findViewById(R.id.commentText);
        btn_send = findViewById(R.id.btn_send);

         postName =  findViewById(R.id.postName);
         postText =  findViewById(R.id.postText);

        postName.setText(PostMake.getStringExtra("postName"));
        postText.setText(PostMake.getStringExtra("postText"));

        commentListView = (ListView) findViewById(R.id.commentListView);
        commentList = new ArrayList<Comment>();
        adapter = new CommentListAdapter(getApplicationContext(), commentList);
        commentListView.setAdapter(adapter);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {         //회원가입 버튼 클릭시 수행
                //editText의 입력된 값을 get (가져오다)해옴
                String text = commentText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { //댓글 등록 성공
                                Toast.makeText(getApplicationContext(), "댓글 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                            } else { // 댓글 등록 실패
                                Toast.makeText(getApplicationContext(), "댓글 등록에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                //서버로 volley 를 이용하여 요청함
                CommentRequest commentRequest = new CommentRequest(text, responseListener);
                RequestQueue queue = Volley.newRequestQueue(PostDetail.this);
                queue.add(commentRequest);
            }
        });

        new BackgroundTask().execute();



    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String target;

        @Override
        protected void onPreExecute() {
            target = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/CommentList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {
                    stringBuilder.append(temp + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public void onProgressUpdate(Void... values) {
            super.onProgressUpdate();
        }

        @Override
        public void onPostExecute(String result) {
            try {
                JSONObject jsonObject = new JSONObject(result);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;
                String commentName, commentText,commentTime;
                while (count < jsonArray.length()) {
                    JSONObject object = jsonArray.getJSONObject(count);
                    commentName = object.getString("commentName");
                    commentText = object.getString("commentText");
                    commentTime = object.getString("commentTime");

                    Comment comment = new Comment(commentName, commentText,commentTime);
                    commentList.add(comment);
                    adapter.notifyDataSetChanged();
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
