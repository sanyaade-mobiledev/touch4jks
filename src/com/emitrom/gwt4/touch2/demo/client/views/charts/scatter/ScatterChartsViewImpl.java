/*******************************************************************************
 * ScatterChartsViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.charts.scatter;

import com.emitrom.gwt4.touch2.demo.client.models.charts.ChartsDataUtil;
import com.emitrom.touch4j.charts.client.axis.CategoryAxis;
import com.emitrom.touch4j.charts.client.axis.NumericAxis;
import com.emitrom.touch4j.charts.client.series.ScatterSeries;
import com.emitrom.touch4j.charts.client.theme.Theme;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.Alignment;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.Spacer;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class ScatterChartsViewImpl extends Panel implements ScatterChartsView {

    @SuppressWarnings("unused")
    private Presenter presenter;

    public ScatterChartsViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {

        final Store store = new Store(ChartsDataUtil.getChartValues1(5, 20));

        ToolBar toolBar = new ToolBar();
        toolBar.setTitle("Scatter");
        toolBar.setDocked(Dock.BOTTOM);

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
        toolBar.add(new Spacer());
        toolBar.add(button);

        Chart chart = new Chart(store);
        chart.setTheme(Theme.DEFAULT);
        chart.setThemeCls("scatter1");
        chart.setAnimate(true);

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setFields("data1", "data2", "data3");
        numericAxis.setTitle("Number of Hits");
        chart.addAxis(numericAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setFields("name");
        categoryAxis.setTitle("Month of the year");
        chart.addAxis(categoryAxis);
        chart.drawAxis();

        ScatterSeries series = new ScatterSeries();
        series.setAxis(Alignment.LEFT, Alignment.BOTTOM);
        series.setXField("name");
        series.setYField("data1");
        chart.addSeries(series);

        series = new ScatterSeries();
        series.setAxis(Alignment.LEFT, Alignment.BOTTOM);
        series.setXField("name");
        series.setYField("data2");
        chart.addSeries(series);

        series = new ScatterSeries();
        series.setAxis(Alignment.LEFT, Alignment.BOTTOM);
        series.setXField("name");
        series.setYField("data3");
        chart.addSeries(series);
        chart.drawSeries();

        add(toolBar);
        add(chart);

    }

}