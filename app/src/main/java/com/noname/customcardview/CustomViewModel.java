package com.noname.customcardview;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class CustomViewModel extends BaseObservable {

    private CustomModel customModel;

    public CustomViewModel(CustomModel customModel) {
        this.customModel = customModel;
    }

    @Bindable
    public String getText(){
        return customModel.getTxt();
    }

}
