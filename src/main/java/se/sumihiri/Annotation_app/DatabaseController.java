package se.sumihiri.Annotation_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aws-services")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;


    @PostMapping
    public ResponseEntity<AWSModel> createAWSService(@RequestBody AWSModel awsModel) {
        AWSModel createdAWSModel = databaseService.createAWSService(awsModel);
        return ResponseEntity.ok(createdAWSModel);
    }

    @GetMapping
    public ResponseEntity<Iterable<AWSModel>> getAllAWSServices() {
        Iterable<AWSModel> services = databaseService.getAllAWSServices();
        return ResponseEntity.ok(services);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AWSModel> updateAWSServiceById(@PathVariable Long id, @RequestBody AWSModel awsModel) {
        AWSModel updatedAWSModel = databaseService.updateAWSServiceById(id, awsModel);
        return ResponseEntity.ok(updatedAWSModel);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAWSServiceById(@PathVariable Long id) {
        boolean deleted = databaseService.deleteAWSServiceById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
