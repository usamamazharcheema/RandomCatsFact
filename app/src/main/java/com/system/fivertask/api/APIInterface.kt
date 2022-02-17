package com.system.fivertask.api

import com.system.fivertask.model.FactModel

import retrofit2.Response
import retrofit2.http.*

interface APIInterface {


    @GET("{endPoint}")
    suspend fun getFact(
        @Path("endPoint") endPoint: String?,
    ): Response<FactModel>


}
