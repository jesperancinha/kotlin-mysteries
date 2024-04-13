package org.jesperancinha.talks.carparts.carpartsmanager.utils

import org.slf4j.LoggerFactory

inline fun <reified T> getLogger() = LoggerFactory.getLogger(T::class.java)
