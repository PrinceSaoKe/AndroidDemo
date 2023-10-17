package com.saoke.androiddemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class UpListAdapter extends RecyclerView.Adapter<UpListAdapter.MyViewHolder> {

    private final Context context;
    public List<Up> data;

    public UpListAdapter(Context context, List<Up> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.up_list_data, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.upName.setText(data.get(i).getName());
        myViewHolder.upAvatar.setImageResource(data.get(i).getAvatarResourceId());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView upName;
        private final ImageView upAvatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            upName = itemView.findViewById(R.id.up_name);
            upAvatar = itemView.findViewById(R.id.up_avatar);
        }
    }
}
