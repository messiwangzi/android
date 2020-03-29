package com.view.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ListView listView;
    private ListViewAdapter listViewAdapter;

    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        setListener();
    }

    private void initView()
    {
        listView = findViewById(R.id.listview);
    }

    private void setListener()
    {
        listViewAdapter = new ListViewAdapter(MainActivity.this, students);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            //parent<--->指的是ListView本身
            //view <---> 指的是ListView里面具体的item
            //position <---> 指的是具体item的位置
            //id <---> 具体item在ListView上的id
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                TextView name = view.findViewById(R.id.tv_name);
                ListViewAdapter adapter = (ListViewAdapter) parent.getAdapter();
                Student student = (Student) adapter.getItem(position);
                Toast.makeText(MainActivity.this, student.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData()
    {
        students = new ArrayList<>();
        students.add(new Student("黑崎一护", 17, true));
        students.add(new Student("石田雨龙", 17, true));
        students.add(new Student("茶渡泰虎", 17, true));
        students.add(new Student("朽木露琪亚", 152, false));
        students.add(new Student("井上织姬", 17, false));
    }
}
