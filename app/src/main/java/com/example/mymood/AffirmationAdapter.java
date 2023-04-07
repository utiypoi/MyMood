package com.example.mymood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AffirmationAdapter extends RecyclerView.Adapter<AffirmationAdapter.ViewHolder> {

    private final AffirmationRecyclerViewInterface recyclerViewInterface;
    private final LayoutInflater inflater;
    private final List<Affirmation> affirmations;

    public AffirmationAdapter(Context context, List<Affirmation> affirmations, AffirmationRecyclerViewInterface recyclerViewInterface) {
        this.affirmations = affirmations;
        this.inflater = LayoutInflater.from(context);
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AffirmationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.affirmation_item, parent, false);
        return new ViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AffirmationAdapter.ViewHolder holder, int position) {
        Affirmation affirmation = affirmations.get(position);
        holder.titleAffirmation.setText(affirmation.getTitleAffirmation());
        holder.timeAffirmation.setText(affirmation.getTime());
        holder.description.setText(affirmation.getDescription());
        holder.photoAffirmation.setImageResource(affirmation.getPhoto());
    }

    @Override
    public int getItemCount() {
        return affirmations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView photoAffirmation;
        final TextView titleAffirmation;
        final TextView timeAffirmation;
        final TextView description;

        public ViewHolder(View view, AffirmationRecyclerViewInterface recyclerViewInterface) {
            super(view);
            photoAffirmation = view.findViewById(R.id.photoAffirmationImageView);
            titleAffirmation = view.findViewById(R.id.titleAffirmationTextView);
            timeAffirmation = view.findViewById(R.id.timeAffirmationTextView);
            description = view.findViewById(R.id.descriptionAffirmationTextView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}


