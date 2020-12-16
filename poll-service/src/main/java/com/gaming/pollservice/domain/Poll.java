package com.gaming.pollservice.domain;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "polls")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name="SEQ",sequenceName="poll_seq", allocationSize=1)
@Data
@Builder
public class Poll extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String question;

    private String username;

    @Column(name = "is_approved")
    private Boolean isApproved = true;


    @Column(name = "is_active")
    private Boolean isActive = true;

    @OneToMany(
            mappedBy = "poll",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Choice> choices = new ArrayList<>();

    private LocalDateTime expirationDateTime;

    public void setChoices(List<Choice> choiceList) {
        choiceList.forEach(choice -> {
            addChoice(choice);
        });
    }

    public void addChoice(Choice choice) {
        if(choices==null) {
            choices = new ArrayList<>();
        }
        choices.add(choice);
        choice.setPoll(this);
    }

    public void removeChoice(Choice choice) {
        if(choices!=null){
            choices.remove(choice);
            choice.setPoll(null);
        }

    }
}
