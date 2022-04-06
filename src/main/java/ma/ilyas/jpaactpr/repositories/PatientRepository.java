package ma.ilyas.jpaactpr.repositories;

import ma.ilyas.jpaactpr.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> { /*<Entite qu'on veut gerer,
                                                                           Le type de son ID>*/ /*On a terminer le
                                                                           Mapping Objet-Relationnel*/

    public List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m, Pageable pageable);
    public List<Patient> findByMaladeAndScoreLessThan(boolean m, int score);
    public List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    public List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2 , String mc);

    @Query("select p from Patient p where p.nom like :x and p.score<:y")
    List<Patient> chercherPatients(@Param("x") String nom, @Param("y") int scoreMin);

}