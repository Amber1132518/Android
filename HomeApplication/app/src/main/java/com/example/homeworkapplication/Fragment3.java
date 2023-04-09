package com.example.homeworkapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment implements Myadapter2.OnItemClickListener{

    private RecyclerView recyclerView;
    private Myadapter2 myadapter;

    ArrayList<News> data=new ArrayList<News>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        recyclerView = view.findViewById(R.id.news_list);
        myadapter = new Myadapter2(data, getActivity());
        recyclerView.setAdapter(myadapter);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        myadapter.setOnItemClickListener(this);
        data.add(new News("Title 1", "Time 1","Content 1"));
        data.add(new News("Title 2", "Time 2","Content 2"));
        data.add(new News("Title 3", "Time 3","Content 3"));
        data.add(new News("Title 4", "Time 4","Content 4"));
        data.add(new News("Title 5", "Time 5","Content 5"));
        data.add(new News("Title 6", "Time 6","Content 6"));
        data.add(new News("Title 1", "Time 1","Content 1"));
        data.add(new News("Title 2", "Time 2","Content 2"));
        data.add(new News("Title 3", "Time 3","Content 3"));
        data.add(new News("Title 4", "Time 4","Content 4"));
        data.add(new News("Title 5", "Time 5","Content 5"));
        data.add(new News("Title 6", "Time 6","Content 6"));
        return view;
    }

    @Override
    public void OnItemClick(View view, int position) {
        News news = data.get(position);
        Intent intent = new Intent(getActivity(), newsdetail.class);
        intent.putExtra("news", news);
        startActivity(intent);
    }

    @Override
    public void onItemLongClick(View view, int pos) {
        // Do nothing
    }
}
