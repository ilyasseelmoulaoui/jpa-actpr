package ma.ilyas.jpaactpr;

import ma.ilyas.jpaactpr.entities.Patient;
import ma.ilyas.jpaactpr.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaActprApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(JpaActprApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        patientRepository.save(new Patient(null,"Amine",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        patientRepository.save(new Patient(null,"Rabab",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        patientRepository.save(new Patient(null,"Karim",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        patientRepository.save(new Patient(null,"Khawla",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        patientRepository.save(new Patient(null,"Saad",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
        patientRepository.save(new Patient(null,"Rabie",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));

        Page<Patient> patients =patientRepository.findAll(PageRequest.of(2,3));
        System.out.println("Total pages :"+patients.getTotalPages());
        System.out.println("Total elements :"+patients.getTotalElements());
        System.out.println("Numéro de page :"+patients.getNumber());
        List<Patient> content = patients.getContent();
//        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,5));
//        List<Patient> patientList = patientRepository.chercherPatients("%m%",50);
        content.forEach(p->{
            System.out.println("_________________________________");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
        });
        /*
        System.out.println("_______________________________________");
        Patient patient =patientRepository.findById(1L).orElse(null);
        if(patient !=null){
              System.out.println(patient.getNom());
              System.out.println(patient.isMalade());
          }
        patient.setScore(850);
        patientRepository.save(patient);
        patientRepository.deleteById(3L); //supp le patient dont le id=3
        */
    }
}
