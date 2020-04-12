package com.example.signupactivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MproductAdapter extends RecyclerView.Adapter<MproductAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<MProduct> productList;

    public MproductAdapter(Context mCtx, List<MProduct> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        MProduct product = productList.get(position);
        final int pos = position;
        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        // holder.textViewPrice.setText(String.valueOf(product.getPrice()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage(),null));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos == 0){
                    v.getContext().startActivity(new Intent(v.getContext(),MActivity.class));
                }
                else if(pos == 1){
                    v.getContext().startActivity(new Intent(v.getContext(),MActivity1.class));
                }
                else if(pos == 2){
                    v.getContext().startActivity(new Intent(v.getContext(),MActivity2.class));
                }
                else if(pos == 3){
                    v.getContext().startActivity(new Intent(v.getContext(),MActivity3.class));
                }
                else if(pos == 4){
                    v.getContext().startActivity(new Intent(v.getContext(),MActivity4.class));
                }

            }


        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle,textViewDesc, textViewRating ,textViewPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView2);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            // textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewRating = itemView.findViewById(R.id.textViewRating);

        }
    }

}



