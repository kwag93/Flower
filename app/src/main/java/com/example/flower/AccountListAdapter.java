package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AccountListAdapter extends BaseAdapter {

    private Context context;
    private List<Account> accountList;

    public AccountListAdapter(Context context, List<Account> accountList) {
        this.context = context;
        this.accountList = accountList;
    }


    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int position) {
        return accountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.account, null);
        TextView historyText = (TextView) v.findViewById(R.id.historyText);
        TextView priceText = (TextView) v.findViewById(R.id.priceText);
        TextView dateText = (TextView) v.findViewById(R.id.dateText);

        historyText.setText(accountList.get(position).getHistory());
        priceText.setText(accountList.get(position).getPrice());
        dateText.setText(accountList.get(position).getDate());

        v.setTag(accountList.get(position).getHistory());
        return  v;
    }
}
