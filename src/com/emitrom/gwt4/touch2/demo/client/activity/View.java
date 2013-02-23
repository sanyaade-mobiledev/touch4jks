package com.emitrom.gwt4.touch2.demo.client.activity;

import com.google.gwt.place.shared.Place;

public interface View {

	public void setPresenter(Presenter presenter);

	public interface Presenter {
		public void goTo(Place place);
	}

}
