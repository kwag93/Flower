package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BoardListAdapter extends BaseAdapter {

    private Context context;
    private List<Board> boardList;

    public BoardListAdapter(Context context, List<Board> boardList) {
        this.context = context;
        this.boardList = boardList;
    }


    @Override
    public int getCount() {
        return boardList.size();
    }

    @Override
    public Object getItem(int position) {
        return boardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.board, null);
        TextView boardName = (TextView) v.findViewById(R.id.boardName);
        TextView boardDes = (TextView) v.findViewById(R.id.boardDes);

        boardName.setText(boardList.get(position).getBoardname());
        boardDes.setText(boardList.get(position).getDescription());

        v.setTag(boardList.get(position).getBoardname());
        return  v;
    }
}
