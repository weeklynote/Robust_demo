package com.android.robust;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.meituan.robust.Patch;
import com.meituan.robust.PatchExecutor;
import com.meituan.robust.RobustCallBack;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        findViewById(R.id.go).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.hot_fix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PatchExecutor(getApplicationContext(), new PatchManpulateImpl(), new RobustCallBack() {

                    @Override
                    public void onPatchListFetched(boolean result, boolean isNet, List<Patch> patches) {

                    }

                    @Override
                    public void onPatchFetched(boolean result, boolean isNet, Patch patch) {
                        Log.d("liujin", "MainActivity onPatchFetched");
                    }

                    @Override
                    public void onPatchApplied(boolean result, Patch patch) {
                        Log.d("liujin", "MainActivity onPatchApplied");
                    }

                    @Override
                    public void logNotify(String log, String where) {
                        Log.d("liujin", "MainActivity logNotify");
                    }

                    @Override
                    public void exceptionNotify(Throwable throwable, String where) {
                        Log.d("liujin", "MainActivity exceptionNotify:" + where);
                    }
                }).start();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
