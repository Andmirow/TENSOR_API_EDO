package com.example.tensor_api_edo.domain

import com.example.tensor_api_edo.data.document_model.Документ
import com.example.tensor_api_edo.data.document_model.Реестр
import com.example.tensor_api_edo.domain.model_bl.Attachment
import com.example.tensor_api_edo.domain.model_bl.Document
import com.example.tensor_api_edo.domain.model_bl.InnerFile

@Suppress("NonAsciiCharacters")
class MapperDocuments {
    companion object{

        fun mapДокументToDocument(документ : Документ): Document {

            var listOfAttachment = mutableListOf<Attachment>()

            for (вложение in документ.Вложение){
                val isFormat = !(вложение.СсылкаНаHTML == null || вложение.СсылкаНаHTML =="")

                listOfAttachment.add(
                    Attachment(
                        name = вложение.Название,
                        linckOfHtml = вложение.СсылкаНаHTML,
                        html = null,
                        linckOfXml = if (!isFormat) вложение.Файл.Ссылка else null,
                        isFormalized = isFormat,
                        file = InnerFile(вложение.Файл.Имя,null,null)
                    )
                )




            }


            return Document(
                id = документ.Идентификатор,
                name = документ.Название,
                nomber = документ.Номер,
                direction =документ.Направление,
                Subtype = документ.Подтип,
                attachments = listOfAttachment,
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