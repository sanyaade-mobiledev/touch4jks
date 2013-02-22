/*******************************************************************************
 * ChartsViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
 * 
 * Copyright (c) 2012 Emitrom LLC. All rights reserved.
 *
 * The Kitchen Sink is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Kitchen Sink is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with the Kitchen Sink.  If not, see http://www.emitrom.com/gpl_license
 *  
 * For licensing questions, please contact us at licensing@emitrom.com
 *
 ******************************************************************************/
package com.emitrom.gwt4.touch2.demo.client.views.charts;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch2.demo.client.models.charts.ChartViewModel;
import com.emitrom.gwt4.touch2.demo.client.views.charts.area.AreaChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.bar.BarChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.column.ColumnChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.gauge.GaugeChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.line.LineChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.pie.PieChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.radar.RadarChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.scatter.ScatterChartsViewPlace;
import com.emitrom.touch4j.client.core.handlers.dataview.DataViewItemTapHandler;
import com.emitrom.touch4j.client.core.handlers.list.ItemDisclosureHandler;
import com.emitrom.touch4j.client.data.BaseModel;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.DataView;
import com.emitrom.touch4j.client.ui.DisclosureList;
import com.emitrom.touch4j.client.ui.Panel;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Element;

public class ChartsViewImpl extends Panel implements ChartsView {

    private Presenter presenter;
    private AreaChartsViewPlace areaViewPlace = new AreaChartsViewPlace();
    private BarChartsViewPlace barViewPlace = new BarChartsViewPlace();
    private ColumnChartsViewPlace columnViewPlace = new ColumnChartsViewPlace();
    private GaugeChartsViewPlace gaugeViewPlace = new GaugeChartsViewPlace();
    private LineChartsViewPlace lineViewPlace = new LineChartsViewPlace();
    private PieChartsViewPlace pieViewPlace = new PieChartsViewPlace();
    private RadarChartsViewPlace radarViewPlace = new RadarChartsViewPlace();
    private ScatterChartsViewPlace scatterViewPlace = new ScatterChartsViewPlace();


    public ChartsViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {

        Store store = new Store(getChartsTypeList());
        store.setSorter(ChartViewModel.KEY);
        DisclosureList list = new DisclosureList(ChartViewModel.TEMPLATE, store);
        list.addItemTapHandler(new DataViewItemTapHandler() {

            @Override
            public void onItemTap(DataView dataView, int index, Element element, BaseModel record, Object eventObject,
                            Object eOpts) {
                goToPlace(index);
            }
        });
        list.setOnItemDisclosure(new ItemDisclosureHandler() {

            @Override
            public void onItemDisclosure(BaseModel record, JavaScriptObject node, int index) {
                goToPlace(index);
            }
        });
        add(list);

    }

    private void goToPlace(int index) {
        switch (index) {
            case 0:
                presenter.goTo(areaViewPlace);
                break;
            case 1:
                presenter.goTo(barViewPlace);
                break;
            case 2:
                presenter.goTo(columnViewPlace);
                break;
            case 3:
                presenter.goTo(gaugeViewPlace);
                break;
            case 4:
                presenter.goTo(lineViewPlace);
                break;
            case 5:
                presenter.goTo(pieViewPlace);
                break;
            case 6:
                presenter.goTo(radarViewPlace);
                break;
            case 7:
                presenter.goTo(scatterViewPlace);
                break;
            default:
                break;
        }
    }

    private List<ChartViewModel> getChartsTypeList() {
        
        List<String> modelNames = new ArrayList<String>();
        modelNames.add(areaViewPlace.getToken());
        modelNames.add(barViewPlace.getToken());
        modelNames.add(columnViewPlace.getToken());
        modelNames.add(gaugeViewPlace.getToken());
        modelNames.add(lineViewPlace.getToken());
        modelNames.add(pieViewPlace.getToken());
        modelNames.add(radarViewPlace.getToken());
        modelNames.add(scatterViewPlace.getToken());

        String[] list = modelNames.toArray(new String[0]);

        List<ChartViewModel> models = new ArrayList<ChartViewModel>();
        for (String item : list) {
            models.add(new ChartViewModel(item));
        }

        return models;
        
    }

}
