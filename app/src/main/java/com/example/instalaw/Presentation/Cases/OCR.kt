package com.example.instalaw.Presentation.Cases

import android.content.Context
import android.net.Uri
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions

fun performOCR(
    context: Context,
    uri: Uri,
    onSuccess: (String) -> Unit,
    onError: (Exception) -> Unit
) {

    try {

        // Convert the selected image URI into an ML Kit image
        val image = InputImage.fromFilePath(
            context,
            uri
        )

        // Create OCR recognizer
        val recognizer = TextRecognition.getClient(
            TextRecognizerOptions.DEFAULT_OPTIONS
        )

        // Start OCR
        recognizer.process(image)
            .addOnSuccessListener { visionText ->

                // All detected text
                val extractedText = visionText.text

                onSuccess(extractedText)
            }
            .addOnFailureListener { exception ->

                onError(exception)
            }

    } catch (e: Exception) {

        onError(e)
    }
}