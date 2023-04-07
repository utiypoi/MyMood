package com.example.mymood.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mymood.Affirmation;
import com.example.mymood.AffirmationAdapter;
import com.example.mymood.AffirmationRecyclerViewInterface;
import com.example.mymood.DetailAffirmationActivity;
import com.example.mymood.R;

import java.util.ArrayList;

public class AffirmationFragment extends Fragment implements AffirmationRecyclerViewInterface {
    private RecyclerView recyclerView;
    ArrayList<Affirmation> affirmations = new ArrayList<Affirmation>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_affirmation, container, false);
        setInitialData();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclingViewAffirmation);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        //recyclerView.setHasFixedSize(true);
        AffirmationAdapter adapter = new AffirmationAdapter(getContext(), affirmations, this);
        recyclerView.setAdapter(adapter);
//        AffirmationAdapter.onAffirmationClickListener onAffirmationClickListener = new AffirmationAdapter.onAffirmationClickListener() {
//            @Override
//            public void onAffirmationClick(Affirmation affirmation) {
//                Intent intent = new Intent(getActivity(), DetailAffirmationActivity.class);
//                intent.putExtra(DetailAffirmationActivity.AFFIRMATION_ID, affirmation.getId());
//                startActivity(intent);
//            }
//        };

        return rootView;
    }


    private void setInitialData() {
        affirmations.add(new Affirmation(1,"Здоровье","Аффирмация для поднятия духа и увеличении силы", "4 минуты", R.drawable.heal_affir, R.raw.affirmation_health));
        affirmations.add(new Affirmation(2,"Здоровье","Аффирмация для поднятия духа и увеличении силы", "4 минуты", R.drawable.heal_affir, R.raw.affirmation_health));
        affirmations.add(new Affirmation(3,"Здоровье","Аффирмация для поднятия духа и увеличении силы", "4 минуты", R.drawable.heal_affir, R.raw.affirmation_health));
        affirmations.add(new Affirmation(4,"Здоровье","Аффирмация для поднятия духа и увеличении силы", "4 минуты", R.drawable.heal_affir, R.raw.affirmation_health));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(),DetailAffirmationActivity.class);
        intent.putExtra("Title",affirmations.get(position).getTitleAffirmation());
        intent.putExtra("Time", affirmations.get(position).getTime());
        intent.putExtra("Description", affirmations.get(position).getDescription());
        intent.putExtra("Photo", affirmations.get(position).getPhoto());
        startActivity(intent);
    }
}