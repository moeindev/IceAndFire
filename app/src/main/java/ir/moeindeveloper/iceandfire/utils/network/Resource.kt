package ir.moeindeveloper.iceandfire.utils.network

/**
 * responsible to communicate the current state of Network Call to the UI Layer
 */
data class Resource<out T>(val status: RequestStatus, val data: T?, val Message: String?) {

 companion object {
  fun <T> success(data: T?): Resource<T> {
    return Resource(RequestStatus.SUCCESS,data,null)
  }

  fun <T> error(msg: String, data: T?): Resource<T> {
    return Resource(RequestStatus.ERROR,data,msg)
  }

  fun <T> loading(data: T?): Resource<T> {
    return Resource(RequestStatus.LOADING,data,null)
  }
 }

}