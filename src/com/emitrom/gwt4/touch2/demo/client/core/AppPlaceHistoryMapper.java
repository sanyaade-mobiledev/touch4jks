/*******************************************************************************
 * AppPlaceHistoryMapper.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.core;

import com.emitrom.gwt4.touch2.demo.client.views.animations.AnimationViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.fade.FadeViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.flip.FlipViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.pop.PopViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideDownViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideLeftViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideRightViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideUpViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.ChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.area.AreaChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.bar.BarChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.column.ColumnChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.gauge.GaugeChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.line.LineChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.pie.PieChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.radar.RadarChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.charts.scatter.ScatterChartsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.DataViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.gwtrpc.GwtRpcViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.jsonp.JsonPViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.MediaViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.audio.AudioViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.video.VideoViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.navigation.NavigationViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.themes.ThemeViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.UIViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.bottomtabs.BottomTabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.buttons.ButtonsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.carousel.CarouselViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.editor.EditorViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.form.FormsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.grid.GridViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.icons.IconsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.lists.ListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.maps.MapsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.nestedlists.NestedListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.overlays.OverlaysViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.tabs.TabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.toolbars.ToolBarViewPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({
                // Main view
                NavigationViewPlace.Tokenizer.class, 
                
                // User interface
                UIViewPlace.Tokenizer.class, 
                ListsViewPlace.Tokenizer.class, 
                FormsViewPlace.Tokenizer.class, 
                MapsViewPlace.Tokenizer.class,
                ButtonsViewPlace.Tokenizer.class, 
                ThemeViewPlace.Tokenizer.class, 
                BottomTabsViewPlace.Tokenizer.class,
                CarouselViewPlace.Tokenizer.class, 
                IconsViewPlace.Tokenizer.class,
                NestedListsViewPlace.Tokenizer.class, 
                OverlaysViewPlace.Tokenizer.class, 
                TabsViewPlace.Tokenizer.class,
                ToolBarViewPlace.Tokenizer.class,
                GridViewPlace.Tokenizer.class,
                EditorViewPlace.Tokenizer.class,
                
                // Media
                MediaViewPlace.Tokenizer.class, 
                AudioViewPlace.Tokenizer.class, 
                VideoViewPlace.Tokenizer.class,
                
                // Animation
                AnimationViewPlace.Tokenizer.class,
                SlideViewPlace.Tokenizer.class, 
                SlideLeftViewPlace.Tokenizer.class,
                SlideRightViewPlace.Tokenizer.class, 
                SlideUpViewPlace.Tokenizer.class,
                SlideDownViewPlace.Tokenizer.class,
                FadeViewPlace.Tokenizer.class,
                FlipViewPlace.Tokenizer.class,
                PopViewPlace.Tokenizer.class, 
                
                // Data
                DataViewPlace.Tokenizer.class, 
                GwtRpcViewPlace.Tokenizer.class, 
                JsonPViewPlace.Tokenizer.class,
                
                // Charts
                ChartsViewPlace.Tokenizer.class, 
                LineChartsViewPlace.Tokenizer.class,
                AreaChartsViewPlace.Tokenizer.class, 
                BarChartsViewPlace.Tokenizer.class,
                ColumnChartsViewPlace.Tokenizer.class, 
                GaugeChartsViewPlace.Tokenizer.class,
                PieChartsViewPlace.Tokenizer.class, 
                RadarChartsViewPlace.Tokenizer.class,
                ScatterChartsViewPlace.Tokenizer.class, 
                
                })

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
