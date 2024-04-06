package org.example.createfile.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.createfile.service.CreateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@ResponseBody
@RequestMapping("/")
public class CreateFileController {

    @Autowired
    private CreateFileService createFileService;

    Logger LOGGER = LogManager.getLogger(CreateFileController.class);

    public CreateFileController() {
    }

    public CreateFileController(CreateFileService createFileService) {
        this.createFileService = createFileService;
    }

    @GetMapping("files/{fileName}")
    public ResponseEntity createFile(@PathVariable(name = "fileName") String fileName) {
        LOGGER.info(fileName);
        if (createFileService.createFile(fileName)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }
}
