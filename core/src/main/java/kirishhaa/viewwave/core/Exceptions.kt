package kirishhaa.viewwave.core

class IncorrectEmailException(message: String?=null): Exception(message)

class IncorrectPasswordException(message: String?=null): Exception(message)

class PasswordsMatchException(message: String?=null) : Exception(message)