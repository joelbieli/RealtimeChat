package utils

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.primaryConstructor

/**
 * Merge two data classes
 * The resulting data class will contain
 * - all fields of `other` which are non null
 * - the fields of `this` for the fields which are null in `other`
 */
inline infix fun <reified T : Any> T.merge(other: T): T {
    val nameToProperty = T::class.declaredMemberProperties.associateBy { it.name }
    val primaryConstructor = T::class.primaryConstructor!!
    val args = primaryConstructor.parameters.associate { parameter ->
        val property = nameToProperty[parameter.name]!!
        parameter to (if (property.get(other) != "") property.get(other) else property.get(this))
    }
    return primaryConstructor.callBy(args)
}