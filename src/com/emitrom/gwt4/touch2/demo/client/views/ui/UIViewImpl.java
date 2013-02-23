/*******************************************************************************
 * UIViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.ui;

import java.util.ArrayList;
import java.util.List;

import com.emitrom.gwt4.touch2.demo.client.models.ui.UIViewModel;
import com.emitrom.gwt4.touch2.demo.client.views.AppPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.bottomtabs.BottomTabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.buttons.ButtonsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.carousel.CarouselViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.editor.EditorViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.form.FormsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.grid.GridViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.icons.IconsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.lists.ListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.nestedlists.NestedListsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.overlays.OverlaysViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.tabs.TabsViewPlace;
import com.emitrom.gwt4.touch2.demo.client.views.ui.toolbars.ToolBarViewPlace;
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

public class UIViewImpl extends Panel implements UIView {

	private Presenter presenter;
	private AppPlace buttonsViewPlace = new ButtonsViewPlace();
	private AppPlace formsViewPlace = new FormsViewPlace();
	private AppPlace listsViewPlace = new ListsViewPlace();
	private AppPlace nestedListsViewPlace = new NestedListsViewPlace();
	private AppPlace iconsViewPlace = new IconsViewPlace();
	private AppPlace toolBarViewPlace = new ToolBarViewPlace();
	private AppPlace carouselViewPlace = new CarouselViewPlace();
	private AppPlace tabsViewPlace = new TabsViewPlace();
	private AppPlace bottomTabsViewPlace = new BottomTabsViewPlace();
	private AppPlace overlaysViewPlace = new OverlaysViewPlace();
	private AppPlace gridViewPlace = new GridViewPlace();
	private AppPlace editorViewPlace = new EditorViewPlace();

	public UIViewImpl() {
		setLayout(new FitLayout());
		initialize();
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	private void initialize() {

		final Store store = new Store(getUIViewModels());
		store.setSorter(UIViewModel.KEY);
		DisclosureList list = new DisclosureList(UIViewModel.TEMPLATE, store);
		list.setDeselectOnContainerClick(false);
		list.addItemTapHandler(new DataViewItemTapHandler() {

			@Override
			public void onItemTap(DataView dataView, int index,
					Element element, BaseModel record, Object eventObject,
					Object eOpts) {
				goToPlace(index);
			}
		});
		list.setOnItemDisclosure(new ItemDisclosureHandler() {

			@Override
			public void onItemDisclosure(BaseModel record,
					JavaScriptObject node, int index) {
				goToPlace(index);
			}
		});

		add(list);

	}

	private List<UIViewModel> getUIViewModels() {

		String[] uiItems = { buttonsViewPlace.getToken(),
				formsViewPlace.getToken(), listsViewPlace.getToken(),
				nestedListsViewPlace.getToken(), iconsViewPlace.getToken(),
				toolBarViewPlace.getToken(), carouselViewPlace.getToken(),
				tabsViewPlace.getToken(), bottomTabsViewPlace.getToken(),
				overlaysViewPlace.getToken(), gridViewPlace.getToken(),
				editorViewPlace.getToken() };

		List<UIViewModel> models = new ArrayList<UIViewModel>();

		for (String uiItem : uiItems) {
			models.add(new UIViewModel(uiItem));
		}

		return models;

	}

	private void goToPlace(int index) {

		switch (index) {
		case 0:
			presenter.goTo(buttonsViewPlace);
			break;
		case 1:
			presenter.goTo(formsViewPlace);
			break;
		case 2:
			presenter.goTo(listsViewPlace);
			break;
		case 3:
			presenter.goTo(nestedListsViewPlace);
			break;
		case 4:
			presenter.goTo(iconsViewPlace);
			break;
		case 5:
			presenter.goTo(toolBarViewPlace);
			break;
		case 6:
			presenter.goTo(carouselViewPlace);
			break;
		case 7:
			presenter.goTo(tabsViewPlace);
			break;
		case 8:
			presenter.goTo(bottomTabsViewPlace);
			break;
		case 9:
			presenter.goTo(overlaysViewPlace);
			break;
		case 10:
			presenter.goTo(gridViewPlace);
			break;
		case 11:
			presenter.goTo(editorViewPlace);
			break;

		default:
			break;
		}

	}

}
