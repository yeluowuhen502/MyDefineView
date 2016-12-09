package com.mr_mo.mdnavbarview.navbarview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.mr_mo.mdnavbarview.R;
import com.mr_mo.mdnavbarview.navbarview.adapter.MDNavBarSortAdapter;
import com.mr_mo.mdnavbarview.navbarview.impl.INavBarPopupView;
import com.mr_mo.mdnavbarview.navbarview.impl.NavBarPopupSelectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序列表
 * Created by moguangjian on 15/8/4 16:28.
 */
public class MDNavHaveTwoBarPopupSortView extends LinearLayout implements INavBarPopupView {

    private ListView listView;
    private ListView listViewsec;
    private MDNavBarSortAdapter adapter;
    private MDNavBarSortAdapter adapter2;
    private List list;
    private List list2;
    private NavBarPopupFirstSelectListener navBarPopupFirstSelectListener;
    private NavBarPopupSecSelectListener navBarPopupSecSelectListener;
    private int navBarPopupViewHeight = MDNavBarView.NAV_BAR_POPUP_VIEW_HEIGHT_DEFAULT;
    private Context mContext;

    public MDNavHaveTwoBarPopupSortView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public MDNavHaveTwoBarPopupSortView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        list = new ArrayList();
        list2 = new ArrayList();
        NavBarSortModel model = new NavBarSortModel();
        model.setTitle("智能排序");
        model.setIsSelect(false);

        NavBarSortModel model1 = new NavBarSortModel();
        model1.setTitle("离我最近");
        model1.setIsSelect(false);

        NavBarSortModel model2 = new NavBarSortModel();
        model2.setTitle("好评优先");
        model2.setIsSelect(false);

        NavBarSortModel model3 = new NavBarSortModel();
        model3.setTitle("人气最高");
        model3.setIsSelect(false);

        NavBarSortModel model4 = new NavBarSortModel();
        model4.setTitle("折扣最大");
        model4.setIsSelect(false);

        list.add(model);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);

        NavBarSortModel model5 = new NavBarSortModel();
        model5.setTitle("智能排序");
        model5.setIsSelect(false);

        NavBarSortModel model16 = new NavBarSortModel();
        model16.setTitle("离我最近");
        model16.setIsSelect(false);

        NavBarSortModel model7 = new NavBarSortModel();
        model7.setTitle("好评优先");
        model7.setIsSelect(false);

        NavBarSortModel model8 = new NavBarSortModel();
        model8.setTitle("人气最高");
        model8.setIsSelect(false);

        NavBarSortModel model9 = new NavBarSortModel();
        model9.setTitle("折扣最大");
        model9.setIsSelect(false);

        list2.add(model5);
        list2.add(model16);
        list2.add(model7);
        list2.add(model8);
        list2.add(model9);

//        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(mContext).inflate(R.layout.my_testlayout, null);
        listView = (ListView) view.findViewById(R.id.lv_first);
        listViewsec = (ListView) view.findViewById(R.id.lv_second);

//        listView.setLayoutParams(params);
        listView.setDivider(null);
        listView.setCacheColorHint(Color.TRANSPARENT);

//        listViewsec.setLayoutParams(params);
        listViewsec.setDivider(null);
        listViewsec.setCacheColorHint(Color.TRANSPARENT);
        addView(view);

        adapter = new MDNavBarSortAdapter(getContext(), list);
        adapter2 = new MDNavBarSortAdapter(getContext(), list2);
        listView.setAdapter(adapter);
        listViewsec.setAdapter(adapter2);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setSelect(position);
                if (navBarPopupFirstSelectListener != null) {
                    NavBarSortModel model = (NavBarSortModel) list.get(position);
                    int tag = (int) getTag();
                    navBarPopupFirstSelectListener.onSelect(MDNavHaveTwoBarPopupSortView.this, tag, model);
                }
            }
        });

        listViewsec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter2.setSelect(position);
                List temp = list;
                List temp1 = list2;
                if (navBarPopupSecSelectListener != null) {
                    NavBarSortModel model = (NavBarSortModel) list2.get(position);
                    int tag = (int) getTag();
                    navBarPopupSecSelectListener.onSelect(MDNavHaveTwoBarPopupSortView.this, tag, model);
                }
            }
        });
    }

    public void setOnNavBarPopupFirstSelectListener(NavBarPopupFirstSelectListener navBarPopupFirstSelectListener) {
        this.navBarPopupFirstSelectListener = navBarPopupFirstSelectListener;
    }

    public void setOnNavBarPopupSecSelectListener(NavBarPopupSecSelectListener navBarPopupSecSelectListener) {
        this.navBarPopupSecSelectListener = navBarPopupSecSelectListener;
    }

    @Override
    public void setNavBarPopupViewHeight(int height) {
        navBarPopupViewHeight = height;
    }

    @Override
    public int getNavBarPopupViewHeight() {
        return navBarPopupViewHeight;
    }

    @Override
    public void setOnNavBarPopupSelectListener(NavBarPopupSelectListener navBarPopupSelectListener) {
        //原先的抽取。。。
    }

    public interface NavBarPopupFirstSelectListener {
        void onSelect(View view, int index, Object itemData);
    }

    public interface NavBarPopupSecSelectListener {
        void onSelect(View view, int index, Object itemData);
    }

}
