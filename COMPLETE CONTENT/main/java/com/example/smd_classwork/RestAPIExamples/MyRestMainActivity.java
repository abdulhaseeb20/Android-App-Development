package com.example.smd_classwork.RestAPIExamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.smd_classwork.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRestMainActivity extends AppCompatActivity {

    MyRetrofitInter apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rest_main);
        recyclerView = findViewById(R.id.myretrofitrecyclerview);

        apiInterface = MyRetrofit.getRetrofit().create(MyRetrofitInter.class);
       // GetMyRetrofit();
        //GetMyComments();
        //GetMyCommentsByArgument();
        CreatePost();
    }

    private void CreatePost()
    {
        MyPOJO obj = new MyPOJO(5, 7, "My Post Title is here", "Body of the post");
        apiInterface.createPost(obj);
        Call<MyPOJO> myPOJOCall = apiInterface.createPost(obj);
        myPOJOCall.enqueue(new Callback<MyPOJO>() {
            @Override
            public void onResponse(Call<MyPOJO> call, Response<MyPOJO> response) {
                if (response.isSuccessful())
                {
                    Log.d("TAG", " "+response.body().getUserId() + "\n" +response.body().getId() +"\n" +response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<MyPOJO> call, Throwable t) {

            }
        });
    }

    public void GetMyComments()
    {
        Call<List<MyCommentsModel>> list = apiInterface.getMyCommentsQuery(7,"id", "desc");

        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if (response.isSuccessful())//positive response
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG", "ID "+ comments.getId() + "PostID " +comments.getPostId() +"User " +comments.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }

    public void GetMyCommentsByArgument()
    {
        Map<String, String> Arguments = new HashMap<>();
        Arguments.put("postId", "3");
        Arguments.put("_sort", "id");
        Arguments.put("_order", "desc");
        Call<List<MyCommentsModel>> list = apiInterface.getMyCommentsByQuery(Arguments);

        list.enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if (response.isSuccessful())//positive response
                {
                    for (MyCommentsModel comments : response.body())
                    {
                        Log.d("TAG", "ID "+ comments.getId() + "PostID " +comments.getPostId() +"User " +comments.getName());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {

            }
        });
    }

    private void GetMyRetrofit() {
        apiInterface.getList().enqueue(new Callback<List<MyPOJO>>() {
            @Override
            public void onResponse(Call<List<MyPOJO>> list, Response<List<MyPOJO>> response) {
                if (response.body().size() > 0)
                {
                    Log.d("TAG", "Data Retrieved");
                    List<MyPOJO> myPOJOList = response.body();
                    MyRestAdapter adapter = new MyRestAdapter(myPOJOList, MyRestMainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyRestMainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                }
                else
                {
                    Log.d("TAG", "List is empty");
                }
            }

            @Override
            public void onFailure(Call<List<MyPOJO>> call, Throwable t) {
                Log.d("TAG", "Failure");
            }
        });
    }


}