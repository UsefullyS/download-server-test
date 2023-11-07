package de.meondi.downloadservertest.controller;

import de.meondi.downloadservertest.service.DownloadService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final DownloadService downloadService;

    public ApiController(DownloadService downloadService) {
        this.downloadService = downloadService;
    }

    @GetMapping("/downloadfile/{fileName}")
    public ResponseEntity<Resource> getDownloadFile(@PathVariable String fileName) throws MalformedURLException {
        Resource resource = downloadService.getDownloadFile(fileName);
        return ResponseEntity.ok()
                .header("Content-Disposition", resource.getFilename())
                .body(resource);
    }

    @PostMapping("/uploadfile")
    public void uploadFile(@RequestParam("file")MultipartFile file) throws MalformedURLException {
        downloadService.storeFile(file);
    }
}
