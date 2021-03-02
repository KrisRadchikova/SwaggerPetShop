package by.tms.petstoreboot.sample.resources;

import by.tms.petstoreboot.sample.model.Tag;
import by.tms.petstoreboot.sample.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Valid
@RequestMapping(path = "/tags")
public class TagController {

    private TagService tagService;

    @GetMapping
    public List<Tag> getTags(){
        return tagService.getTags();
    }

    @GetMapping(path = "/find/{tadId}")
    public Tag findById(@PathVariable long tadId){
        return tagService.findTagById(tadId);
    }

    @PostMapping(path = "/add")
    public Tag createNewTag(@RequestBody Tag tag){
        return tagService.addNewTag(tag);
    }

    @PutMapping(path = "/update")
    public Tag updateTag(@RequestBody Tag tag){
        return tagService.updateTag(tag);
    }

    @DeleteMapping(path = "/{tagId}")
    public Boolean deleteTagById(@PathVariable long tagId){
        return tagService.deleteTag(tagId);
    }

    @Autowired
    public void setTagService(TagService tagService) {
        this.tagService = tagService;
    }
}
