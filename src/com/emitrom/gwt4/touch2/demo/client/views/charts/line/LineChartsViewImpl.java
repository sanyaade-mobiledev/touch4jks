/*******************************************************************************
 * LineChartsViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.charts.line;

import com.emitrom.touch4j.charts.client.Chart;
import com.emitrom.touch4j.charts.client.HighLight;
import com.emitrom.touch4j.charts.client.Legend;
import com.emitrom.touch4j.charts.client.axis.CategoryAxis;
import com.emitrom.touch4j.charts.client.axis.NumericAxis;
import com.emitrom.touch4j.charts.client.handlers.ItemShowHandler;
import com.emitrom.touch4j.charts.client.interactions.ChartItem;
import com.emitrom.touch4j.charts.client.interactions.ItemInfo;
import com.emitrom.touch4j.charts.client.interactions.PanZoom;
import com.emitrom.touch4j.charts.client.laf.GridConfig;
import com.emitrom.touch4j.charts.client.laf.SpriteConfig;
import com.emitrom.touch4j.charts.client.marker.Circle;
import com.emitrom.touch4j.charts.client.marker.Cross;
import com.emitrom.touch4j.charts.client.series.LineSeries;
import com.emitrom.touch4j.client.containers.Panel;
import com.emitrom.touch4j.client.containers.ToolBar;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.Store;
import com.emitrom.touch4j.client.laf.Alignment;
import com.emitrom.touch4j.client.laf.Color;
import com.emitrom.touch4j.client.laf.Position;
import com.emitrom.touch4j.client.laf.UI;
import com.emitrom.touch4j.client.layout.FitLayout;
import com.emitrom.touch4j.client.utils.TouchIcons;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.widgets.Spacer;
import com.emitrom.touch4j2.demo.client.models.charts.ChartsDataUtil;

public class LineChartsViewImpl extends Panel implements LineChartsView {

    private Button reloadButton;

    @SuppressWarnings("unused")
    private Presenter presenter;

    public LineChartsViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {

        ToolBar toolBar = new ToolBar(Dock.BOTTOM);
        toolBar.add(new Spacer());

        reloadButton = new Button();
        reloadButton.setIconCls(TouchIcons.SHUFFLE);
        reloadButton.setIconMask(true);
        reloadButton.setUi(UI.PLAIN);
        toolBar.add(reloadButton);

        add(toolBar);
        add(createLineChart());

    }

    private Chart createLineChart() {

        final Store chartStore = ChartsDataUtil.getData();
        Chart chart = new Chart(chartStore);
        chart.setAnimate(true);
        chart.setLegend(new Legend(Position.RIGHT));

        NumericAxis numericAxis = new NumericAxis();
        numericAxis.setTitle("Number of Hits");

        SpriteConfig config = new SpriteConfig();
        config.setOpacity(1);
        config.setFill(new Color("#ddd"));
        config.setStroke(new Color("#bbb"));
        config.setStrokeWidth(0.5);

        numericAxis.setGrid(new GridConfig(config));
        numericAxis.setMinimum(0);
        numericAxis.setMaximum(100);
        numericAxis.setMinorTickSteps(1);
        numericAxis.setPosition(Position.LEFT);
        numericAxis.setFields("data1", "data2", "data3");

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.setPosition(Position.BOTTOM);
        categoryAxis.setTitle("Month of the year");
        categoryAxis.setFields("name");

        chart.setAxes(numericAxis, categoryAxis);

        LineSeries series = new LineSeries();
        series.setXField("name");
        series.setYField("data1");
        series.setAxis(Alignment.LEFT);
        series.setFill(true);
        series.setHighlight(new HighLight(7, 7));
        series.setMarker(new Cross(4, 4));
        series.setSmooth(true);
        chart.addSeries(series);

        series = new LineSeries();
        series.setXField("name");
        series.setYField("data2");
        series.setAxis(Alignment.LEFT);
        series.setHighlight(new HighLight(7, 7));
        series.setMarker(new Circle(4, 4));
        series.setSmooth(true);
        chart.addSeries(series);

        series = new LineSeries();
        series.setXField("name");
        series.setYField("data3");
        series.setAxis(Alignment.LEFT);
        series.setFill(true);
        series.setHighlight(new HighLight(7, 7));
        series.setMarker(new Circle(4, 4));
        series.setSmooth(true);
        chart.addSeries(series);

        chart.drawSeries();

        ItemInfo itemInfo = new ItemInfo();
        itemInfo.addItemShowHandler(new ItemShowHandler() {
            @Override
            public void onItemShow(ItemInfo itemInfo, ChartItem item, Panel panel) {
                panel.setHtml("<ul><li>Month: <b>" + item.getStoreItem().get("name") + "</b></li><li>Value : <b>"
                                + item.getValue().getString(1) + "</b></li></ul>");
            }
        });
        chart.addInteraction(itemInfo);
        chart.addInteraction(new PanZoom());

        reloadButton.addTapHandler(new TapHandler() {
            @Override
            public void onTap(Button button, EventObject event) {
                chartStore.setData(ChartsDataUtil.getChartValues1(6, 20));
            }
        });

        return chart;

    }

}