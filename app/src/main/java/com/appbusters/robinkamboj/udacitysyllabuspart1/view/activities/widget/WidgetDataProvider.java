package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;

import java.util.ArrayList;
import java.util.List;

public class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory{

    private List<Data> data = new ArrayList<>();
    private MyDBHelper dbHelper;
    private Context mContext;

    public WidgetDataProvider(Context mContext, Intent intent) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        dbHelper = new MyDBHelper(mContext);
        data = dbHelper.getAllData();
    }

    @Override
    public void onDataSetChanged() {
        data = dbHelper.getAllData();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews view = new RemoteViews(mContext.getPackageName(), android.R.layout.simple_list_item_2);
        view.setTextColor(android.R.id.text1, Color.BLACK);
        view.setTextColor(android.R.id.text2, Color.BLACK);
        return view;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}