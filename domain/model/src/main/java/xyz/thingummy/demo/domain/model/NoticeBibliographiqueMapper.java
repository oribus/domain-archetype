package xyz.thingummy.demo.domain.model;

import org.mapstruct.Mapper;

@Mapper
public interface NoticeBibliographiqueMapper {

    NoticeBibliographiqueId toId(NoticeBibliographique noticeBibliographique);


}
