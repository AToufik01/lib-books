package com.libbooks.library.controller;


import com.libbooks.library.model.entity.FeedBack;
import com.libbooks.library.service.interfaceService.FeedBackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FeedBackController {
    private final FeedBackService feedBackService;
    public FeedBackController(FeedBackService feedBackService){
        this.feedBackService = feedBackService;
    }

    @GetMapping("/feedback/{feedBackId}")
    public Optional<FeedBack> getFeedBackById(@PathVariable Integer feedBackId){
        return this.feedBackService.getFeedBackById(feedBackId);
    }

    @GetMapping("/feedbacks")
    public List<FeedBack> getAllFeedBacks(){
        return this.feedBackService.getFeedBacks();
    }

    @PostMapping("/feedback")
    public void addFeedBack(@RequestBody FeedBack feedBack){
        this.feedBackService.addFeedBack(feedBack);
    }
    @PutMapping("/feedback/{feedBackId}")
    public void updateFeedBack(@PathVariable Integer feedBackId,@RequestBody FeedBack feedBack){
        this.feedBackService.updateFeedBack(feedBackId,feedBack);
    }

    @DeleteMapping("/feedback/{feedBackId}")
    public void deleteFeedBack(@PathVariable Integer feedBackId){
        this.feedBackService.deleteFeedBack(feedBackId);
    }
}
