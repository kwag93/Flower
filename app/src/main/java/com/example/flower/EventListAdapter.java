package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EventListAdapter extends BaseAdapter {

    private  Context context;
    private List<ListViewItem> eventList;

    public EventListAdapter(Context context, List<ListViewItem> eventList) {
        this.context = context;
        this.eventList = eventList;
    }

    @Override
    public int getCount() {
        return eventList.size();
    }

    @Override
    public Object getItem(int i) {
        return eventList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context,R.layout.event,null);
        TextView typeText = (TextView) v.findViewById(R.id.typeText);
        TextView memoText = (TextView) v.findViewById(R.id.memoText);
        TextView dateText = (TextView) v.findViewById(R.id.dateText);
        TextView diffDateText = (TextView) v.findViewById(R.id.diffDateText);

        typeText.setText(eventList.get(i).type);
        memoText.setText(eventList.get(i).Memo);
        dateText.setText(eventList.get(i).EndDate);
        diffDateText.setText(eventList.get(i).diffDate);

        v.setTag(eventList.get(i).type);
        return v;
    }


}
