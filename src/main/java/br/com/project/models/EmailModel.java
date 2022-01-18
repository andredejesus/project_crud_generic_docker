package br.com.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String ownerRef;
    private String emailFrom;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;

    
}
