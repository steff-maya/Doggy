package com.jappy.doggy.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.core.BuildConfig;
import com.jappy.doggy.R;
import com.jappy.doggy.databinding.ItemBreedBinding;
import com.jappy.doggy.databinding.ItemRecycelImageBinding;
import com.jappy.jappy_core.presentation.adapter.BaseListAdapter;
import com.jappy.jappy_core.presentation.adapter.BaseViewHolder;

import java.util.List;

/**
 * Created by irenecedeno on 10-02-18.
 */

public class ImageCardAdapter extends BaseListAdapter<Object, ImageCardAdapter.PuppiesImageViewHolder> {


    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new PuppiesImageViewHolder(v);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_recycel_image;
    }

    public void initializeList(List<String> images) {
        list.clear();
        list.addAll(images);
        notifyDataSetChanged();
    }

    public class PuppiesImageViewHolder extends BaseViewHolder<Object, ItemRecycelImageBinding> {
        View view;

        PuppiesImageViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            view.setLayoutParams(new RecyclerView.LayoutParams((int) (displayMetrics.widthPixels * 0.7f), (int) (displayMetrics.heightPixels * 0.8f)));

        }

        @Override
        public void bind(int position, Object item) {
            String puppies = (String) item;
            Glide.with(getContext()).load(puppies).into(binder.imageView);

            // holder.itemView.setTag(position);


        }
    }
}
