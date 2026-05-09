package com.libbooks.library.service.implementation;

import com.libbooks.library.model.dto.FeedBackDTO;
import com.libbooks.library.model.entity.FeedBack;
import com.libbooks.library.repository.FeedBackRepo;
import com.libbooks.library.service.interfaceService.FeedBackService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    private final FeedBackRepo feedBackRepo;
    private final ModelMapper modelMapper;

    public FeedBackServiceImpl(FeedBackRepo feedBackRepo, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.feedBackRepo = feedBackRepo;
    }

    @Override
    public FeedBackDTO getFeedBackById(Integer feedBackId){
        try{
            FeedBack feedBack = this.feedBackRepo.findById(feedBackId).orElseThrow(()-> new RuntimeException("feedback not found"));
            return this.modelMapper.map(feedBack,FeedBackDTO.class);
        }   catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public FeedBackDTO updateFeedBack(Integer feedBackId,FeedBackDTO feedBack){
        try{
            FeedBack feedBackToUpdate = this.feedBackRepo.findById(feedBackId).orElseThrow(()-> new RuntimeException("feedback not found"));
            modelMapper.map(feedBack,feedBackToUpdate);
            feedBackToUpdate.setId(feedBackId);
            this.feedBackRepo.save(feedBackToUpdate);
            return this.modelMapper.map(feedBackToUpdate,FeedBackDTO.class);

        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<FeedBackDTO> getFeedBacks(){
        try {
            return this.feedBackRepo.findAll().stream().map(feedBack -> this.modelMapper.map(feedBack, FeedBackDTO.class)).collect(Collectors.toList());
        }
        catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public FeedBackDTO addFeedBack(FeedBackDTO feedBack){
        try{
            FeedBack feedBackToAdd = this.modelMapper.map(feedBack,FeedBack.class);
            feedBackToAdd = this.feedBackRepo.save(feedBackToAdd);
            return this.modelMapper.map(feedBackToAdd,FeedBackDTO.class);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public void deleteFeedBack(Integer feedBackId){
        try {
            this.feedBackRepo.findById(feedBackId).orElseThrow(() -> new RuntimeException("feedback not found"));
            this.feedBackRepo.deleteById(feedBackId);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
