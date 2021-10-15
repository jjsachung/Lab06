package com.chungjessica.lab06;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {
    ViewPager2 mViewPager2;
    int position;
    SeekBar opacity;
    ImageView shibapup, shibadog, retrieverpup, retrieverdog, samoyedpup, samoyeddog;
    public static Fragment newInstance(ViewPager2 mViewPager2, int position) {
        MainFragment fragment = new MainFragment();
        fragment.mViewPager2 = mViewPager2;
        fragment.position = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //add to tablayout
        TabLayout tabLayout = getActivity().findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, mViewPager2,
                (tab, position) -> tab.setText(getResources().getStringArray(R.array.breeds)[position])
        ).attach();
        opacity = view.findViewById(R.id.opacity_seekbar);
        shibapup = view.findViewById(R.id.shiba_puppy);
        shibadog = view.findViewById(R.id.shiba_dog);
        retrieverpup = view.findViewById(R.id.retriever_pup);
        retrieverdog = view.findViewById(R.id.retriever_dog);
        samoyedpup = view.findViewById(R.id.samoyed_puppy);
        samoyeddog = view.findViewById(R.id.samoyed_dog);
        if (position == 0){
            shibapup.setImageAlpha(255);
            shibapup.setAlpha((float)255);
        }
        else if(position == 1){
            retrieverpup.setImageAlpha(255);
            retrieverpup.setAlpha((float)255);
        }
        else{
            samoyedpup.setImageAlpha(255);
            samoyedpup.setAlpha((float)255);
        }
        opacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (position == 0){
                    shibadog.setImageAlpha(i);
                    shibadog.setAlpha((float)i);
                    shibapup.setImageAlpha(255 - i);
                    shibapup.setAlpha((float)(255 - i));
                }
                else if(position == 1){
                    retrieverdog.setImageAlpha(i);
                    retrieverdog.setAlpha((float)i);
                    retrieverpup.setImageAlpha(255 - i);
                    retrieverpup.setAlpha((float)(255 - i));
                }
                else{
                    samoyeddog.setImageAlpha(i);
                    samoyeddog.setAlpha((float)i);
                    samoyedpup.setImageAlpha(255 - i);
                    samoyedpup.setAlpha((float)(255 - i));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
