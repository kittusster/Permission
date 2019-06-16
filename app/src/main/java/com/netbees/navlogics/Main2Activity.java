package com.netbees.navlogics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.netbees.navlogics.ApiService.RetrofitClientInstance;
import com.netbees.navlogics.Apiinterfaces.GetDataService;
import com.netbees.navlogics.model.MyResponse;
import com.netbees.navlogics.model.Request;
import com.netbees.navlogics.model.whethermodel.List;
import com.netbees.navlogics.model.whethermodel.WhetherRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Request request = new Request();
        request.setId(1);
        request.setTitle("kiran");
        request.setUserId(1);

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);

       /* service.getMyResponseCall(request)
        .enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {

                MyResponse myResponse = response.body();

                // set the respose to a toast
            //    myResponse.getTitle();

            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });*/


       service.kiranCall().enqueue(new Callback<WhetherRequest>() {
           @Override
           public void onResponse(Call<WhetherRequest> call, Response<WhetherRequest> response) {

               WhetherRequest whetherRequest = response.body();


              for(int i=0;i< whetherRequest.getList().size();i++)
              {

               Double my3h=   whetherRequest.getList().get(i).getRain().get3h();
                  Log.d("kkk",my3h+"");
              }




           }

           @Override
           public void onFailure(Call<WhetherRequest> call, Throwable t) {

           }
       });

    }
}
