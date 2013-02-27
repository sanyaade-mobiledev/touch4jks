/*******************************************************************************
 * AppActivityMapper.java is part of the Kitchen Sink (for Touch4j 2.2)
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

import com.emitrom.gwt4.touch2.demo.client.KitchenSinkEntryPoint;
import com.emitrom.gwt4.touch2.demo.client.views.AppPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.AnimationActivity;
import com.emitrom.gwt4.touch2.demo.client.views.animations.AnimationViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.fade.FadeActivity;
import com.emitrom.gwt4.touch2.demo.client.views.animations.fade.FadeViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.flip.FlipActivity;
import com.emitrom.gwt4.touch2.demo.client.views.animations.flip.FlipViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.pop.PopActivity;
import com.emitrom.gwt4.touch2.demo.client.views.animations.pop.PopViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideActivity;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideDownViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideLeftViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideRightViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideUpViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.animations.slide.SlideViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.DataActivity;
import com.emitrom.gwt4.touch2.demo.client.views.data.DataViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.gwtrpc.GwtRpcActivity;
import com.emitrom.gwt4.touch2.demo.client.views.data.gwtrpc.GwtRpcViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.data.jsonp.JsonPActivity;
import com.emitrom.gwt4.touch2.demo.client.views.data.jsonp.JsonPViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.MediaActivity;
import com.emitrom.gwt4.touch2.demo.client.views.media.MediaViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.audio.AudioActivity;
import com.emitrom.gwt4.touch2.demo.client.views.media.audio.AudioViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.video.VideoActivity;
import com.emitrom.gwt4.touch2.demo.client.views.media.video.VideoViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.navigation.NavigationActivity;
import com.emitrom.gwt4.touch2.demo.client.views.navigation.NavigationViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.themes.ThemeActivity;
import com.emitrom.gwt4.touch2.demo.client.views.themes.ThemeViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.UIActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.UIViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.bottomtabs.BottomTabsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.bottomtabs.BottomTabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.buttons.ButtonsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.buttons.ButtonsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.carousel.CarouselActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.carousel.CarouselViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.editor.EditorActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.editor.EditorViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.form.FormsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.form.FormsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.grid.GridActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.grid.GridViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.icons.IconsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.icons.IconsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.lists.ListsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.lists.ListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.nestedlists.NestedListsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.nestedlists.NestedListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.overlays.OverlaysActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.overlays.OverlaysViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.tabs.TabsActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.tabs.TabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.toolbars.ToolBarActivity;
import com.emitrom.gwt4.touch2.demo.client.views.ui.toolbars.ToolBarViewPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {

        KitchenSinkEntryPoint.getToolBar().setTitle(((AppPlace) place).getToken());
        
        if (place instanceof NavigationViewPlace)
            return new NavigationActivity((NavigationViewPlace) place, clientFactory);
        if (place instanceof UIViewPlace)
            return new UIActivity((UIViewPlace) place, clientFactory);
        if (place instanceof AnimationViewPlace)
            return new AnimationActivity((AnimationViewPlace) place, clientFactory);
        if (place instanceof DataViewPlace)
            return new DataActivity((DataViewPlace) place, clientFactory);
        if (place instanceof GwtRpcViewPlace)
            return new GwtRpcActivity((GwtRpcViewPlace) place, clientFactory);
        if (place instanceof JsonPViewPlace)
            return new JsonPActivity((JsonPViewPlace) place, clientFactory);
        if (place instanceof ListsViewPlace)
            return new ListsActivity((ListsViewPlace) place, clientFactory);
        if (place instanceof FormsViewPlace)
            return new FormsActivity((FormsViewPlace) place, clientFactory);
        if (place instanceof ButtonsViewPlace)
            return new ButtonsActivity((ButtonsViewPlace) place, clientFactory);
        if (place instanceof ThemeViewPlace)
            return new ThemeActivity((ThemeViewPlace) place, clientFactory);
        if (place instanceof BottomTabsViewPlace)
            return new BottomTabsActivity((BottomTabsViewPlace) place, clientFactory);
        if (place instanceof CarouselViewPlace)
            return new CarouselActivity((CarouselViewPlace) place, clientFactory);
        if (place instanceof IconsViewPlace)
            return new IconsActivity((IconsViewPlace) place, clientFactory);
        if (place instanceof NestedListsViewPlace)
            return new NestedListsActivity((NestedListsViewPlace) place, clientFactory);
        if (place instanceof OverlaysViewPlace)
            return new OverlaysActivity((OverlaysViewPlace) place, clientFactory);
        if (place instanceof TabsViewPlace)
            return new TabsActivity((TabsViewPlace) place, clientFactory);
        if (place instanceof ToolBarViewPlace)
            return new ToolBarActivity((ToolBarViewPlace) place, clientFactory);
        if (place instanceof MediaViewPlace)
            return new MediaActivity((MediaViewPlace) place, clientFactory);
        if (place instanceof VideoViewPlace)
            return new VideoActivity((VideoViewPlace) place, clientFactory);
        if (place instanceof AudioViewPlace)
            return new AudioActivity((AudioViewPlace) place, clientFactory);
        if (place instanceof SlideViewPlace)
            return new SlideActivity((SlideViewPlace) place, clientFactory);
        if (place instanceof SlideLeftViewPlace)
            return new SlideActivity((SlideLeftViewPlace) place, clientFactory);
        if (place instanceof SlideRightViewPlace)
            return new SlideActivity((SlideRightViewPlace) place, clientFactory);
        if (place instanceof SlideUpViewPlace)
            return new SlideActivity((SlideUpViewPlace) place, clientFactory);
        if (place instanceof SlideDownViewPlace)
            return new SlideActivity((SlideDownViewPlace) place, clientFactory);
        if (place instanceof GridViewPlace)
            return new GridActivity((GridViewPlace) place, clientFactory);
        if (place instanceof FadeViewPlace)
            return new FadeActivity((FadeViewPlace) place, clientFactory);
        if (place instanceof FlipViewPlace)
            return new FlipActivity((FlipViewPlace) place, clientFactory);
        if (place instanceof PopViewPlace)
            return new PopActivity((PopViewPlace) place, clientFactory);
        if (place instanceof EditorViewPlace)
            return new EditorActivity((EditorViewPlace) place, clientFactory);
        
            return null;

    }

}
