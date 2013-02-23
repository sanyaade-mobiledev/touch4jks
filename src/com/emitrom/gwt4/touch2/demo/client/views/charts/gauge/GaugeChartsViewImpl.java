/*******************************************************************************
 * GaugeChartsViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.charts.gauge;

import com.emitrom.gwt4.touch2.demo.client.models.charts.ChartsDataUtil;
import com.emitrom.touch4j.charts.client.Animation;
import com.emitrom.touch4j.charts.client.axis.GaugeAxis;
import com.emitrom.touch4j.charts.client.series.GaugeSeries;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.fx.layout.card.Easing;
import com.emitrom.touch4j.client.laf.Color;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.Panel;
import com.emitrom.touch4j.client.ui.Spacer;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.utils.TouchIcons;

public class GaugeChartsViewImpl extends Panel implements GaugeChartsView {

    @SuppressWarnings("unused")
    private Presenter presenter;

    public GaugeChartsViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {

        final Store store = ChartsDataUtil.getData();

        ToolBar toolBar = new ToolBar();
        toolBar.setDocked(Dock.BOTTOM);
        toolBar.setTitle("Gauge");

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
        Animation animation = new Animation(500, Easing.ELASTIC_IN);
        chart.setAnimate(animation);

        GaugeAxis gaugeAxis = new GaugeAxis();
        gaugeAxis.setMinimum(0);
        gaugeAxis.setMaximum(100);
        gaugeAxis.setSteps(10);
        gaugeAxis.setMargin(10);
        chart.addAxis(gaugeAxis);
        chart.drawAxis();

        GaugeSeries gaugeSeries = new GaugeSeries();
        gaugeSeries.setField("data1");
        gaugeSeries.setDonut(55);
        gaugeSeries.setColorSet(new Color("#2582B5"), new Color("#555"));
        chart.addSeries(gaugeSeries);
        chart.drawSeries();

        add(toolBar);
        add(chart);

    }

}