package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.DailyPost;
import com.example.form.ShowDailyPostListForm;
import com.example.service.DailyPostServiceImpl;

@RestController
@RequestMapping("")
public class DailyPostsHistoryController {
	
	@Autowired
	private DailyPostServiceImpl dailyPostService;

	/**
	 * ユーザの投稿履歴を取得するメソッド.
	 * 
	 * @param form ユーザIDのリクエストパラメータ
	 * @return 投稿履歴リスト
	 */
	@CrossOrigin(origins="http://localhost:8888")
	@RequestMapping("/motivations")
	public List<DailyPost> showDaylyPostsHistory(@RequestBody ShowDailyPostListForm form){
		List<DailyPost> dailyPostList = dailyPostService.getDailyPostList(form);
		return dailyPostList;
	}
}