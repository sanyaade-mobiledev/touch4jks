/*******************************************************************************
 * ChartViewModel.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.models.charts;

import com.emitrom.touch4j.client.data.BaseModel;

public class ChartViewModel extends BaseModel {

    public final static String KEY = "chart_view_model_key";
    public final static String TEMPLATE = "{" + KEY + "}";

    public ChartViewModel(String item) {
        setChartViewItem(item);
    }

    public void setChartViewItem(String mainViewItem) {
        set(KEY, mainViewItem);
    }
    
    public String getChartViewItem() {
        return get(KEY);
    }
    
}
