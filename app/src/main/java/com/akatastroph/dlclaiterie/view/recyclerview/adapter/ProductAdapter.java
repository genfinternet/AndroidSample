package com.akatastroph.dlclaiterie.view.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akatastroph.dlclaiterie.R;
import com.akatastroph.dlclaiterie.model.Product;
import com.akatastroph.dlclaiterie.view.recyclerview.viewholder.ProductViewHolder;

import java.util.ArrayList;

/**
 * Created by Genfinternet on 20/11/2016.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    ArrayList<Product> mProducts;

    public ProductAdapter(ArrayList<Product> products) {
        mProducts = products;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.configure(mProducts.get(position));
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
