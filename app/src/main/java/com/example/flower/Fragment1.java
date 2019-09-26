package com.example.flower;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.internal.http2.Http2Connection;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Fragment1 extends Fragment {

    private TextView regionText;
    private View view;
    private ImageButton btn_logout;
    public String email;
    private Call<String>mRegion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        email = getArguments().getString("email");

        View view= inflater.inflate(R.layout.frag1, container,false);

        regionText = (TextView) view.findViewById(R.id.regionText);
        String url = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/test.php";

        btn_logout = (ImageButton) view.findViewById(R.id.btn_logout);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveSharedPreference.clearUserName(getActivity());
                Intent intent = new Intent(getActivity(), FirstAuthActivity.class);
                startActivity(intent);
            }
        });

        NetworkTask networkTask = new NetworkTask(url, null);
        networkTask.execute();

        return view;
    }
    public class NetworkTask extends AsyncTask<Void, Void, String> {

        private String url;
        private ContentValues values;

        public NetworkTask(String url, ContentValues values) {

            this.url = url;
            this.values = values;
        }

        @Override
        protected String doInBackground(Void... params) {

            String result; // 요청 결과를 저장할 변수.
            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
            regionText.setText(s);
        }
    }

}
