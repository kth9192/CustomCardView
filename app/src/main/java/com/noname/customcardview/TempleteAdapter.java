package com.noname.customcardview;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.noname.customcardview.databinding.RecyclerItemBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TempleteAdapter extends RecyclerView.Adapter {

    private static String TAG = TempleteAdapter.class.getName();
    private ArrayList<CustomViewModel> mList = new ArrayList<>();

    public TempleteAdapter(ArrayList<CustomModel> modelList) {

        for (CustomModel customModel : modelList){
            mList.add(new CustomViewModel(customModel));
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof CustomViewHolder){

            ((CustomViewHolder) holder).getRecyclerItemBinding().setViewModel(mList.get(position));
            ((CustomViewHolder) holder).getRecyclerItemBinding().executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size(): 0;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {


        private RecyclerItemBinding recyclerItemBinding;

        public CustomViewHolder(View itemView) {
            super(itemView);
            recyclerItemBinding = DataBindingUtil.bind(itemView);
        }

        public RecyclerItemBinding getRecyclerItemBinding() {
            return recyclerItemBinding;
        }
    }
}
