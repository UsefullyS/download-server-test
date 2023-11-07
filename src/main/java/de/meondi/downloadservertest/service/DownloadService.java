package de.meondi.downloadservertest.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DownloadService {


    @Value("${app.folder.download}")
    private String fileFolder;

    public Resource getDownloadFile(String fileName) throws MalformedURLException {
        Path filePath = Paths.get(fileFolder, fileName);
        return new UrlResource(filePath.toUri());
    }
}
