package com.example.mymood.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mymood.AddNoteActivity;
import com.example.mymood.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NoteFragment extends Fragment {

    public NoteFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_note, container, false);
        FloatingActionButton addEntryButton = (FloatingActionButton) rootView.findViewById(R.id.createEntryButton);
        addEntryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNote();
            }
        });
        return rootView;
    }

    public void openAddNote() {
        Intent intent = new Intent(getActivity(), AddNoteActivity.class);
        startActivity(intent);
    }
}