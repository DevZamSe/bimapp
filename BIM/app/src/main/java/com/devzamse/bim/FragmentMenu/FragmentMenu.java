package com.devzamse.bim.FragmentMenu;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devzamse.bim.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMenu extends Fragment {


    public FragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_menu, container, false);
        return v;
    }

}
