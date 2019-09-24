package com.example.flower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PostDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        Intent intent = getIntent();

        TextView postName = (TextView) findViewById(R.id.postName);
        TextView postText = (TextView) findViewById(R.id.postText);

        postName.setText(intent.getStringExtra("postName"));
        postText.setText(intent.getStringExtra("postText"));
    }
}
