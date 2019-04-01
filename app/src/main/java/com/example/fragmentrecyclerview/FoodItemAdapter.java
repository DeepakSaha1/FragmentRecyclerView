package com.example.fragmentrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.RViewHolder>{
    private List<ItemListModel> myitemListModels;
    ListFragment.Communicator communicator;
    public FoodItemAdapter(List<ItemListModel> itemListModels) {
        this.myitemListModels = itemListModels;
    }

    public void setCommunicator(ListFragment.Communicator communicator) {
        this.communicator = communicator;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.i("MyContactsAdapter","onCreateViewHolder"+ String.valueOf(i));
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item,parent,false);
        return new RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder rViewHolder, int i) {
        final ItemListModel model = myitemListModels.get(i);
        rViewHolder.mFoodName.setText(model.getmFoodName());
        rViewHolder.mResAdd.setText(model.getmResAdd());

        rViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "hekjghxhukj", Toast.LENGTH_SHORT).show();
                Log.i("loe", "check1");
                if(communicator!=null) {
                    Log.i("LOG", "check2");
                    communicator.sendData(model.getmFoodName(), model.getmResAdd());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myitemListModels.size();
    }

    class RViewHolder extends RecyclerView.ViewHolder {
        TextView mFoodName;
        TextView mResAdd;

        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            mFoodName = itemView.findViewById(R.id.food_name_tv);
            mResAdd = itemView.findViewById(R.id.Res_add_tv);
        }

    }
}
