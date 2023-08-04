package kirishhaa.viewwave.core

class IncorrectEmailException(cause: Throwable?=null): Exception(cause)

class IncorrectPasswordException(cause: Throwable?=null): Exception(cause)

class PasswordsMatchException(cause: Throwable?=null) : Exception(cause)

class AuthException(cause: Throwable?=null): Exception(cause)

class CreateAccountException(cause: Throwable?=null): Exception(cause)

class UnsuccessfulSignInException(cause: Throwable?=null): Exception(cause)

class UnsuccessfulCreateUserException(cause: Throwable?=null): Exception(cause)

class UnsuccessfulDiscoverMovie(cause: Throwable?=null): Exception(cause)