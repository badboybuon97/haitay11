package com.example.appnhac.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

import com.example.appnhac.Adapter.DanhsachcacplaylistAdapter;
import com.example.appnhac.Model.Playlist;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachcacplaylistActivity extends AppCompatActivity {
                    Toolbar toolbar;
                    RecyclerView recyclerViewdanhsachcacplaylist;
                    DanhsachcacplaylistAdapter danhsachcacplaylistAdapter;
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_danhsachcacplaylist);
                        anhxa();
                        init();
                        GetData();
                    }

                    private void GetData() {
                        Dataservice dataservice = APIService.getService();
                        Call<List<Playlist>> callback=dataservice.GetDanhsachcacPlaylist();
                        callback.enqueue(new Callback<List<Playlist>>() {
                            @Override
                            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                                ArrayList<Playlist> mangplaylist= (ArrayList<Playlist>) response.body();
                                danhsachcacplaylistAdapter=new DanhsachcacplaylistAdapter(DanhsachcacplaylistActivity.this,mangplaylist);
                                recyclerViewdanhsachcacplaylist.setLayoutManager(new GridLayoutManager(DanhsachcacplaylistActivity.this,2));
                                recyclerViewdanhsachcacplaylist.setAdapter(danhsachcacplaylistAdapter);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Play Lists");
        toolbar.setTitleTextColor(getResources().getColor(R.color.mautim));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void anhxa() {
        toolbar=findViewById(R.id.toolbardanhsachcacplaylist);
        recyclerViewdanhsachcacplaylist=findViewById(R.id.recyclerviewdanhsachcacplaylist);

    }
}
