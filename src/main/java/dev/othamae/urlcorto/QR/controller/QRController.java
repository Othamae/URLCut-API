package dev.othamae.urlcorto.QR.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import dev.othamae.urlcorto.QR.dto.QRRequest;
import dev.othamae.urlcorto.QR.service.QRService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "QRCode", description = "QR code generator")
@RestController
@RequestMapping("/qr")
public class QRController {

    @Autowired
    QRService qrService;

    @PostMapping(value = "", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getQRCode(@RequestBody QRRequest qrRequest) throws IOException, WriterException {
        return qrService.sendQRCode(qrRequest.getLongUrl());
    }
}
