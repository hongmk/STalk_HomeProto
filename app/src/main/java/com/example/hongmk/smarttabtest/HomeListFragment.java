package com.example.hongmk.smarttabtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import java.util.ArrayList;

public class HomeListFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeRecyclerAdapter adapter;
    private ArrayList<HomeListItem> list = new ArrayList<HomeListItem>();
    private static int previousSize =0;
    int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_home_list, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        //Toast.makeText(getActivity(), "selected" + pos , Toast.LENGTH_SHORT).show();
        /*현재 생성되는 Fragment의 인덱스를 가져옴
        * 최초 생성 시 INDEX[0, 1]생성 -> 탭 1로 이동 시 INDEX[2]생성 하는 방식으로 동작함(선택된 다음 탭의 내용을 미리 생성함)
        * */
        int position = FragmentPagerItem.getPosition(getArguments());
        Log.i("[SH]", "CREATE POSITION:"+ position);

        list = HomeListItem.getList(5, position);

        adapter = new HomeRecyclerAdapter(rootView.getContext(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext())); //세로로 스크롤 할 것이므로 LinearLayoutManager를 택함

        return rootView;

    }


}
