package com.example.questionapp


import retrofit2.Call
import retrofit2.http.GET

const val API_KEY ="0qXJK-O8WdPQ1r7NAvPUTgfatXwPR8OBwHKgnvOhJmovxeyWMp3hRH4VQUTT8GSqeQsEx6xmhpZ7UaRAQE4Fjt-qgQ88Cjnhm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnMHkZnxepD8lJaEeJ-dPGXkS88rBEtalwkjRGGoZjKpgR_XIOHaWRtIUgPV4OG_MwqZ--sX-o-XRYaY4AqSDbOlcVueifCrrvGIxwG7Ym21xrMD54Thg4qE&lib=MwT9x_y1h97Z349j9Z--gIAoOxUd2qb-3"


interface apiService {
    @GET("macros/echo?user_content_key=$API_KEY")

    fun getposts(): Call<MutableList<Question>>
}