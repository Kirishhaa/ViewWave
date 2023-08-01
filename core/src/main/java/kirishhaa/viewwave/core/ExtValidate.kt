package kirishhaa.viewwave.core

fun String.isValidateEmail(): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidatePassword(): Boolean {
    return this.length in (6..20)
}