package com.example.tensor_api_edo.domain

import com.example.tensor_api_edo.data.document_model.Документ
import com.example.tensor_api_edo.data.document_model.Реестр

@Suppress("NonAsciiCharacters")
class MapperDocuments {
    companion object{

        fun mapДокументToDocument(документ : Документ): Document{

            var mapFiles: MutableMap<String, String> = mutableMapOf()
            for (i in документ.Вложение){
                mapFiles[i.Название] = i.СсылкаНаHTML
            }

            return Document(
                id = документ.Идентификатор,
                name = документ.Название,
                nomber = документ.Номер,
                direction =документ.Направление,
                Subtype = документ.Подтип,
                lincksOfHTML = mapFiles,
                files = mutableListOf(),
                sum = документ.Сумма,
                type = документ.Тип,
                data = документ.Дата,
                status = документ.Состояние.Название,
                partner = документ.Контрагент.СвЮЛ.Название
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