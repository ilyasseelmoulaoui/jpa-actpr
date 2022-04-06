package ma.ilyas.jpaactpr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity  // si on veut qu'il se soit une entité jpa. une entité doit avoir un ID donc il faut ajouter l'annotation @Id
@Data  @NoArgsConstructor @AllArgsConstructor //en utilisant lombok cette annotation @Data va ajouter automatique,
                                            // vous pouvez remarque cela si vous cliquez sur la fenetre structure situant
                                            // en bas-gauche de cette fenetre. Si vous supprimez cette annotation les getters
                                            // et les setters de cette classe vont disparaître.
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
}