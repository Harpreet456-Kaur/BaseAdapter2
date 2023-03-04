package com.example.baseadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.baseadapter.R.layout.*

class studentAdapter(val studentList: ArrayList<StudentModel>, var list: StudentClick): BaseAdapter() {
    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(position: Int): Any {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return 1
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, v: View?, parent: ViewGroup?): View {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        var tvName= v.findViewById<TextView>(R.id.tvName)
        var tvCourse= v.findViewById<TextView>(R.id.tvCourse)
        var tvPhone= v.findViewById<TextView>(R.id.tvPhone)
        tvName.text=studentList[position].name
        tvCourse.text=studentList[position].course
        tvPhone.text=studentList[position].phone

        v.setOnClickListener {
            list.studentClick(position)
        }
        return v
    }
}