package com.example.flower;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Fragment4 extends Fragment {

    private View view;
    private ListView eventListView;
    private EventListAdapter adapter;
    private ArrayList<ListViewItem> eventList;
    ImageButton event_make;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //얘도 그거처럼 맞추란거에요
    //해당 변수의 pattern은 데이터베이스 형식에 따라 맞춰서 쓰세요.

    //2019-09-30이니까
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        eventListView = (ListView) view.findViewById(R.id.eventListView);
        event_make = (ImageButton) view.findViewById(R.id.event_make);
        event_make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent event = new Intent(getActivity(), Event_make.class);
                startActivity(event);
            }
        });


        new BackgroundTask().execute();

        return view;
    }

    class BackgroundTask extends AsyncTask<Void,Void,String> {

        private String target;

        @Override
        protected void onPreExecute(){
            target = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/EventList.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            eventList = new ArrayList<>();
            String results;
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;//결과 값을 여기에 저장함
                StringBuilder stringBuilder = new StringBuilder();
                //버퍼생성후 한줄씩 가져옴
                while((temp = bufferedReader.readLine()) != null)
                    stringBuilder.append(temp + "");

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                results =  stringBuilder.toString().trim();

            } catch(Exception e){
                e.printStackTrace();
                return null;
            }

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i = 0 ; i < jsonArray.length(); i++){
                    ListViewItem item = new ListViewItem();
                    JSONObject object = jsonArray.getJSONObject(i);
                    item.type = object.getString("type");
                    item.Memo = object.getString("Memo");
                    item.EndDate = object.getString("EndDate");
                    Date format = sdf.parse(item.EndDate);

                    Date date = new Date(System.currentTimeMillis());
                    String dates = sdf.format(date);

                    long mils = format.getTime() - (sdf.parse(dates)).getTime();
                    item.diffDate = String.valueOf((int) (mils/(24*60*60*1000)) + 1) + "일"; //이부분에서 이렇게 1+하면 하루 추가되요
                    //그리고 날짜를 붙이고싶다 하면 (일) 이런거
                    eventList.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            adapter = new EventListAdapter(getContext(), eventList);

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate();

        }

        @Override
        protected void onPostExecute (String result){
            eventListView.setAdapter(adapter);
        }
    }

/*
    class BackgroundTask1 extends AsyncTask<Void,Void,String> {

        private String target;

        @Override
        protected void onPreExecute(){
            target = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/EndArmy.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            eventList = new ArrayList<>();
            String results;
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;//결과 값을 여기에 저장함
                StringBuilder stringBuilder = new StringBuilder();
                //버퍼생성후 한줄씩 가져옴
                while((temp = bufferedReader.readLine()) != null)
                    stringBuilder.append(temp + "");

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                results =  stringBuilder.toString().trim();

            } catch(Exception e){
                e.printStackTrace();
                return null;
            }

            try {
                JSONObject jsonObject = new JSONObject(results);
                JSONArray jsonArray = jsonObject.getJSONArray("response");

                for(int i = 0 ; i < jsonArray.length(); i++){
                    ListViewItem item = new ListViewItem();
                    JSONObject object = jsonArray.getJSONObject(i);
                    item.type = object.getString("type");
                    item.Memo = object.getString("Memo");
                    item.EndDate = object.getString("EndDate");
                    Date format = sdf.parse(item.EndDate);

                    Date date = new Date(System.currentTimeMillis());
                    String dates = sdf.format(date);

                    long mils = format.getTime() - (sdf.parse(dates)).getTime();
                    item.diffDate = String.valueOf((int) (mils/(24*60*60*1000)) + 1) + "일"; //이부분에서 이렇게 1+하면 하루 추가되요
                    //그리고 날짜를 붙이고싶다 하면 (일) 이런거
                    eventList.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            adapter = new EventListAdapter(getContext(), eventList);

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate();

        }

        @Override
        protected void onPostExecute (String result){
            eventListView.setAdapter(adapter);
        }
    }
*/

}