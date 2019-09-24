package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CommentListAdapter extends BaseAdapter {

    private Context context;
    private List<Comment> commentList;

    public CommentListAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.comment, null);
        TextView commentName = (TextView) v.findViewById(R.id.commentName);
        TextView commentText = (TextView) v.findViewById(R.id.commentText);
        TextView commentTime = (TextView) v.findViewById(R.id.commentTime);

        commentName.setText(commentList.get(position).getName());
        commentText.setText(commentList.get(position).getText());
        commentTime.setText(commentList.get(position).getTime());

        v.setTag(commentList.get(position).getName());
        return v;
    }
}
