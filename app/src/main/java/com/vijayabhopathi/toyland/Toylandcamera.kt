
package com.vijayabhopathi.toyland

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextField
import com.vijayabhopathi.toyland.Modules.HeadingTextComponent
import com.vijayabhopathi.toyland.ui.theme.ToyTheme
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.min

class CameraActivity : ComponentActivity() {

    enum class CameraPermissionStatus { NoPermission, PermissionGranted, PermissionDenied }

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cameraPermissionStatusState = mutableStateOf(CameraPermissionStatus.NoPermission)
        val photoUriState: MutableState<Uri?> = mutableStateOf(null)
        val hasPhotoState = mutableStateOf(false)
        val resolver = applicationContext.contentResolver

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
                if (isGranted) {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionGranted
                } else {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionDenied
                }
            }

        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { isSaved ->
                hasPhotoState.value = isSaved
            }

        val takePhoto: () -> Unit = {
            hasPhotoState.value = false

            val values = ContentValues().apply {
                val title = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                put(MediaStore.Images.Media.TITLE, "Compose Camera Example Image - $title")
                put(MediaStore.Images.Media.DISPLAY_NAME, title)
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())
            }

            val uri = resolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values
            )
            takePhotoLauncher.launch(uri)
            photoUriState.value = uri
        }

        // Ideally these would be cached instead of reloaded
        val getThumbnail: (Uri?) -> ImageBitmap? = { uri ->
            val targetSize = 256f
            uri?.let {
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val height = it.height.toFloat()
                val width = it.width.toFloat()
                val scaleFactor = min(targetSize / height, targetSize / width)
                Bitmap.createScaledBitmap(it, (scaleFactor * width).toInt(), (scaleFactor * height).toInt(), true)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()
        }

        val getFullImage: (Uri?) -> ImageBitmap? = { uri ->
            uri?.let {
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()
        }

        setContent {
            val cameraPermissionStatus by remember { cameraPermissionStatusState }
            val hasPhoto by remember { hasPhotoState }
            var shouldShowFullImage by remember { mutableStateOf(false) }
            var isEditing by remember { mutableStateOf(false) }

            // State variables for user details
            var name by remember { mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var location by remember { mutableStateOf("") }


        }
    }

    private fun getImageRotation(resolver: ContentResolver, uri: Uri): Int {
        val cursor = resolver.query(uri, arrayOf(MediaStore.Images.Media.ORIENTATION), null,
            null, null)
        var result = 0

        cursor?.apply {
            moveToFirst()
            val index = getColumnIndex(MediaStore.Images.Media.ORIENTATION)
            result = getInt(index)
            close()
        }
        return result
    }
}

@Composable
fun TakePhotoButton(
    cameraPermissionStatus: CameraActivity.CameraPermissionStatus,
    requestPermissionLauncher: ActivityResultLauncher<String>,
    takePhoto: () -> Unit
) {
    OutlinedButton(
        onClick = {
            when (cameraPermissionStatus) {
                CameraActivity.CameraPermissionStatus.NoPermission ->
                    requestPermissionLauncher.launch(Manifest.permission.CAMERA)

                CameraActivity.CameraPermissionStatus.PermissionGranted ->
                    takePhoto()

                CameraActivity.CameraPermissionStatus.PermissionDenied -> {}
            }
        }
    ) {
        when (cameraPermissionStatus) {
            CameraActivity.CameraPermissionStatus.NoPermission ->
                androidx.compose.material.Text(text = "Request Camera Permissions")

            CameraActivity.CameraPermissionStatus.PermissionDenied ->
                androidx.compose.material.Text(text = "Camera Permissions Have Been Denied")

            CameraActivity.CameraPermissionStatus.PermissionGranted ->
                androidx.compose.material.Text(text = "Take Photo")
        }
    }
}
