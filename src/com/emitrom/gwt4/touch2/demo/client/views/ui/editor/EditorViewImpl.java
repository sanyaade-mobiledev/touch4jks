/*******************************************************************************
 * EditorViewImpl.java is part of the Kitchen Sink (for Touch4j 2.2)
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
package com.emitrom.gwt4.touch2.demo.client.views.ui.editor;

import java.util.ArrayList;

import com.emitrom.gwt4.touch2.demo.client.activity.View;
import com.emitrom.gwt4.touch2.demo.client.views.ui.editor.EditorViewImpl.Person;
import com.emitrom.touch4j.client.core.EventObject;
import com.emitrom.touch4j.client.core.config.Dock;
import com.emitrom.touch4j.client.core.handlers.button.TapHandler;
import com.emitrom.touch4j.client.data.BaseModel;
import com.emitrom.touch4j.client.ui.Button;
import com.emitrom.touch4j.client.ui.CheckBox;
import com.emitrom.touch4j.client.ui.DatePicker;
import com.emitrom.touch4j.client.ui.Email;
import com.emitrom.touch4j.client.ui.FieldSet;
import com.emitrom.touch4j.client.ui.FormPanel;
import com.emitrom.touch4j.client.ui.MessageBox;
import com.emitrom.touch4j.client.ui.NumberField;
import com.emitrom.touch4j.client.ui.Password;
import com.emitrom.touch4j.client.ui.Select;
import com.emitrom.touch4j.client.ui.SelectOption;
import com.emitrom.touch4j.client.ui.Slider;
import com.emitrom.touch4j.client.ui.Spinner;
import com.emitrom.touch4j.client.ui.Text;
import com.emitrom.touch4j.client.ui.TextArea;
import com.emitrom.touch4j.client.ui.Toggle;
import com.emitrom.touch4j.client.ui.ToolBar;
import com.emitrom.touch4j.client.ui.Url;
import com.emitrom.touch4j.ux.rating.client.Rating;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsDate;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;

public class EditorViewImpl extends FormPanel implements Editor<Person>, View {

	public interface Driver extends SimpleBeanEditorDriver<Person, EditorViewImpl> {
		
	}

	/**
	 * Editor Fields
	 */
	Text<String> name;
	Password password;
	CheckBox cool;
	Toggle active;
	Slider age;
	Email email;
	TextArea biography;
	Url website;
	Select<String> select;
	DatePicker birthday;
	NumberField<Double> wallet;
	Spinner<Double> spinner;
	Rating rating;

	private ToolBar toolbar;
	private Button saveButton;
	@SuppressWarnings("unused")
	private Presenter presenter;
	
	private static Driver driver = GWT.create(Driver.class);
	private static Person person;

	public EditorViewImpl() {
		
		/**
		 * Init all form elements.
		 */
		initialize();
		
		/**
		 * Init the driver with the editor.
		 */
		driver.initialize(this);

		/**
		 * Create a simple domain object and populate some of its data.
		 */
		person = new Person();
		person.setActive(1);
		person.setAge(2);
		person.setBiography("Emitrom LLC");
		person.setBirthday(JsDate.create(2011, 8, 22));
		person.setCool(true);
		person.setEmail("support@emitrom.com");
		person.setName("Emitrom LLC");
		person.setPassword("Emitrom");
		person.setRating(5);
		person.setSearch("The best");
		person.setSelect("Master");
		person.setSpinner(5);
		person.setWallet(10);
		person.setWebsite("www.emitrom.com");

		/**
		 * Push domain data to the UI.
		 */
		driver.edit(person);

		addListeners();
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	private void initialize() {

		FieldSet fieldset = new FieldSet();

		name = new Text<String>();
		name.setLabel("Name");

		password = new Password();
		password.setLabel("Password");

		cool = new CheckBox();
		cool.setLabel("Cool");

		active = new Toggle();
		active.setLabel("Active");

		age = new Slider();
		age.setLabel("Age");
		age.setMaxValue(100);

		email = new Email();
		email.setLabel("Email");

		biography = new TextArea();
		biography.setLabel("Biography");

		website = new Url();
		website.setLabel("Website");

		select = new Select<String>();
		select.setOptions(RankModel.getOptions());
		select.setName("rank");
		select.setLabel("Rank");

		birthday = new DatePicker();
		birthday.setTitle("Birthday");

		wallet = new NumberField<Double>();
		wallet.setLabel("Wallet");

		spinner = new Spinner<Double>();
		spinner.setLabel("Spinner");

		rating = new Rating();
		rating.setLabel("Rating");

		fieldset.add(rating);
		fieldset.add(name);
		fieldset.add(password);
		fieldset.add(cool);
		fieldset.add(active);
		fieldset.add(age);
		fieldset.add(email);
		fieldset.add(biography);
		fieldset.add(website);
		fieldset.add(select);
		fieldset.add(birthday);
		fieldset.add(wallet);
		fieldset.add(spinner);

		add(fieldset);

		toolbar = new ToolBar(Dock.TOP);
		saveButton = new Button("Save");
		toolbar.add(saveButton);

		add(toolbar);

	}

	/**
	 * Domain Class
	 */
	public static class Person {

		private String name;
		private String password;
		private boolean cool;
		private int active;
		private int age;
		private String email;
		private String search;
		private String biography;
		private String website;
		private String select;
		private JsDate birthday;
		private double wallet;
		private double spinner;
		private int rating;

		public Person() {
		}

		public boolean isCool() {
			return cool;
		}

		public void setCool(boolean cool) {
			this.cool = cool;
		}

		public int getActive() {
			return active;
		}

		public void setActive(int active) {
			this.active = active;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		public String getBiography() {
			return biography;
		}

		public void setBiography(String biography) {
			this.biography = biography;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public String getSelect() {
			return select;
		}

		public void setSelect(String select) {
			this.select = select;
		}

		public JsDate getBirthday() {
			return birthday;
		}

		public void setBirthday(JsDate birthday) {
			this.birthday = birthday;
		}

		public double getWallet() {
			return wallet;
		}

		public void setWallet(double wallet) {
			this.wallet = wallet;
		}

		public double getSpinner() {
			return spinner;
		}

		public void setSpinner(double spinner) {
			this.spinner = spinner;
		}

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

	}
	
	private static class RankModel extends BaseModel {

	    public static ArrayList<SelectOption> getOptions() {
	        ArrayList<SelectOption> ranks = new ArrayList<SelectOption>();
	        ranks.add(new SelectOption("Master", "master"));
	        ranks.add(new SelectOption("Student", "padawan"));
	        ranks.add(new SelectOption("Instructor", "teacher"));
	        ranks.add(new SelectOption("Assistant", "aid"));
	        return ranks;
	    }

	}

	private void addListeners() {
		
		saveButton.addTapHandler(new TapHandler() {
			@Override
			public void onTap(Button button, EventObject event) {
				
				/**
				 * Flush the UI changes to the Domain object.
				 */
				driver.flush();
				
				StringBuilder htmlStr = new StringBuilder();

				htmlStr.append("Name: ");
				htmlStr.append(person.getName());
				htmlStr.append("</br>");

				htmlStr.append("Rating: ");
				htmlStr.append(person.getRating());
				htmlStr.append("</br>");
				
				htmlStr.append("Password: ");
				htmlStr.append(person.getPassword());
				htmlStr.append("</br>");

				htmlStr.append("Cool: ");
				htmlStr.append(person.isCool() ? "Yes" : "No");
				htmlStr.append("</br>");

				htmlStr.append("Active: ");
				htmlStr.append(person.getActive() == 1 ? "Yes" : "No");
				htmlStr.append("</br>");

				htmlStr.append("Age: ");
				htmlStr.append(person.getAge());
				htmlStr.append("</br>");

				htmlStr.append("Email: ");
				htmlStr.append(person.getEmail());
				htmlStr.append("</br>");

				htmlStr.append("Biography: ");
				htmlStr.append(person.getBiography());
				htmlStr.append("</br>");
				
				htmlStr.append("Website: ");
				htmlStr.append(person.getWebsite());
				htmlStr.append("</br>");

				htmlStr.append("Rank: ");
				htmlStr.append(person.getSelect().toUpperCase());
				htmlStr.append("</br>");
				
				htmlStr.append("Birthday: ");
				htmlStr.append(person.getBirthday().toString());
				htmlStr.append("</br>");

				htmlStr.append("Wallet: ");
				htmlStr.append(person.getWallet());
				htmlStr.append("</br>");
				
				htmlStr.append("Spinner: ");
				htmlStr.append(person.getSpinner());
				htmlStr.append("</br>");

				MessageBox.alert(htmlStr.toString());
			}
		});
	}

}