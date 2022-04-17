package com.example.demo.services;

import com.example.demo.dao.GroupRepository;
import com.example.demo.entity.group.Group;
import com.example.demo.entity.post.Post;
import com.example.demo.util.FieldCopyUtil;
import com.example.demo.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GroupService implements  Modifiable<Group> {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group getById(Long id) {

        return groupRepository.findById(id).orElseThrow(() -> new IllegalStateException("Post with id" + id + " does not exist"));
    }

    public List<Group> gets(){
        List<Group> groups= groupRepository.findAll();
        return  groups;

    }
    public List<Group> gets(int offset, int limit){
        Pageable pageable=  PageRequest.of(offset,limit);
        Page<Group> result = groupRepository.findAll(pageable);
        return  result.toList();
    }

    @Override
    public Group create(Group group) {
        return groupRepository.save(group);
    }

    @Transactional
    @Override
    public Group update(Long groupId,Group object) {
        Group findPost = groupRepository.findById(groupId).orElseThrow(() -> new IllegalStateException("Post with id" + groupId + " does not exist"));
        FieldCopyUtil.merge(groupId, findPost);
        Log.log(findPost.toString());
        groupRepository.save(findPost);
        return findPost;
    }

    @Override
    public void delete(Long groupId) {
        boolean ifExists = groupRepository.existsById(groupId);
        if (!ifExists) {
            throw new IllegalStateException("post not found by id: " + groupId);
        }
        groupRepository.deleteById(groupId);
    }

}
