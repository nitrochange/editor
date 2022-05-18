package com.core.environments

/**
 * Basic interface for environment. Every environment command will implement it
 */
interface Environment {
    fun getTexCode(): String

}