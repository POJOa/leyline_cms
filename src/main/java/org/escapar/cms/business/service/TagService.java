package org.escapar.cms.business.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.escapar.cms.business.domain.tag.Tag;
import org.escapar.cms.business.domain.tag.TagRepo;

import org.escapar.cms.business.domain.tag.Tag;
import org.escapar.leyline.framework.infrastructure.common.exceptions.PersistenceException;
import org.escapar.leyline.framework.service.LeylineDomainService;
import org.springframework.stereotype.Service;

import org.escapar.leyline.framework.infrastructure.common.exceptions.PersistenceException;
import org.escapar.leyline.framework.service.LeylineDomainService;

@Service
public class TagService extends LeylineDomainService<TagRepo,Tag> {

    @Override
    public List<Tag> save(Collection<Tag> tags) throws PersistenceException {

        if(tags == null) return new ArrayList<>();
        // convert tags to Map(Key,Tag)
        Map<String,Tag> everyOne = ((ArrayList<Tag>)repo.findAll()).stream().collect(Collectors.toMap(Tag::getName,
                Function.identity()));

        // tag names must be unique , replace existing ones with persisted objects
        List res = tags.stream().map(i-> everyOne.getOrDefault(i.getName(), i)).collect(Collectors.toList());

        try {
            return (List<Tag>) repo.saveAll(res);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public Tag save(Tag entity) throws PersistenceException {
        // convert tags to Map(Key,Tag)
        Map<String,Tag> everyOne = ((ArrayList<Tag>)repo.findAll()).stream().collect(Collectors.toMap(Tag::getName,
                Function.identity()));

        try {
            // tag names must be unique , replace existed one with persisted objects
            return everyOne.containsKey(entity.getName()) ? everyOne.get(entity.getName()): repo.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException(e.getMessage());
        }
    }

}