package com.trustingbrother.a1stdadiesobrigade;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

@SuppressWarnings("ALL")
class NewTestamentRecyclerViewAdapter extends RecyclerView.Adapter<NewTestamentRecyclerViewAdapter.VideoViewHolder> {
    List<NewTTestamentFragment.Subject> subjects;
    NewTestamentRecyclerViewAdapter(List<NewTTestamentFragment.Subject> subjects){
        this.subjects = subjects;

    }
    private NewTestamentRecyclerViewAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemCliked(int position);

    }

    public  void setOnItemClickedListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView1, textView2, textView3;
        public VideoViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            cardView = itemView.findViewById(R.id.newtestamentrecyclerviewcardview);
            textView1 = itemView.findViewById(R.id.newtestamentrecyclerviewtxt1);
            textView2 = itemView.findViewById(R.id.newtestamentrecyclerviewtxt2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = VideoViewHolder.this.getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemCliked(position);
                        }
                    }
                }
            });


        }
    }
    @NonNull
    @Override
    public NewTestamentRecyclerViewAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.new_testatment_item, parent, false);
        VideoViewHolder cvh = new VideoViewHolder(view, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull NewTestamentRecyclerViewAdapter.VideoViewHolder holder, int position) {
        holder.textView1.setText(subjects.get(position).name);
        holder.textView2.setText(subjects.get(position).name2);


    }


    @Override
    public int getItemCount() {
        return subjects.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
