package sih.compta.services;


import java.util.List;

import sih.compta.repositories.ServiceRepository;
import sih.stoc.entities.Service;

@org.springframework.stereotype.Service
public class ServiceService {

	// @Autowired
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    
 // Sauvegarder un Service
    public Service save(Service service) {
    	if(!serviceRepository.existsById(service.getIds()))
    		return   this.serviceRepository.save(service);
		return null;
    }
    
    // Editer un Service
 public Service edit(Long id, Service sev) {
    	
    	Service sevmod = this.serviceRepository.findById(id).get();
		if(sevmod != null) {
			//sevmod.setCodeService(sev.getCodeService());
			//sevmod.setLibService(sev.getLibService());
			
			return this.serviceRepository.save(sevmod);
    }
		return null;
    }
 
    
 // Supprimer un Service
 public boolean delete(Long id) {
	 if(this.serviceRepository.existsById(id))
         this.serviceRepository.deleteById(id);
	 
	return this.serviceRepository.existsById(id);
 }   
 
 // Renvoie un Service par son id
 public Service findById(Long id) {
     return this.serviceRepository.findById(id).get();
 }
 
 
 
    // Liste 
    public List<Service> getAll() {
        return  this.serviceRepository.findAll();
    }
    
  /*/liste par code
    public List<Service> findByCodeService(String CodeService){
		
		return this.serviceRepository.findByCodeService(CodeService);
	}
    
  //liste par libelle
    public List<Service> findByLibelleServicer(String LibelleService){
		
		return this.serviceRepository.findByLibService(LibelleService);
	}*/
    
}
