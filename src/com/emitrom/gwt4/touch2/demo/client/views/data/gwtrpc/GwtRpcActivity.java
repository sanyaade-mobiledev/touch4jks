/*******************************************************************************
 * GwtRpcActivity.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.data.gwtrpc;

import com.emitrom.gwt4.touch2.demo.client.activity.KitchenSinkActivity;
import com.emitrom.gwt4.touch2.demo.client.activity.View;
import com.emitrom.gwt4.touch2.demo.client.core.ClientFactory;
import com.emitrom.gwt4.touch2.demo.client.core.Util;
import com.emitrom.gwt4.touch2.demo.client.core.events.SourceUpdateEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class GwtRpcActivity extends KitchenSinkActivity implements View.Presenter {

    private GwtRpcViewImpl view;
    
    public GwtRpcActivity(GwtRpcViewPlace place, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        view = Util.getGwtRpcView();
        view.setPresenter(this);
        panel.setWidget(view);
        eventBus.fireEvent(new SourceUpdateEvent(view.getClass().getName()));
    }

    public void setHtml(String result) {
        view.setHtml("");
        String html = "<textarea name=\"gwtrpc\" class=\"java:nocontrols\" rows=\"15\" cols=\"100\">";
        html += result;
        html += "</textarea>";
        view.setHtml(html);
    }

    public native void highlight() /*-{
		$wnd.dp.SyntaxHighlighter.HighlightAll("gwtrpc");
    }-*/;

}
