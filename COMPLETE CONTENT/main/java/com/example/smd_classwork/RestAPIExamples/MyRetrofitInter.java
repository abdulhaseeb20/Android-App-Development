package com.example.smd_classwork.RestAPIExamples;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyRetrofitInter {
    //rest APis queries
    @GET("posts")
    Call<List<MyPOJO>> getList();

    @GET("posts/{id}/comments")
    Call<List<MyCommentsModel>> GetMyComments(@Path("id") int id);

    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsQuery(@Query("postId") int id, @Query("_sort") String sort, @Query("_order") String orderby);

    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsByQuery(@QueryMap Map<String, String> Arguments);

    @POST("posts")
    Call<MyPOJO> createPost(@Body MyPOJO post);
}
