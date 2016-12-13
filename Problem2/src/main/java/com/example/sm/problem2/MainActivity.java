package com.example.sm.problem2;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBaseAdapter adapter;
    ListView listview;
    ArrayList<Employee> emp_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // need something here
        Button Create = (Button)findViewById(R.id.btn_store);
        Button Update = (Button)findViewById(R.id.btn_modify);
        Button Delete = (Button)findViewById(R.id.btn_delete);

        Button increase = (Button)findViewById(R.id.btn_inc);
        Button decrease = (Button)findViewById(R.id.btn_dec);

        Create.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
            }
        });
        Update.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
            }
        });
        Delete.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
            }
        });
        increase.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
            }
        });
        decrease.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
            }
        });

        adapter = new MyBaseAdapter(this, emp_list);
        listview = (ListView) findViewById(R.id.listView1) ;
        listview.setAdapter(adapter);
        listview.setOnItemClickListener((AdapterView.OnItemClickListener)adapter);
    }
    @Override
    public void onClick(View v){
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        EditText edit_age = (EditText) findViewById(R.id.edit_age);
        EditText edit_salary = (EditText) findViewById(R.id.edit_salary);

        Employee employee = new Employee(null,0,0);

        switch (v.getId()){
            case R.id.btn_inc:
                employee.increase();
                break;

            case R.id.btn_dec:
                employee.decrease();
                break;

            case R.id.btn_store:

                break;

            case R.id.btn_modify:
                adapter.add(employee);
                break;

            case R.id.btn_delete:
                adapter.delete(0);
                break;
        }
    }
}

interface Payment {
    void increase();
    void decrease();
}
