package com.example.service;

import java.sql.Timestamp;
import java.util.List;

import com.example.domain.DailyPost;
import com.example.domain.PostedComment;
import com.example.domain.PostedCondition;
import com.example.domain.PostedMotivation;
import com.example.domain.PostedPerformance;
import com.example.domain.Status;
import com.example.form.RegisterDailyPostForm;
import com.example.mapper.DailyPostMapper;
import com.example.mapper.PostedCommentMapper;
import com.example.mapper.PostedConditionMapper;
import com.example.mapper.PostedMotivationMapper;
import com.example.mapper.PostedPerformanceMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 毎日のコンディションをDBに挿入するサービスクラス
 * 
 * @author yuichiyasui
 */
@Service
public class RegisterDailyPostServise {
	@Autowired
	private DailyPostMapper dailyPostMapper;
	@Autowired
	private PostedMotivationMapper postedMotivationMapper;
	@Autowired
	private PostedConditionMapper postedConditionMapper;
	@Autowired
	private PostedPerformanceMapper postedPerformanceMapper;
	@Autowired
	private PostedCommentMapper postedCommentMapper;

	/**
	 * 毎日のコンディション情報をDBに挿入するメソッド.
	 * 
	 * @param form 投稿内容
	 */
	public DailyPost registerDailyPost(RegisterDailyPostForm form) {
		Timestamp tsDate = new Timestamp(System.currentTimeMillis()); // 現在時刻を生成
		Integer userId = form.getUserId();
		DailyPost dailyPost = new DailyPost();
		dailyPost.setUserId(userId);
		dailyPost.setDate(tsDate);
		dailyPost.setRegisterUserId(userId);
		dailyPost.setRegisterDate(tsDate);
		dailyPost.setUpdateUserId(userId);
		dailyPost.setUpdateDate(tsDate);
		dailyPost.setVersion(1);
		dailyPost.setStatus(Status.AVAILABLE.getStatusId());
		dailyPostMapper.save(dailyPost); // daily_postsテーブルに挿入
		Integer dailyPostId = dailyPost.getDailyPostId(); // 自動採番されたIDが取得できる

		PostedMotivation postedMotivation = new PostedMotivation();
		postedMotivation.setDailyPostId(dailyPostId);
		postedMotivation.setMotivationId(form.getMotivationId());
		postedMotivation.setRegisterUserId(userId);
		postedMotivation.setRegisterDate(tsDate);
		postedMotivation.setUpdateUserId(userId);
		postedMotivation.setUpdateDate(tsDate);
		postedMotivation.setVersion(1);
		postedMotivation.setStatus(Status.AVAILABLE.getStatusId());
		postedMotivationMapper.save(postedMotivation); // posted_motivationsテーブルに挿入

		PostedCondition postedCondition = new PostedCondition();
		postedCondition.setDailyPostId(dailyPostId);
		postedCondition.setConditionId(form.getConditionId());
		postedCondition.setRegisterUserId(userId);
		postedCondition.setRegisterDate(tsDate);
		postedCondition.setUpdateUserId(userId);
		postedCondition.setUpdateDate(tsDate);
		postedCondition.setVersion(1);
		postedCondition.setStatus(Status.AVAILABLE.getStatusId());
		postedConditionMapper.save(postedCondition); // posted_conditionsテーブルに挿入

		PostedPerformance postedPerformance = new PostedPerformance();
		postedPerformance.setDailyPostId(dailyPostId);
		postedPerformance.setPerformanceId(form.getPerformanceId());
		postedPerformance.setRegisterUserId(userId);
		postedPerformance.setRegisterDate(tsDate);
		postedPerformance.setUpdateUserId(userId);
		postedPerformance.setUpdateDate(tsDate);
		postedPerformance.setVersion(1);
		postedPerformance.setStatus(Status.AVAILABLE.getStatusId());
		postedPerformanceMapper.save(postedPerformance); // posted_performancesテーブルに挿入

		PostedComment postedComment = new PostedComment();
		postedComment.setDailyPostId(dailyPostId);
		postedComment.setComment(form.getComment());
		postedComment.setRegisterUserId(userId);
		postedComment.setRegisterDate(tsDate);
		postedComment.setUpdateUserId(userId);
		postedComment.setUpdateDate(tsDate);
		postedComment.setVersion(1);
		postedComment.setStatus(Status.AVAILABLE.getStatusId());
		postedCommentMapper.save(postedComment); // posted_commentsテーブルに挿入

		List<DailyPost> DailyPostList = dailyPostMapper.findByUserId(userId);
		return DailyPostList.get(0);


	}
}