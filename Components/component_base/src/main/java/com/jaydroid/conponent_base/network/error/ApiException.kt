package com.jaydroid.conponent_base.network.error

data class ApiException(var errCode: Int, var errMsg: String) : Exception()