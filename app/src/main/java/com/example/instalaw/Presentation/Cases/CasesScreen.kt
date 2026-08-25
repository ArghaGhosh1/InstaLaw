package com.example.instalaw.Presentation.Cases

import android.Manifest
import android.content.pm.PackageManager

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button

import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview as ComposePreview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView

import androidx.core.content.ContextCompat

import androidx.lifecycle.LifecycleOwner

import com.example.instalaw.R


@Composable
@ComposePreview(
    name = "Pixel 9 Pro",
    device = "spec:width=448dp,height=998dp,dpi=495",
    showSystemUi = true,
    showBackground = true
)
fun CasesScreen() {

    val context = LocalContext.current

    // ---------------------------------------------------------
    // CAMERA PERMISSION
    // ---------------------------------------------------------

    var cameraPermissionGranted by remember {

        mutableStateOf(
            ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
    }

    val permissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { granted ->

            cameraPermissionGranted = granted
        }

    LaunchedEffect(Unit) {

        if (!cameraPermissionGranted) {

            permissionLauncher.launch(
                Manifest.permission.CAMERA
            )
        }
    }


    // ---------------------------------------------------------
    // SCREEN
    // ---------------------------------------------------------

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(R.color.screen_background)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(
                    colorResource(R.color.screen_background)
                )
        ) {

            // ============================================
            // TOP BAR
            // ============================================

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),

                horizontalArrangement = Arrangement.SpaceBetween,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "InstaLaw",
                    color = colorResource(R.color.AppNameColor),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Icon(
                    painter = painterResource(
                        R.drawable.outline_add_alert_24
                    ),
                    contentDescription = "Notifications",
                    modifier = Modifier
                        .size(28.dp)
                        .clickable { },
                    tint = Color.Black
                )
            }


            // ============================================
            // SCROLLABLE CONTENT
            // ============================================

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(
                        rememberScrollState()
                    )
                    .padding(
                        horizontal = 20.dp
                    ),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(
                    modifier = Modifier.height(18.dp)
                )


                // ========================================
                // HEADING
                // ========================================

                Text(
                    text = "Scan any legal notice for an instant summary.",
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )


                Spacer(
                    modifier = Modifier.height(8.dp)
                )


                // ========================================
                // DESCRIPTION
                // ========================================

                Text(
                    text = "Point your camera at a physical document to begin analysis.",
                    fontSize = 13.sp,
                    color = Color.Gray
                )


                Spacer(
                    modifier = Modifier.height(18.dp)
                )


                // ========================================
                // CAMERA
                // ========================================

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                ) {

                    if (cameraPermissionGranted) {

                        CameraPreview(
                            modifier = Modifier.fillMaxSize()
                        )

                    } else {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.DarkGray),

                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                text = "Camera permission required",
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }

                    // Document corners
                    DocumentOverlay(
                        modifier = Modifier.fillMaxSize()
                    )
                }


                Spacer(
                    modifier = Modifier.height(10.dp)
                )


                // ========================================
                // CAMERA INSTRUCTION
                // ========================================

                Text(
                    text = "Align the document inside the frame",
                    fontSize = 11.sp,
                    color = Color.Gray
                )


                Spacer(
                    modifier = Modifier.height(16.dp)
                )


                // ========================================
                // CAPTURE BUTTON
                // ========================================

                Button(
                    onClick = {
                        // We will add ImageCapture here
                    },

                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .height(48.dp),

                    shape = RoundedCornerShape(8.dp)
                ) {

                    Icon(
                        painter = painterResource(
                            R.drawable.camera
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                    Spacer(
                        modifier = Modifier.width(8.dp)
                    )

                    Text(
                        text = "Scan Document",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }


                Spacer(
                    modifier = Modifier.height(25.dp)
                )


                // ========================================
                // RECENT SCANS
                // ========================================

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Recent Scans",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )

                    Text(
                        text = "View All",
                        fontSize = 11.sp,
                        color = colorResource(
                            R.color.AppNameColor
                        )
                    )
                }


                Spacer(
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}


// =============================================================
// CAMERA PREVIEW
// =============================================================

@Composable
fun CameraPreview(
    modifier: Modifier = Modifier
) {

    val context =
        LocalContext.current


    AndroidView(

        modifier =
            modifier,

        factory = { ctx ->

            val previewView =
                PreviewView(ctx)


            // -------------------------------------------------
            // CAMERA PROVIDER
            // -------------------------------------------------

            val cameraProviderFuture =
                ProcessCameraProvider
                    .getInstance(ctx)


            cameraProviderFuture.addListener({

                val cameraProvider =
                    cameraProviderFuture.get()


                // -------------------------------------------------
                // PREVIEW
                // -------------------------------------------------

                val preview =
                    Preview.Builder()
                        .build()


                preview.setSurfaceProvider(
                    previewView.surfaceProvider
                )


                // -------------------------------------------------
                // BACK CAMERA
                // -------------------------------------------------

                val cameraSelector =
                    CameraSelector
                        .DEFAULT_BACK_CAMERA


                try {

                    cameraProvider.unbindAll()


                    cameraProvider.bindToLifecycle(

                        context as LifecycleOwner,

                        cameraSelector,

                        preview
                    )

                } catch (e: Exception) {

                    e.printStackTrace()
                }

            }, ContextCompat.getMainExecutor(ctx))


            previewView
        }
    )
}


// =============================================================
// DOCUMENT OVERLAY
// =============================================================

@Composable
fun DocumentOverlay(
    modifier: Modifier = Modifier
) {

    Canvas(
        modifier = modifier
    ) {

        // -----------------------------------------
        // DOCUMENT FRAME
        // -----------------------------------------

        val frameWidth = size.width * 0.72f
        val frameHeight = frameWidth * 1.35f

        val left = (size.width - frameWidth) / 2
        val top = (size.height - frameHeight) / 2

        val right = left + frameWidth
        val bottom = top + frameHeight


        // -----------------------------------------
        // DARK OVERLAY
        // -----------------------------------------

        drawRect(
            color = Color.Black.copy(alpha = 0.35f)
        )


        // -----------------------------------------
        // CLEAR DOCUMENT AREA
        // -----------------------------------------

        drawRect(
            color = Color.Transparent,
            topLeft = Offset(left, top),
            size = Size(
                frameWidth,
                frameHeight
            ),
            blendMode = BlendMode.Clear
        )


        // -----------------------------------------
        // CORNER SIZE
        // -----------------------------------------

        val cornerLength = 28.dp.toPx()

        val strokeWidth = 3.dp.toPx()


        // -----------------------------------------
        // TOP LEFT
        // -----------------------------------------

        drawLine(
            start = Offset(left, top),
            end = Offset(
                left + cornerLength,
                top
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )

        drawLine(
            start = Offset(left, top),
            end = Offset(
                left,
                top + cornerLength
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )


        // -----------------------------------------
        // TOP RIGHT
        // -----------------------------------------

        drawLine(
            start = Offset(right, top),
            end = Offset(
                right - cornerLength,
                top
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )

        drawLine(
            start = Offset(right, top),
            end = Offset(
                right,
                top + cornerLength
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )


        // -----------------------------------------
        // BOTTOM LEFT
        // -----------------------------------------

        drawLine(
            start = Offset(left, bottom),
            end = Offset(
                left + cornerLength,
                bottom
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )

        drawLine(
            start = Offset(left, bottom),
            end = Offset(
                left,
                bottom - cornerLength
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )


        // -----------------------------------------
        // BOTTOM RIGHT
        // -----------------------------------------

        drawLine(
            start = Offset(right, bottom),
            end = Offset(
                right - cornerLength,
                bottom
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )

        drawLine(
            start = Offset(right, bottom),
            end = Offset(
                right,
                bottom - cornerLength
            ),
            color = Color.White,
            strokeWidth = strokeWidth
        )
    }
}