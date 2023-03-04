package com.example.baseadapter

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baseadapter.databinding.ActivityMainBinding
import com.example.baseadapter.databinding.AddItemsBinding
import com.example.baseadapter.databinding.EditLayoutBinding

class MainActivity : AppCompatActivity(),StudentClick {
    lateinit var binding: ActivityMainBinding
    lateinit var studentAdapter: studentAdapter
    var studentList = ArrayList<StudentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        studentAdapter = studentAdapter(studentList, this)
        binding.lv.adapter = studentAdapter

        binding.floatBtn.setOnClickListener {
            var dialogBinding = AddItemsBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etName.text.toString().isEmpty()) {
                    dialogBinding.etName.error = "Enter your name"
                } else if (dialogBinding.etCourse.text.toString().isEmpty()) {
                    dialogBinding.etCourse.error = "Enter your course"
                } else if (dialogBinding.etPhone.text.toString().isEmpty()) {
                    dialogBinding.etPhone.error = "Enter your phone no"
                } else {
                    studentList.add(StudentModel(dialogBinding.etName.text.toString()
                        ,dialogBinding.etCourse.text.toString(),dialogBinding.etPhone.text.toString()))
                    studentAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
    }
    override fun studentClick(position: Int) {
        val dialogboxBinding=EditLayoutBinding.inflate(layoutInflater)
        val dialogbox= Dialog(this)
        dialogbox.setContentView(dialogboxBinding.root)
        dialogboxBinding.btnEdit.setOnClickListener {
            if (dialogboxBinding.etName.text.toString().isEmpty()){
                dialogboxBinding.etName.error="enter name"
            }
            else if (dialogboxBinding.etCourse.text.toString().isEmpty()){
                dialogboxBinding.etCourse.error="Enter your course"
            }
            else if (dialogboxBinding.etPhone.text.toString().isEmpty()){
                dialogboxBinding.etPhone.error="Enter your phone no"
            }
            else{
                studentList.set(position,StudentModel(dialogboxBinding.etName.text.toString(),
                    dialogboxBinding.etCourse.text.toString(),
                    dialogboxBinding.etPhone.text.toString()))
                studentAdapter.notifyDataSetChanged()
                dialogbox.dismiss()
            }
        }
        dialogboxBinding.btnDelete.setOnClickListener {
            if (dialogboxBinding.etName.text.toString().isEmpty()) {
                dialogboxBinding.etName.error = "Enter your name"
            } else if (dialogboxBinding.etCourse.text.toString().isEmpty()) {
                dialogboxBinding.etCourse.error = "Enter your course"
            }
            else if (dialogboxBinding.etPhone.text.toString().isEmpty()){
                dialogboxBinding.etPhone.error="Enter your phone no"
            }
            else {
                studentList.removeAt(position)
                studentAdapter.notifyDataSetChanged()
                dialogbox.dismiss()
            }
        }
        dialogbox.show()
    }
}