package com.libbooks.library.service.implementation;

import com.libbooks.library.model.entity.FeedBack;
import com.libbooks.library.repository.FeedBackRepo;
import com.libbooks.library.service.interfaceService.FeedBackService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackRepo feedBackRepo;

    public FeedBackServiceImpl(FeedBackRepo feedBackRepo){
        this.feedBackRepo = feedBackRepo;
    }

    @Override
    public Optional<FeedBack> getFeedBackById(Integer feedBackId){
        return this.feedBackRepo.findById(feedBackId);
    }
    @Override
    public void updateFeedBack(Integer feedBackId,FeedBack feedBack){
        FeedBack feedBackToUpdate = this.feedBackRepo.findById(feedBackId).orElseThrow(()-> new RuntimeException("feedback not found"));
        feedBackToUpdate.setNote(feedBack.getNote());
        feedBackToUpdate.setComment(feedBack.getComment());
        this.feedBackRepo.save(feedBackToUpdate);
    }
    @Override
    public List<FeedBack> getFeedBacks(){
        return this.feedBackRepo.findAll();
    }
    @Override
    public void addFeedBack(FeedBack feedBack){
        this.feedBackRepo.save(feedBack);
    }
    @Override
    public void deleteFeedBack(Integer feedBackId){
        this.feedBackRepo.deleteById(feedBackId);
    }
}
