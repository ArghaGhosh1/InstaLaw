package com.example.instalaw.Presentation.Cases

import android.Manifest
import android.content.pm.PackageManager

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner


@Composable
fun CameraPreviewCard() {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    var imageCapture by remember {
        mutableStateOf<ImageCapture?>(null)
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->

            if (granted) {
                // Permission granted
                // Compose will recompose and show camera
            }
        }

    val hasPermission =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED


    if (!hasPermission) {

        LaunchedEffect(Unit) {

            permissionLauncher.launch(
                Manifest.permission.CAMERA
            )

        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
        ) {

            AndroidView(
                factory = { ctx ->

                    val previewView = PreviewView(ctx)

                    previewView.scaleType =
                        PreviewView.ScaleType.FILL_CENTER

                    val cameraProviderFuture =
                        ProcessCameraProvider.getInstance(ctx)

                    cameraProviderFuture.addListener({

                        try {

                            val cameraProvider =
                                cameraProviderFuture.get()

                            val preview =
                                Preview.Builder()
                                    .build()

                            val capture =
                                ImageCapture.Builder()
                                    .build()

                            imageCapture = capture

                            preview.setSurfaceProvider(
                                previewView.surfaceProvider
                            )

                            val cameraSelector =
                                CameraSelector.DEFAULT_BACK_CAMERA

                            cameraProvider.unbindAll()

                            cameraProvider.bindToLifecycle(
                                lifecycleOwner,
                                cameraSelector,
                                preview,
                                capture
                            )

                        } catch (e: Exception) {

                            e.printStackTrace()

                        }

                    }, ContextCompat.getMainExecutor(ctx))

                    previewView
                },

                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
            )


            // SCANNING FRAME

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                val frameWidth =
                    size.width * 0.85f

                val frameHeight =
                    size.height * 0.65f

                val left =
                    (size.width - frameWidth) / 2

                val top =
                    (size.height - frameHeight) / 2

                val right =
                    left + frameWidth

                val bottom =
                    top + frameHeight

                val cornerLength =
                    25.dp.toPx()

                val strokeWidth =
                    3.dp.toPx()


                // TOP LEFT

                drawLine(
                    start = Offset(left, top),
                    end = Offset(
                        left + cornerLength,
                        top
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )

                drawLine(
                    start = Offset(left, top),
                    end = Offset(
                        left,
                        top + cornerLength
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )


                // TOP RIGHT

                drawLine(
                    start = Offset(right, top),
                    end = Offset(
                        right - cornerLength,
                        top
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )

                drawLine(
                    start = Offset(right, top),
                    end = Offset(
                        right,
                        top + cornerLength
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )


                // BOTTOM LEFT

                drawLine(
                    start = Offset(left, bottom),
                    end = Offset(
                        left + cornerLength,
                        bottom
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )

                drawLine(
                    start = Offset(left, bottom),
                    end = Offset(
                        left,
                        bottom - cornerLength
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )


                // BOTTOM RIGHT

                drawLine(
                    start = Offset(right, bottom),
                    end = Offset(
                        right - cornerLength,
                        bottom
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )

                drawLine(
                    start = Offset(right, bottom),
                    end = Offset(
                        right,
                        bottom - cornerLength
                    ),
                    strokeWidth = strokeWidth,
                    color = Color.Cyan
                )
            }
        }
    }
}