package com.example.fragmentrecyclerview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private List<ItemListModel> myFoodModelList;
    private FoodItemAdapter foodItemAdapter;
    private LinearLayoutManager layoutManager;
    private Communicator communicator;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerViewFoodList = view.findViewById(R.id.recycler_view_list);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewFoodList.setLayoutManager(layoutManager);
        recyclerViewFoodList.setHasFixedSize(true);

        myFoodModelList = new ArrayList<>();
        foodItemAdapter = new FoodItemAdapter(myFoodModelList);

        foodItemAdapter.setCommunicator(communicator);
        recyclerViewFoodList.setAdapter(foodItemAdapter);

        initData();
        foodItemAdapter.notifyDataSetChanged();
    }

    //Initilizing Dummy data
    private void initData() {
        ItemListModel itemListModel;
        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch0");
        itemListModel.setmResAdd("Delhi0");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch1");
        itemListModel.setmResAdd("Delhi1");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch2");
        itemListModel.setmResAdd("Delhi2");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch3");
        itemListModel.setmResAdd("Delhi3");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch4");
        itemListModel.setmResAdd("Delhi4");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch5");
        itemListModel.setmResAdd("Delhi5");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch6");
        itemListModel.setmResAdd("Delhi6");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch7");
        itemListModel.setmResAdd("Delhi7");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch8");
        itemListModel.setmResAdd("Delhi8");
        myFoodModelList.add(itemListModel);

        itemListModel = new ItemListModel();
        itemListModel.setmFoodName("Buttercotch9");
        itemListModel.setmResAdd("Delhi9");
        myFoodModelList.add(itemListModel);
    }

    public void setCommunicator(Communicator communicator){
        this.communicator = communicator;
    }

    interface Communicator {
        void sendData(String name, String add);
    }
}
