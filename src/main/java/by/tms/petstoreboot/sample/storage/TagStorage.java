package by.tms.petstoreboot.sample.storage;

import by.tms.petstoreboot.sample.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TagStorage {

    private final List<Tag> tagList = new ArrayList<>();

    public List<Tag> getTagList() {
        return tagList;
    }
}
