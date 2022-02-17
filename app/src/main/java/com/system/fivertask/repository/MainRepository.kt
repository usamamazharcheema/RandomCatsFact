
import com.system.fivertask.model.FactModel
import retrofit2.Response


class MainRepository  {
    private val apiServices = RetrofitInstance.api

    suspend fun getFacts(): Response<FactModel> {
        return apiServices.getFact(
            "random",

        )
    }






    }
