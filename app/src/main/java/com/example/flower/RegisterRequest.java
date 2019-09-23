package com.example.flower;


import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정 (PHP 연동)
    final  static private String URL = "http://ec2-3-229-83-86.compute-1.amazonaws.com:80/Register.php"; //인스턴스 주소값/php파일
    private Map<String, String> map;


    public RegisterRequest(String email, String password, String name, String enlist_date, String enlist_end_date , String type,  String region,Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);


        map = new HashMap<>();
        map.put("email",email);
        map.put("password",password);
        map.put("name", name);
        map.put("enlist_date", enlist_date);
        map.put("enlist_end_date", enlist_end_date);
        map.put("type", type);
        map.put("region",region);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}