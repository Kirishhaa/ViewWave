package kirishhaa.viewwave.utils.validator

interface AccountValidator {

    fun validateEmail(email: String): Boolean

    fun validatePassword(password: String): Boolean

    companion object {
        private var instance: AccountValidator? = null

        fun getInstance(): AccountValidator {
            val instance = this.instance

            return if (instance == null) {
                val newInstance = AccountValidatorImpl()
                this.instance = newInstance
                newInstance
            } else {
                instance
            }
        }
    }

}

private class AccountValidatorImpl : AccountValidator {

    override fun validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun validatePassword(password: String): Boolean {
        return password.length in (6..20)
    }

}