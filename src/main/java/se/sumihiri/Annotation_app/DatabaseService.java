package se.sumihiri.Annotation_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DatabaseService {
    @Autowired
    private AWSRepository repository;
    @XRayTimed(segmentName = "Database service")
    public AWSModel updateAWSServiceById(Long id, AWSModel awsModel) {
        awsModel.setServiceId(id);
        return repository.save(awsModel);
    }
    @XRayTimed(segmentName = "Database all services")
    public Iterable<AWSModel> getAllAWSServices() {
        return repository.findAll();
    }
    @XRayTimed(segmentName = "Database service Save")
    public AWSModel createAWSService(AWSModel awsModel) {
        return repository.save(awsModel);
    }
    @XRayTimed(segmentName = "Database service Delete")
    public boolean deleteAWSServiceById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}