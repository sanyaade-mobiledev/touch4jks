/*******************************************************************************
 * PieChartsViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.charts.pie;

import com.emitrom.gwt4.touch2.demo.client.activity.View;
import com.emitrom.gwt4.touch2.demo.client.models.charts.ChartsDataUtil;
import com.emitrom.touch4j.charts.client.handlers.ItemShowHandler;
import com.emitrom.touch4j.charts.client.interactions.ChartItem;
import com.emitrom.touch4j.charts.client.interactions.ItemInfo;
import com.emitrom.touch4j.charts.client.laf.Label;
import com.emitrom.touch4j.charts.client.series.PieSeries;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.ChartPanel;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class PieChartsViewImpl extends ChartPanel implements View {

    @SuppressWarnings("unused")
    private Presenter presenter;

    public PieChartsViewImpl() {
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {
        
        final Store store = new Store(ChartsDataUtil.getColumnChartValues(5, 20));
        
//        final Chart chart = new Chart(store);
//        chart.setThemeCls("pie1");
//        chart.setTheme(Theme.DEFAULT);
//        chart.setAnimate(true);
//        chart.setInsetPadding(20);
//        chart.setLegend(new Legend(Position.LEFT));

        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setGesture("longpress");
        itemInfo.addItemShowHandler(new ItemShowHandler() {
            @Override
            public void onItemShow(ItemInfo itemInfo, ChartItem item, Panel panel) {
                panel.setHtml("<ul><li>Month: <b>" + item.getStoreItem().get("name") + "</b></li><li>Value : <b>"
                                + "</b></li></ul>");

            }
        });
//        chart.setInteractions(new PieRotate(), new Reset(), new ItemHighlight(), itemInfo);

        PieSeries pieSeries = new PieSeries();
        pieSeries.setAngleField("data1");
        pieSeries.setField("2007");
        pieSeries.setDonut(20);
        pieSeries.setShowInLegend(false);
        pieSeries.setHighlight(true);

        Label label = new Label();
        label.setField("name");
        pieSeries.setLabel(label);

//        chart.setSeries(pieSeries);
        
        Button button = new Button();
        button.setIconCls(TouchIcons.SHUFFLE);
        button.setIconMask(true);
        button.setUi(UI.PLAIN);
        button.addTapHandler(new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                store.setData(ChartsDataUtil.getColumnChartValues(5, 20));
            }
        });
        
        addButton(button);
//        add(chart);

    }

}