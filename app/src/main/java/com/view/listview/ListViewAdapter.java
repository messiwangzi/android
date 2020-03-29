package com.view.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter
{
    private Context context;
    private List<Student> list;

    public ListViewAdapter(Context context, List<Student> list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        final LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.item, parent, false);
        TextView name = convertView.findViewById(R.id.tv_name);
        TextView age = convertView.findViewById(R.id.tv_age);
        TextView sex = convertView.findViewById(R.id.tv_sex);
        name.setText(list.get(position).getName());
        age.setText(String.valueOf(list.get(position).getAge()));
        if (list.get(position).isSex())
        {
            sex.setText("男");
        } else
        {
            sex.setText("女");
        }
        return convertView;
    }
}
