package xyz.thingummy.demo.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class NoticeBibliographique  {
    private UUID id;
    private String titre;
    private String auteur;
    private String editeur;
    private String datePublication;
    private String resume;
    private String isbn;
    private String issn;
}
