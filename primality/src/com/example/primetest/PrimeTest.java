package com.example.primetest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class PrimeTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prime_test);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prime_test, menu);
		return true;
	}

	public void test_primality(View v) {
	}
}
