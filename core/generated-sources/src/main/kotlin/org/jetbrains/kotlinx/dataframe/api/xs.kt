package org.jetbrains.kotlinx.dataframe.api

import org.jetbrains.kotlinx.dataframe.ColumnsSelector
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.impl.api.xsImpl

// region DataFrame

public fun <T> DataFrame<T>.xs(vararg keyValues: Any?): DataFrame<T> = xs(*keyValues) {
    cols { !it.isColumnGroup() }.recursively().take(keyValues.size)
}

public fun <T, C> DataFrame<T>.xs(vararg keyValues: C, keyColumns: ColumnsSelector<T, C>): DataFrame<T> =
    xsImpl(keyColumns, false, *keyValues)

// endregion

// region GroupBy

public fun <T, G> GroupBy<T, G>.xs(vararg keyValues: Any?): GroupBy<T, G> = xs(*keyValues) {
    cols { !it.isColumnGroup() }.recursively().take(keyValues.size)
}

public fun <T, G, C> GroupBy<T, G>.xs(vararg keyValues: C, keyColumns: ColumnsSelector<T, C>): GroupBy<T, G> =
    xsImpl(*keyValues, keyColumns = keyColumns)

// endregion
