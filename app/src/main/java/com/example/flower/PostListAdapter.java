package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostListAdapter extends BaseAdapter {

    private Context context;
    private List<Post> postList;

    public PostListAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.post, null);
        TextView postName = (TextView) v.findViewById(R.id.postName);
        TextView postText = (TextView) v.findViewById(R.id.postText);
        TextView postTime = (TextView) v.findViewById(R.id.postTime);

        postName.setText(postList.get(position).getName());
        postText.setText(postList.get(position).getText());
        postTime.setText(postList.get(position).getTime());

        v.setTag(postList.get(position).getName());
        return  v;
    }

}
