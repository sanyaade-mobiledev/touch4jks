/*******************************************************************************
 * AccelerometerViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.device.accelerometer;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch.client.containers.MessageBox;
import com.emitrom.gwt4.touch.client.containers.Panel;
import com.emitrom.gwt4.touch.client.core.config.XType;
import com.emitrom.gwt4.touch.client.data.Store;
import com.emitrom.gwt4.touch.client.layout.FitLayout;
import com.emitrom.gwt4.touch.ux.grid.client.Grid;
import com.emitrom.gwt4.touch.ux.grid.client.core.GridColumn;
import com.emitrom.gwt4.touch.ux.grid.client.core.GridColumnEditor;
import com.emitrom.gwt4.touch2.demo.client.models.ui.DeviceModel;
import com.emitrom.platform.device.client.accelerometer.Acceleration;
import com.emitrom.platform.device.client.accelerometer.Accelerometer;
import com.emitrom.platform.device.client.core.handlers.accelerometer.AccelerometerHandler;

public class AccelerometerViewImpl extends Panel implements AccelerometerView {

    @SuppressWarnings("unused")
    private Presenter presenter;
    private Grid grid;

    public AccelerometerViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {
        List<GridColumn> columns = new ArrayList<GridColumn>();
        
        GridColumn c = new GridColumn();
        c.setHeader("Axis");
        c.setWidth("40%");
        c.setStyle("padding-left: 1em;");
        c.setDataIndex("key");
        c.setEditor(new GridColumnEditor(XType.TEXT_FIELD));
        columns.add(c);

        c = new GridColumn();
        c.setHeader("Value");
        c.setDataIndex("value");
        c.setStyle("text-align: center;");
        c.setWidth("60%");
        columns.add(c);

        final Store store = new Store(DeviceModel.getAccelerationData(null));
        grid = new Grid(store, columns);
        grid.addTo(this);
        
        Accelerometer.get().getCurrentAcceleration(new AccelerometerHandler() {
            @Override
            public void onError() {
                MessageBox.alert("Error", "Can't get accelerometer data.");
            }
            
            @Override
            public void onSuccess(Acceleration acceleration) {
                store.removeAll();
                store.addAll(DeviceModel.getAccelerationData(acceleration));
            }
        });
    }
    
}
