package com.example.tensor_api_edo.domain.test

import com.stanfy.gsonxml.GsonXmlBuilder
import com.stanfy.gsonxml.XmlParserCreator
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

class simpleTest {

    val parserCreator = object : XmlParserCreator{
        override fun createParser(): XmlPullParser {
            return XmlPullParserFactory.newInstance().newPullParser()
        }
    }

    val gsonXml = GsonXmlBuilder().setXmlParserCreator(parserCreator).create()

    val xml = "<model><name>my name</name><description>my description</description></model>"
    val model = gsonXml.fromXml(xml, SimpleModel::class.java)


    //assertEquals("my name", model.getName());
//    assertEquals("my description", model.getDescription());
}