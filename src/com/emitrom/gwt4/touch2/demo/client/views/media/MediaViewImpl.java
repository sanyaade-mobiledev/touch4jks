/*******************************************************************************
 * MediaViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.media;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch2.demo.client.activity.View;
import com.emitrom.gwt4.touch2.demo.client.models.media.MediaViewModel;
import com.emitrom.gwt4.touch2.demo.client.views.AppPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.audio.AudioViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.media.video.VideoViewPlace;
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

public class MediaViewImpl extends Panel implements View {

    private Presenter presenter;
    private AppPlace audioViewPlace = new AudioViewPlace();
    private AppPlace videoViewPlace = new VideoViewPlace();

    public MediaViewImpl() {
        setLayout(new FitLayout());
        initialize();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void initialize() {

        final Store store = new Store(getMediaViewModels());
        store.setSorter(MediaViewModel.KEY);
        DisclosureList list = new DisclosureList(MediaViewModel.TEMPLATE, store);
        list.setDeselectOnContainerClick(false);
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

    private List<MediaViewModel> getMediaViewModels() {

        String[] mediaItems = { audioViewPlace.getToken(), videoViewPlace.getToken() };
        
        List<MediaViewModel> models = new ArrayList<MediaViewModel>();
        
        for (String mediaItem : mediaItems) {
            models.add(new MediaViewModel(mediaItem));
        }

        return models;

    }

    private void goToPlace(int index) {
        switch(index) {
            case 0:
            	presenter.goTo(audioViewPlace);
                break;
            case 1:
                presenter.goTo(videoViewPlace);
                break;
            case 2:

            default:
                break;
        }
    }
    
}
