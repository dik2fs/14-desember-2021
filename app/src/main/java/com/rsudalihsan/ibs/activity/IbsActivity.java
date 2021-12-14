package com.rsudalihsan.ibs.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.rsudalihsan.ibs.R;
import com.rsudalihsan.ibs.adapter.IbsAdapter;
import com.rsudalihsan.ibs.helper.MyDividerItemDecoration;
import com.rsudalihsan.ibs.model.IbsDataItem;
import com.rsudalihsan.ibs.model.IbsResponse;
import com.rsudalihsan.ibs.rest.ApiClient;
import com.rsudalihsan.ibs.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IbsActivity extends AppCompatActivity {

    private ApiInterface apiService;
    private ArrayAdapter adapter;

    private SwipeRefreshLayout swiperefreshlayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibs);
        swiperefreshlayout = findViewById(R.id.swiperefreshlayout);
        recyclerView = findViewById(R.id.rv);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(getApplicationContext(), LinearLayoutManager.VERTICAL, 16));
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                (IbsActivity.this).adapter.getFilter();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        doApicall();
        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.setAdapter(null);
                doApicall();
            }
        });
    }

    private void doApicall(){
        swiperefreshlayout.setRefreshing(true);
        Call<IbsResponse> call = apiService.getIbs();
        call.enqueue(new Callback<IbsResponse>() {
            @Override
            public void onResponse(Call<IbsResponse> call, Response<IbsResponse> response) {
                int statusCode = response.code();
                System.out.println("test=>"+new Gson().toJson(response.body().getResponse()));
                List<IbsDataItem> list = response.body().getResponse();
                IbsAdapter adapter = new IbsAdapter(list, getApplicationContext());
                recyclerView.setAdapter(adapter);
                swiperefreshlayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<IbsResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e("MainActivity", t.toString());
                Toast.makeText(getApplicationContext(), "Error:\n"+t.toString(), Toast.LENGTH_SHORT).show();
                swiperefreshlayout.setRefreshing(false);
            }
        });
    }
}