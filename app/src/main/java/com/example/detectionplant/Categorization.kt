package com.example.detectionplant

import android.content.res.AssetManager
import android.graphics.Bitmap
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.security.cert.CertPath

class Categorization(assetManager: AssetManager,modelPath: String,labelPath: String,inputSize: Int) {
    private val GVN_INP_SZ: Int = inputSize
    private val PHOTO_SDEVIATE = 255.0f
    private val GREAT_OUTCOME_MXX=3
    private val PITNR: Interpreter
    private val ROW_LINE: List<String>
    private val IMAGE_PXL_SZ: Int=3
    private val PHOTO_MEN = 0
    private val POINT_THRHLDD=0.4f

    data class Categorization(
        var id: String = "",
        var title: String ="",
        var confidence: Float = 0F
    ){
        override fun toString(): String {
            return "Title = $title, Confidence = $confidence)"
        }
    }
    init {
        PITNR= Interpreter(loadModeFile(assetManager,modelPath))
        ROW_LINE= loadlabelList(assetManager,labelPath)
    }

    private fun loadlabelList(assetManager: AssetManager, labelPath: String): List<String>{
        return assetManager.open(labelPath).bufferedReader().useLines { it.toList() }
    }

    private fun loadModeFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer{
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel =inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY,startOffset,declaredLength)
    }
    fun recognizeImage(bitmap: Bitmap): List<com.example.detectionplant.Categorization.Categorization>
    {

    }


}