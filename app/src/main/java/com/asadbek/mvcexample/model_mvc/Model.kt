package com.asadbek.mvcexample.model_mvc

import java.util.*
import java.lang.IndexOutOfBoundsException
import kotlin.collections.ArrayList

// Observable - O`zgarishlarni bilish uchun
class Model : Observable() {

    // ma`lumot saqlash uchun. list o`rnida api dan ma`lumot olib boshqa  narsalar bo`lishi mumkin
    val list:MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    @Throws(IndexOutOfBoundsException::class) // shunday xatolik tashlashi mumkin
    fun getValueIndex(index:Int):Int{
        return list[index]
    }

    @Throws(IndexOutOfBoundsException::class) // shunday xatolik tashlashi mumkin
    fun setValueIndex(index: Int){
        list[index] += 1
        setChanged() // o`zgarishni saqlash
        notifyObservers() // o`zgarishni yetkazib berish
    }

}