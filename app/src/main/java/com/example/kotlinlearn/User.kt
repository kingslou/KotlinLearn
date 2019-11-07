package com.example.kotlinlearn

/***
 * 用户对象
 * 传参 userNmae userAge
 * 属性 userTest
 * val 赋值猴不可改变 var 可动态改变值
 */
class User (val userName:String, val userAge :Int){

    var userTest:String = ""
    // 设置钩子 默认 field = value
    set(value) {
        field = value+"ni"
    }

    get() {
       return  field+"nb"
    }



}