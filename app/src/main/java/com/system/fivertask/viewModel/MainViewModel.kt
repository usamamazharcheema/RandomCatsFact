import android.app.ProgressDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.system.fivertask.model.FactModel
import com.system.fivertask.model.Status
import com.tpltrakker.main.api.GeneralApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject
class MainViewModel : ViewModel() {


    val getGetFactState: MutableLiveData<GeneralApiResponse<List<FactModel>>> = MutableLiveData()
    val mainRepository = MainRepository()
     var Result=ArrayList<FactModel>()

    // val FactLiveData = MutableLiveData<MutableList<FactModel>>()





    fun getFacts(context: Context) {


        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Facts loading , please wait")
        progressDialog.setCancelable(false)
        progressDialog.show()

        viewModelScope.launch {
            try {
                val response = mainRepository.getFacts()
                if (response.isSuccessful) {
                    progressDialog.dismiss()


                    Result.add(response.body()!!)
                    Log.e("zeeshan",response.body().toString());
                    getGetFactState.value = GeneralApiResponse.Success(Result.toList())

                  //  FactLiveData.value?.add(response.body()!!)
                   // FactLiveData.value = FactLiveData.value


                } else {
                    progressDialog.dismiss()

                    Toast.makeText(context,"Connect Your Internet",Toast.LENGTH_LONG).show()

                }
            } catch (e: Exception) {
                progressDialog.dismiss()
                Toast.makeText(context,"Connect Your Internet",Toast.LENGTH_LONG).show()


            }

        }}

    fun remove(postion:Int){
        Result.removeAt(postion)
        getGetFactState.value = GeneralApiResponse.Success(Result.toList())


    }


    }


