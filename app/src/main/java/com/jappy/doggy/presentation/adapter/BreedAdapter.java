package com.jappy.doggy.presentation.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.jappy.doggy.R;
import com.jappy.doggy.databinding.ItemBreedBinding;
import com.jappy.doggy.domain.model.Breed;
import com.jappy.doggy.domain.model.Dog;
import com.jappy.doggy.domain.model.BreedImage;
import com.jappy.jappy_core.presentation.OnItemClickListener;
import com.jappy.jappy_core.presentation.adapter.BaseListAdapter;
import com.jappy.jappy_core.presentation.adapter.BaseViewHolder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class BreedAdapter extends BaseListAdapter<Object,BreedAdapter.BreedViewHolder> {

    private OnItemClickListener<String> listener;

    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new BreedViewHolder(v);
    }

    public void setOnAddToListListener(OnItemClickListener<String> listener) {
        this.listener=listener;
    }



    public void initializeList(List<String> dog ) {



        list.clear();
        list.addAll(dog);
        notifyDataSetChanged();
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_breed;
    }

    public class BreedViewHolder extends BaseViewHolder<Object,ItemBreedBinding> {
        View view;
        BreedViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;

        }

        @Override
        public void bind(int position, Object item) {
            String puppies = (String) item;
            binder.title.setText(puppies);
            Glide.with(getContext()).load(R.drawable.ic_launcher_foreground).into(binder.thumbnail);
            binder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition(),getItem(getAdapterPosition()).toString());

                }
            });




        }
    }
}
