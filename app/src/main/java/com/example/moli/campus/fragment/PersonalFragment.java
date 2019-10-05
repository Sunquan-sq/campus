package com.example.moli.campus.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moli.campus.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment {

    @Override
        public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_personal, container, false);
        }

}
