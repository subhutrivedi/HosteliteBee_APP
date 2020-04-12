package com.example.signupactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.MyViewHolder>{
    Context context;
    ArrayList<Upload> uploads;

   public UploadAdapter(Context c ,ArrayList<Upload> p)
   {
       context =c;
       uploads = p;
   }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(uploads.get(position).getHostelname());
        holder.address.setText(uploads.get(position).getAddress());
        holder.contact.setText(uploads.get(position).getContactno());
        Picasso.get().load(uploads.get(position).getImgurl()).fit()
                .centerCrop().into(holder.img);

    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,address,contact;
        ImageView img;
        public MyViewHolder(View itemview){
            super(itemview);
            name=(TextView) itemview.findViewById(R.id.textHostelName);
            address=(TextView) itemview.findViewById(R.id.textHostelAddr);
            contact=(TextView) itemview.findViewById(R.id.textHostelContact);
            img=(ImageView) itemview.findViewById(R.id.imageView2);
        }

    }
}
