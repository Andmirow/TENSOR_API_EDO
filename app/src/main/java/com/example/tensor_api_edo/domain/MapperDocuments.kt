package com.example.tensor_api_edo.domain

import com.example.tensor_api_edo.data.document_model.Документ
import com.example.tensor_api_edo.data.document_model.Реестр
import com.example.tensor_api_edo.presentation.documents_view.DocumentsList

@Suppress("NonAsciiCharacters")
class MapperDocuments {
    companion object{

        fun mapДокументToDocument(документ : Документ): Document{
            return Document(документ.Идентификатор,
            документ.Название,
            документ.Номер,
            документ.Направление,
            документ.Подтип,
            документ.Вложение[0].СсылкаНаHTML,
            документ.Сумма,
            документ.Тип,
            документ.Дата,
            документ.Состояние.Название,
            документ.Контрагент.СвЮЛ.Название
            )
        }


        fun getListDocumentFromReestr(реестр : List<Реестр>): List<Document>{
            var listDocument = mutableListOf<Document>()
            for (element in реестр){
                val doc = element.Документ
                listDocument.add(mapДокументToDocument(doc))
            }
            return listDocument
        }


    }
}