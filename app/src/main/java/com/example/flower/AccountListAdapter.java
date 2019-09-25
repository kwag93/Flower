package com.example.flower;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AccountListAdapter extends BaseAdapter {

    private Context context; // private Context context;
    private List<Account> accountList; // private List<Notice>  noticeList;

    public AccountListAdapter(Context context, List<Account> accountList) {
        this.context = context;
        this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int i) {
        return accountList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context,R.layout.account_list_item,null);
        TextView historyText = (TextView) v.findViewById(R.id.historyText);
        TextView priceText = (TextView) v.findViewById(R.id.priceText);
        TextView dateText = (TextView) v.findViewById(R.id.dateText);

        historyText.setText(accountList.get(i).getHistory());
        priceText.setText(accountList.get(i).getPrice());
        dateText.setText(accountList.get(i).getDate());

        v.setTag(accountList.get(i).getHistory());
        return v;
    }


}
