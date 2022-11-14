package com.example.tensor_api_edo.data.document_model

data class Вложение(
    val ВерсияФормата: String,
    val Дата: String,
    val Зашифрован: String,
    val Идентификатор: String,
    val КоличествоОшибок: String,
    val Название: String,
    val Направление: String,
    val Номер: String,
    val ПодверсияФормата: String,
    val Подтип: String,
    val Редакция: Редакция,
    val Служебный: String,
    val СсылкаВКабинет: String,
    val СсылкаНаHTML: String,
    val СсылкаНаPDF: String,
    val Сумма: String,
    val СуммаБезНДС: String,
    val Тип: String,
    val ТипШифрования: String,
    val Удален: String,
    val Упакован: String,
    val Файл: Файл
)