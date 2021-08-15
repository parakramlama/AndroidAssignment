package com.example.androidassignment.api

interface ArticleAPI {
    @GET("article/show")
    suspend fun getAllArticles(
//            @Header("Authorization") token:String,
    ) : Response<ArticleResponse>

    @Multipart
    @PUT("article/{id}/photo")
    suspend fun uploadImage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Response<ImageResponse>
}