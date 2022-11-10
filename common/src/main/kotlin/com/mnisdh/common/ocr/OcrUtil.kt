package com.mnisdh.common.ocr

import net.sourceforge.tess4j.Tesseract
import org.springframework.http.MediaType
import org.springframework.web.multipart.MultipartFile
import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO


class OcrUtil {

    companion object {
        fun getText(file: MultipartFile): String {
            var resultado = ""

            if (file.contentType.equals(MediaType.IMAGE_PNG.type) || file.contentType.equals(MediaType.IMAGE_JPEG.type)) {
                try {
                    val img: BufferedImage = ImageIO.read(file.getInputStream())

                    //Em versões anteriors do tesseract seria Tesseract.getInstance()
                    val tesseract = Tesseract()

                    //Path da pasta pai onde fica a pasta "tessdata"
                    tesseract.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata")

                    //lingua: por, eng etc...
                    tesseract.setLanguage("eng")
                    resultado = tesseract.doOCR(img)
                } catch (e: IOException) {
                    throw Exception("Erro ao ler arquivo")
                }
            }

            return resultado
        }
    }

}