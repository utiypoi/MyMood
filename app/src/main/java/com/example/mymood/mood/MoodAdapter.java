package com.example.mymood.mood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MoodAdapter {

//    private final LayoutInflater inflater;
//    private final List<Mood> moods;
//
//    MoodAdapter(Context context, List<Mood> moods){
//        this.moods = moods;
//        this.inflater = LayoutInflater.from(context);
//    }
//
//    @NonNull
//    @Override
//    public MoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.note_item,parent,false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Mood mood = moods.get(position);
//        holder.title.setText(mood.getTitle());
//        holder.comment.setText(mood.getComment());
//        holder.dateTime.setText(mood.getDateTime());
//    }
//
//    @Override
//    public int getItemCount() {
//        return moods.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder{
//        final String title;
//        final String dateTime;
//        final String comment;
//        ViewHolder(View view){
//            super(view);
//            title = view.findViewById(R.id.item_note_title);
//            comment = view.findViewById(R.id.item_note_comment);
//            dateTime = view.findViewById(R.id.item_note_datetime);
//        }
//
//    }
}
