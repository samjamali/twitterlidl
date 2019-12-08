/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti;

import org.springframework.data.jpa.domain.AbstractPersistable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *
 * @author Borna
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Viestit extends AbstractPersistable<Long> {
    //luodaan viesti
    private LocalDateTime messageDate = LocalDateTime.now();
    private String message;
}