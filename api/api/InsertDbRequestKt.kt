//Generated by the protocol buffer compiler. DO NOT EDIT!
// source: database.proto

package api;

@kotlin.jvm.JvmName("-initializeinsertDbRequest")
inline fun insertDbRequest(block: api.InsertDbRequestKt.Dsl.() -> kotlin.Unit): api.DatabaseOuterClass.InsertDbRequest =
  api.InsertDbRequestKt.Dsl._create(api.DatabaseOuterClass.InsertDbRequest.newBuilder()).apply { block() }._build()
object InsertDbRequestKt {
  @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
  @com.google.protobuf.kotlin.ProtoDslMarker
  class Dsl private constructor(
    private val _builder: api.DatabaseOuterClass.InsertDbRequest.Builder
  ) {
    companion object {
      @kotlin.jvm.JvmSynthetic
      @kotlin.PublishedApi
      internal fun _create(builder: api.DatabaseOuterClass.InsertDbRequest.Builder): Dsl = Dsl(builder)
    }

    @kotlin.jvm.JvmSynthetic
    @kotlin.PublishedApi
    internal fun _build(): api.DatabaseOuterClass.InsertDbRequest = _builder.build()

    /**
     * <code>string tb = 1;</code>
     */
    var tb: kotlin.String
      @JvmName("getTb")
      get() = _builder.getTb()
      @JvmName("setTb")
      set(value) {
        _builder.setTb(value)
      }
    /**
     * <code>string tb = 1;</code>
     */
    fun clearTb() {
      _builder.clearTb()
    }

    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class ColumsProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <code>repeated string colums = 2;</code>
     * @return A list containing the colums.
     */
     val colums: com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getColumsList()
      )
    /**
     * <code>repeated string colums = 2;</code>
     * @param value The colums to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addColums")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.add(value: kotlin.String) {
      _builder.addColums(value)
    }
    /**
     * <code>repeated string colums = 2;</code>
     * @param value The colums to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignColums")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * <code>repeated string colums = 2;</code>
     * @param values The colums to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllColums")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllColums(values)
    }
    /**
     * <code>repeated string colums = 2;</code>
     * @param values The colums to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllColums")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * <code>repeated string colums = 2;</code>
     * @param index The index to set the value at.
     * @param value The colums to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setColums")
    operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setColums(index, value)
    }/**
     * <code>repeated string colums = 2;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearColums")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ColumsProxy>.clear() {
      _builder.clearColums()
    }
    /**
     * An uninstantiable, behaviorless type to represent the field in
     * generics.
     */
    @kotlin.OptIn(com.google.protobuf.kotlin.OnlyForUseByGeneratedProtoCode::class)
    class ValuesProxy private constructor() : com.google.protobuf.kotlin.DslProxy()
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @return A list containing the values.
     */
     val values: com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>
      @kotlin.jvm.JvmSynthetic
      get() = com.google.protobuf.kotlin.DslList(
        _builder.getValuesList()
      )
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @param value The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addValues")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.add(value: kotlin.String) {
      _builder.addValues(value)
    }
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @param value The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignValues")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.plusAssign(value: kotlin.String) {
      add(value)
    }
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @param values The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("addAllValues")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.addAll(values: kotlin.collections.Iterable<kotlin.String>) {
      _builder.addAllValues(values)
    }
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @param values The values to add.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("plusAssignAllValues")
    @Suppress("NOTHING_TO_INLINE")
    inline operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.plusAssign(values: kotlin.collections.Iterable<kotlin.String>) {
      addAll(values)
    }
    /**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     * @param index The index to set the value at.
     * @param value The values to set.
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("setValues")
    operator fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.set(index: kotlin.Int, value: kotlin.String) {
      _builder.setValues(index, value)
    }/**
     * <pre>
     * TODO: edit string type of vals
     * </pre>
     *
     * <code>repeated string values = 3;</code>
     */
    @kotlin.jvm.JvmSynthetic
    @kotlin.jvm.JvmName("clearValues")
    fun com.google.protobuf.kotlin.DslList<kotlin.String, ValuesProxy>.clear() {
      _builder.clearValues()
    }}
}
@kotlin.jvm.JvmSynthetic
inline fun api.DatabaseOuterClass.InsertDbRequest.copy(block: api.InsertDbRequestKt.Dsl.() -> kotlin.Unit): api.DatabaseOuterClass.InsertDbRequest =
  api.InsertDbRequestKt.Dsl._create(this.toBuilder()).apply { block() }._build()

