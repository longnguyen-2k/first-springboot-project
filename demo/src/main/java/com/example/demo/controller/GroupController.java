package com.example.demo.controller;

import com.example.demo.entity.group.Group;
import com.example.demo.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping(path = "api/")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getGroup(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        if (offset == null || offset < 0) {
            offset = 0;
        }
        if (limit == null || limit < 20) {
            limit = 20;
        }
        return groupService.gets(offset, limit);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Group createGroup(@RequestBody Group post) {
        return groupService.create(post);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long postId) {
        groupService.delete(postId);
    }

    @PutMapping(path = "{groupId}")
    public Group updateGroup(@PathVariable("groupId") Long postId, @RequestBody Group post) {
        return groupService.update(postId, post);
    }


}
