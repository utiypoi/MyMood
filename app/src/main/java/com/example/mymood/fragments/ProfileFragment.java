package com.example.mymood.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mymood.MainActivity;
import com.example.mymood.R;
import com.example.mymood.auth.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container,false);
       EditText email = (EditText) rootView.findViewById(R.id.editTextEmailProfile);
        TextView nameProfile = (TextView) rootView.findViewById(R.id.textViewNameProfile);
       FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
       email.setText(user.getEmail());
       //nameProfile.setText(user.getDisplayName());
        Button exit = (Button) rootView.findViewById(R.id.buttonExitAccount);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        return rootView;
    }
}