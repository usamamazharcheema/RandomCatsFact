
import com.system.fivertask.api.APIInterface
import dagger.Module
import dagger.hilt.InstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    companion object {

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                    .readTimeout(5, TimeUnit.MINUTES) // read timeout
                //.certificatePinner()
                .build()

            Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com/facts/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }


        val api: APIInterface by lazy {
            retrofit.create(APIInterface::class.java)
        }



    }
}
