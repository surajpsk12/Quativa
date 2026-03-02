package com.surajvanshsv.quativa.sharecard

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast
import android.os.Environment

fun saveBitmapToGallery(context: Context, bitmap: Bitmap, fileName: String) {
    val values = ContentValues().apply {
        put(MediaStore.Images.Media.DISPLAY_NAME, "$fileName.png")
        put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/Quativa")
    }

    val uri = context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    uri?.let {
        context.contentResolver.openOutputStream(it).use { stream ->
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream!!)
        }
        Toast.makeText(context, "Quote saved to Gallery!", Toast.LENGTH_SHORT).show()
    }
}