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
class OldTestamentRecyclerViewAdapter extends RecyclerView.Adapter<OldTestamentRecyclerViewAdapter.VideoViewHolder> {
    List<OldTestamentFragment.Subject> subjects;
    OldTestamentRecyclerViewAdapter(List<OldTestamentFragment.Subject> subjects){
        this.subjects = subjects;

    }
    private OldTestamentRecyclerViewAdapter.OnItemClickListener mListener;

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
            cardView = itemView.findViewById(R.id.oldtestamentrecyclerviewcardview);
            textView1 = itemView.findViewById(R.id.oldtestamentrecyclerviewtxt1);
            textView2 = itemView.findViewById(R.id.oldtestamentrecyclerviewtxt2);
            /*
            cardView = itemView.findViewById(R.id.canticlerecyclercard);
            textView1 = itemView.findViewById(R.id.canticlerecyclertxt1);
            textView2 = itemView.findViewById(R.id.canticlerecyclertxt2);
            textView3 = itemView.findViewById(R.id.canticlerecyclertxt3);            */

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
    public OldTestamentRecyclerViewAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.old_testatment_item, parent, false);
        VideoViewHolder cvh = new VideoViewHolder(view, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull OldTestamentRecyclerViewAdapter.VideoViewHolder holder, int position) {
        holder.textView1.setText(subjects.get(position).name);
        holder.textView2.setText(subjects.get(position).name2);
        //holder.textView3.setText(subjects.get(position).name3);


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
