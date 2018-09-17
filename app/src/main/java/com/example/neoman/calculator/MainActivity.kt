package com.example.neoman.calculator

/*change it later so that it stores all entered operations and numbers into string then when you hit
equal it solves whole string(prefix/postfix stuff from 22C)*/

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var op=""
    var first=""
    var newop=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun oper(view:View) {
        if(!newop){
            solve(view);
        }
        op=(view as Button).text.toString()
        first=editText.text.toString()
        newop=false
        editText.setText("")

    }

    fun solve(view:View) {
        var solution=0.0
        when(op){
            "X"->solution=first.toDouble()*editText.text.toString().toDouble()
            "+"->solution=first.toDouble()+editText.text.toString().toDouble()
            "-"->solution=first.toDouble()-editText.text.toString().toDouble()
            "/"->solution=first.toDouble()/editText.text.toString().toDouble()
        }
        editText.setText(solution.toString())
        newop=true
    }

    fun clear(view:View){
        if(editText.text.toString()!="0") {
            editText.setText("0")
        }
        else{
            newop=true
        }
    }

    fun number(view:View){
        val but=view as Button
        var entry:String=editText.text.toString()

        if(entry=="0"&&but.text!="+/-"&&but.text!="%"){//so there is no leading 0
            entry=""
        }

        if(but.text=="."){
            if(!entry.contains(".")){
                entry+="."
            }

        }
        else if(but.text=="%"){
            entry=(entry.toDouble()/100).toString()
        }
        else if(but.text=="+/-"){
            if(entry[0]=='-'){
                entry=entry.substring(1)
            }
            else{
                entry="-"+entry
            }
        }
        else{
            entry+=but.text
        }
        editText.setText(entry)

    }
}
