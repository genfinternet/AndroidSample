package com.akatastroph.dlclaiterie.view.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.akatastroph.dlclaiterie.model.Product;

/**
 * Created by Genfinternet on 20/11/2016.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {
    Product mProduct;

    public ProductViewHolder(View itemView) {
        super(itemView);
    }

    public void configure(Product product) {
        mProduct = product;
    }

}
