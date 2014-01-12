package com.example.primetest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
		EditText t = (EditText) findViewById(R.id.input);
		String input_text = t.getText().toString();

		try {
			int n = Integer.parseInt(input_text);

			update_output(test_prime(n), n, false);
		} catch (NumberFormatException e) {
			update_output(false, 0, true);
		}
	}

	public boolean test_prime(int n) {
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		if (n % 2 == 0)
			return false;

		int i = 3;
		while (i * i <= n) {
			if (n % i == 0)
				return false;
			i += 2;
		}

		return true;
	}

	public void update_output(boolean veredict, int n, boolean via_exception) {
		String msg;
		if (via_exception) {
			msg = "The input is not an integer.";
		} else {
			msg = n + " is " + (veredict ? "" : "not ") + "prime.";
		}
		final TextView output = (TextView) findViewById(R.id.output);
		output.setText(msg);
	}

}
