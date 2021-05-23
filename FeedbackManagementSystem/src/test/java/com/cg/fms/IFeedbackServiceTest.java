package com.cg.fms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.entities.Feedback;
import com.cg.fms.entities.Program;
import com.cg.fms.repository.IFeedbackRepository;
import com.cg.fms.service.IFeedbackService;

@SpringBootTest
public class IFeedbackServiceTest {
	@Autowired
	IFeedbackService feedbackService;
	@MockBean
	IFeedbackRepository feedRepo;
	
	@Test
	public void testAddFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1);
		Mockito.when(feedRepo.save(feed)).thenReturn(feed);
		assertThat(feedbackService.addFeedback(feed)).isEqualTo(feed);
		
	}
	@Test
	public void testUpdateFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Program pro = new Program();
		pro.setTrainingId(1);
		feed.setFeedback_Id(1);
		Mockito.when(feedRepo.findById(feed.getFeedback_Id())).thenReturn(Optional.of(feed));
		feed.setFeedbackCriteria1(5);
		Mockito.when(feedRepo.save(feed)).thenReturn(feed);
		assertThat(feedbackService.updateFeedback(feed)).isEqualTo(feed);
	}
	/*@Test
	public void testViewProgramFeedback() {
		Feedback feed=new Feedback();
		feed.setFeedback_Id(123);
		feed.setFeedbackCriteria1(8);
		feed.setFeedbackCriteria2(9);
		feed.setFeedbackCriteria3(8);
		feed.setFeedbackCriteria4(5);
		feed.setFeedbackCriteria5(6);
		feed.setSuggestions("Good");
		feed.setComments("Wonderful");
		Mockito.when(feedRepo.findById(feed.getFeedback_Id())).thenReturn(Optional.of(feed));
		assertThat(feedbackService.viewProgramFeedback(feed.getFeedback_Id())).isEqualTo(feed);
	}*/

}