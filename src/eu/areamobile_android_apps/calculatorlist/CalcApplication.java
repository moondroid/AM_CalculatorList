package eu.areamobile_android_apps.calculatorlist;

import java.util.ArrayList;

import android.app.Application;

public class CalcApplication extends Application {

	private ArrayList<String> mItems;

	public ArrayList<String> getItems() {
		return mItems;
	}

	public void setItems(ArrayList<String> mItems) {
		this.mItems = mItems;
	}
	
	
}
