package com.example.homeworkapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Fragment fragment1,fragment2,fragment3,fragment4;  //声明为父类
    int transaction;
    FragmentManager manager;

    LinearLayout linearLayout1,linearLayout2,linearLayout3,linearLayout4;

    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        linearLayout1=findViewById(R.id.layout1);
        linearLayout2=findViewById(R.id.layout2);
        linearLayout3=findViewById(R.id.layout3);
        linearLayout4=findViewById(R.id.layout4);

        manager=getSupportFragmentManager();

        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();
        fragment4=new Fragment4();

        initial();
        fragmentHide();
        showfragment(fragment1);

        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        linearLayout3.setOnClickListener(this);
        linearLayout4.setOnClickListener(this);
    }

    public void initial(){
        transaction=manager.beginTransaction()
                .add(R.id.content,fragment1)
                .add(R.id.content,fragment2)
                .add(R.id.content,fragment3)
                .add(R.id.content,fragment4)
                .commit();
    }

    public void onClick(View view){
        fragmentHide();
        switch (view.getId())
        {
            case R.id.layout1:showfragment(fragment1);break;
            case R.id.layout2:showfragment(fragment2);break;
            case R.id.layout3:showfragment(fragment3);break;
            case R.id.layout4:showfragment(fragment4);break;
        }
    }

    private void showfragment(Fragment fragment) {
        transaction=manager.beginTransaction()
                .show(fragment)
                .commit();
    }

    public void fragmentHide(){
        transaction=manager.beginTransaction()
                .hide(fragment1)
                .hide(fragment2)
                .hide(fragment3)
                .hide(fragment4)
                .commit();
    }



}