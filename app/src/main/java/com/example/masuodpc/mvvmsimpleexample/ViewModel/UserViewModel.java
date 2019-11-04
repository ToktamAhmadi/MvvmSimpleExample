package com.example.masuodpc.mvvmsimpleexample.ViewModel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.masuodpc.mvvmsimpleexample.Model.User;
import com.example.masuodpc.mvvmsimpleexample.BR;
import com.example.masuodpc.mvvmsimpleexample.View.Adapter.UserAdapter;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable
{
    private String name;
    private String phone;

    private Context context;
    private MutableLiveData<ArrayList<UserViewModel>> mutableLiveData=new MutableLiveData<>();
    private ArrayList<UserViewModel> arrayList=new ArrayList<>();


    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();
    }
    public UserViewModel(Context context) {
        this.context=context;
        //connect to server
        for(int i=1;i<20;i++)

        {
            User users=new User ("user: "+i,"phone: 09123456");
            UserViewModel userViewModel=new UserViewModel(users);
            arrayList.add(userViewModel);
        }
        mutableLiveData.setValue(arrayList);

    }
    @BindingAdapter("bind:recyclerUser")
    public static void recyclerviewBinder(final RecyclerView recyclerView, final MutableLiveData<ArrayList<UserViewModel>> listMutableLiveData){

       listMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
           @Override
           public void onChanged(@Nullable ArrayList<UserViewModel> arrayList) {
               UserAdapter userAdapter=new UserAdapter(arrayList);
               recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),LinearLayoutManager.VERTICAL,false));
               recyclerView.setAdapter(userAdapter);

           }
       });
         }


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




    public MutableLiveData<ArrayList<UserViewModel>> getMutableLiveData() {
        return mutableLiveData;
    }
}
