package by.tms.petstoreboot.sample.service;

import by.tms.petstoreboot.sample.model.Pet;
import by.tms.petstoreboot.sample.model.Tag;
import by.tms.petstoreboot.sample.resources.exceptions.InvalidIDSuppliedException;
import by.tms.petstoreboot.sample.resources.exceptions.TagExistsException;
import by.tms.petstoreboot.sample.resources.exceptions.ValidationException;
import by.tms.petstoreboot.sample.storage.TagStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private TagStorage tagStorage;

    public boolean contains(String name) {
        for (Tag tag : tagStorage.getTagList()) {
            if (tag.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Tag> getTags(){
        return tagStorage.getTagList();
    }

    public Tag addNewTag(Tag tag) {
        if(tagStorage.getTagList().contains(tag)){
            throw new TagExistsException("This tag exists");
        }
        tagStorage.getTagList().add(tag);
        return tag;
    }

    public Tag findTagById(long id) {
        for (Tag tag : tagStorage.getTagList()) {
            if (tag.getId() == id) {
                return tag;
            }
        }
        throw new InvalidIDSuppliedException("Invalid ID supplied(tag)");
    }

    public Tag updateTag(Tag tag){
        for(Tag t : tagStorage.getTagList()){
            if(t.getId() == tag.getId()){
                t.setName(tag.getName());
                return t;
            }
        }
        throw new ValidationException("Validation exception(tag)");
    }

    public Boolean deleteTag(long id){
        tagStorage.getTagList().removeIf(tag -> tag.getId() == id);
        return true;
    }

    @Autowired
    public void setTagStorage(TagStorage tagStorage) {
        this.tagStorage = tagStorage;
    }
}
