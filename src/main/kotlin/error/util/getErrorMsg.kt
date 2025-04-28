package error.util

import error.config.ERROR_MSG_PREFIX

fun getErrorMsgWithPrefix(message: String): String {
    return ERROR_MSG_PREFIX + message
}