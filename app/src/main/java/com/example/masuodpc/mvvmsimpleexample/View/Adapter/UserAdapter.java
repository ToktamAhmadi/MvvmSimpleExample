package com.example.masuodpc.mvvmsimpleexample.View.Adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masuodpc.mvvmsimpleexample.R;
import com.example.masuodpc.mvvmsimpleexample.ViewModel.UserViewModel;
import com.example.masuodpc.mvvmsimpleexample.databinding.ItemUserBinding;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.customeHolder> {

    private ArrayList<UserViewModel> arrayList=new ArrayList<>();
    private LayoutInflater layoutInflater;

    public UserAdapter(ArrayList<UserViewModel> arrayList){
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public customeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       if(layoutInflater==null)
           layoutInflater=LayoutInflater.from(viewGroup.getContext());
       ItemUserBinding itemUserBinding= DataBindingUtil.inflate(layoutInflater, R.layout.item,viewGroup,false);

        return new customeHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull customeHolder customeHolder, int i) {

        UserViewModel userViewModel=arrayList.get(i);
        customeHolder.bind(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    //---------------------
    class customeHolder extends RecyclerView.ViewHolder{


        private ItemUserBinding itemUserBinding;
        public customeHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding=itemUserBinding;
        }
        private void bind(UserViewModel userViewModel){
            this.itemUserBinding.setItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }
        public ItemUserBinding getItemUserBinding(){
            return itemUserBinding;
        }
    }
}
