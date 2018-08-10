package com.lee.ttest.draglayout;

public interface Callback {
	void onBefore();

	boolean onRun();

	void onAfter(boolean b);
}
