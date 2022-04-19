package com.example.demo.controller;

import com.example.demo.entity.group.Group;
import com.example.demo.services.group.GroupServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RestController
@RequestMapping(path = "api/")
@RequiredArgsConstructor
public class GroupController {


    private final GroupServiceImpl groupServiceImpl;

    @GetMapping
    public List<Group> getGroup(@RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit) {
        if (offset == null || offset < 0) {
            offset = 0;
        }
        if (limit == null || limit < 20) {
            limit = 20;
        }
        return groupServiceImpl.gets(offset, limit);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Group createGroup(@RequestBody Group post) {
        return groupServiceImpl.create(post);
    }

    @DeleteMapping(path = "{groupId}")
    public void deleteGroup(@PathVariable("groupId") Long postId) {
        groupServiceImpl.delete(postId);
    }

    @PutMapping(path = "{groupId}")
    public Group updateGroup(@PathVariable("groupId") Long postId, @RequestBody Group post) {
        return groupServiceImpl.update(postId, post);
    }


}
