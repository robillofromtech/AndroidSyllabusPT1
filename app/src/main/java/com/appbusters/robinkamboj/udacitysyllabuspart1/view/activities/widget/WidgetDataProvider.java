package com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import android.widget.Toast;

import com.appbusters.robinkamboj.udacitysyllabuspart1.R;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.controller.MyDBHelper;
import com.appbusters.robinkamboj.udacitysyllabuspart1.view.activities.model.Data;

import java.util.ArrayList;
import java.util.List;

class WidgetDataProvider implements RemoteViewsService.RemoteViewsFactory {

    private List<Data> data;
    private MyDBHelper dbHelper;
    private Context mContext;

    WidgetDataProvider(Context mContext, Intent intent) {
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
//        Log.e("RVF", "OCS");
//        data = new ArrayList<>();
//        dbHelper = new MyDBHelper(mContext);
//        data = dbHelper.getAllData();
//        Toast.makeText(mContext, "SIZE IS " + data.size(), Toast.LENGTH_SHORT).show();
//        Log.e("RVF", "OCS");
        initData();
    }

    @Override
    public void onDataSetChanged() {
//        data = new ArrayList<>();
//        dbHelper = new MyDBHelper(mContext);
//        data = dbHelper.getAllData();
        initData();
    }

    @Override
    public void onDestroy() {

    }

    private void initData() {
        data.clear();
        for (int i = 1; i <= 10; i++) {
            data.add(new Data("ListView Header " + i, "ListView Description " + i));
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
        RemoteViews view = new RemoteViews(mContext.getPackageName(), android.R.layout.simple_list_item_2);
//        view.setTextColor(android.R.id.text1, Color.BLACK);
//        view.setTextColor(android.R.id.text2, Color.BLACK);
        view.setTextViewText(android.R.id.text1, data.get(position).getHeading());
        view.setTextViewText(android.R.id.text2, data.get(position).getDescription());
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
