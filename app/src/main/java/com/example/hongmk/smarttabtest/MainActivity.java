package com.example.hongmk.smarttabtest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentStatePagerItemAdapter;


/* Home 화면 구성
* 상단 Tab과 HomeListFragment를 포함하는 ViewPager 연결 및 초기 생성을함.
* */


public class MainActivity extends AppCompatActivity {

    //아래 Stirng 값들이 가지는 것은 단순한 0,1,3...등의 인덱스가 아닌 고유한 객체의 값임
    //다른데서 가져다쓸때는 MainActivity.tab10()[index] 로 가져올 수 있음
    public static int[] tab10() {
        return new int[] {
                R.string.demo_tab_1,
                R.string.demo_tab_2,
                R.string.demo_tab_3,
                R.string.demo_tab_4,
                R.string.demo_tab_5,
                R.string.demo_tab_6,
                R.string.demo_tab_7,
                R.string.demo_tab_8,
                R.string.demo_tab_9,
                R.string.demo_tab_10
        };
    }

    private Toolbar toolbar;
    private ViewPager viewPager;
    private SmartTabLayout viewPagerTab;
    private FragmentPagerItems pages;
    //FragmentPagerItemAdapter 사용 시 첫 생성 할 때 Tab1, Tab2에 모두 position 0으로 생성하므로 FragmentStatePagerItemAdapter 사용함.
    private FragmentStatePagerItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar.setTitle(R.string.demo_title_indicator_trick1); //툴바 제목 표시여부
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);  //왼쪽상단 BackKey 표시여부

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);

        pages = new FragmentPagerItems(this);

        for (int titleResId : tab10()) {
            //pages.add(FragmentPagerItem.of(getString(titleResId), DemoFragment.class));
            pages.add(FragmentPagerItem.of(getString(titleResId), HomeListFragment.class));;
        }

        adapter = new FragmentStatePagerItemAdapter(getSupportFragmentManager(), pages);

        viewPager.setAdapter(adapter);
        viewPagerTab.setViewPager(viewPager);

        //필요하면 아래처럼 리스너를 생성해 탭이 이동할 때 이벤트를 줄 수 있음
//        viewPagerTab.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                //Log.i("[SH]", "SCROLL:"+position);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                //Log.i("[SH]", "SELECTED:"+position);
//                //HomeListFragment.pos = position;
//                //pos = position;
//                //title = getString(tab10()[position]);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                //Log.i("[SH]", "SCROLL CHANGED:"+state);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void createContentClick(View view){
        Toast.makeText(MainActivity.this, "CreateContentClick", Toast.LENGTH_SHORT).show();
    }




}
