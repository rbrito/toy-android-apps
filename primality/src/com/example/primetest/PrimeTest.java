package com.example.primetest;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

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
			long n = Long.parseLong(input_text);

			update_output(test_prime(n), n, false);
		} catch (NumberFormatException e) {
			update_output(false, 0, true);
		}
	}

	public boolean test_prime(long n) {
		if (n == 2 || n == 3)
			return true;
		if (n <= 1 || n % 2 == 0 || n % 3 == 0)
			return false;

		long i = 5;
		int step = 2;
		while (i * i <= n) {
			if (n % i == 0)
				return false;
			step = 6 - step;
			i += step;
		}

		return true;
	}

	public void update_output(boolean veredict, long n, boolean via_exception) {
		String msg;
		if (via_exception) {
			msg = getString(R.string.input_not_integer);
		} else {
			msg = n + " is " + (veredict ? "" : "not ") + "prime.";
		}
		final EditText output = (EditText) findViewById(R.id.input);
		output.setText(msg);
	}

	public void learn_more(View v) {
		String url = "http://primes.utm.edu/";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);

	}

}
