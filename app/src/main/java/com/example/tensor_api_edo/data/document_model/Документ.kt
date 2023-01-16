package com.example.tensor_api_edo.data.document_model

import kotlinx.android.parcel.Parcelize


data class Документ(
    val Вложение: List<Вложение>,
    val Дата: String,
    val ДатаВремяСоздания: String,
    val Идентификатор: String,
    val ИдентификаторСеанса: String,
    val Контрагент: Контрагент,
    val Название: String,
    val Направление: String,
    val НашаОрганизация: НашаОрганизация,
    val Номер: String,
    val Ответственный: Ответственный,
    val Подтип: String,
    val Примечание: String,
    val Расширение: Расширение,
    val Регламент: Регламент,
    val Редакция: List<РедакцияX>,
    val Состояние: СостояниеX,
    val Срок: String,
    val СсылкаДляКонтрагент: String,
    val СсылкаДляНашаОрганизация: String,
    val СсылкаНаPDF: String,
    val СсылкаНаАрхив: String,
    val Сумма: String,
    val Тип: String,
    val Удален: String
)