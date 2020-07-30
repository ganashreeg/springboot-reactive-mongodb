package com.ganashree.springbootreactivemongodb.controller;

import com.ganashree.springbootreactivemongodb.model.UserProfile;
import com.ganashree.springbootreactivemongodb.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TestController {

    @Autowired
    TestRepository testRepository;

    @GetMapping("/api/user-profile")
    public Flux<UserProfile> getProfileName(){
        Flux<UserProfile> userProfileList = testRepository.findAll();
        return userProfileList;
    }

    @GetMapping("/api/user-profile/{id}")
    public Mono<UserProfile> getProfileNameById(@PathVariable("id") String userProfileId){
        Mono<UserProfile> userProfile = testRepository.findById(userProfileId);
        return userProfile;
    }

    @PostMapping("/api/user-profile/create")
    public Mono<UserProfile> createProfileName(@RequestBody UserProfile userProfile){
        Mono<UserProfile> userProfileMono=testRepository.insert(userProfile);
        return userProfileMono;
    }

    @PutMapping("/api/user-profile/update")
    public Mono<UserProfile> updateProfileName(@RequestBody UserProfile userProfile){
        Mono<UserProfile> userProfileMono=testRepository.save(userProfile);
        return userProfileMono;

    }

    @DeleteMapping("/api/user-profile/{id}")
    public Mono<Void> deleteProfileName(@PathVariable("id") String userProfileId){
        Mono<Void> deleted=testRepository.deleteById(userProfileId);
        return deleted;
    }


}

/*
public class TestController {

    @GetMapping("/api/user-profile")
    public Mono<List<UserProfile>> getName(){

        List<UserProfile> userProfileList = new ArrayList<>();

        UserProfile userProfile1 = new UserProfile();
        userProfile1.setName("raki");
        userProfile1.setAge(30);

        UserProfile userProfile2 = new UserProfile();
        userProfile2.setName("pradeep");
        userProfile2.setAge(31);

        userProfileList.add(userProfile1);
        userProfileList.add(userProfile2);

        return Mono.just(userProfileList);

    }
}
 */
