package com.example.myapplication1.models

import androidx.appcompat.widget.Toolbar

interface IToolbar{
    fun toolbarToLoad(toolbar: Toolbar?)
    fun enableHomeDisplay(value: Boolean)
}