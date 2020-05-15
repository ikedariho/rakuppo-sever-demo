package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.UpdateUserForm;
import com.example.service.UpdateUserService;

/**
 * ユーザー登録を更新するコントローラー.
 * 
 * @author riho.ikeda
 *
 */
@RestController
@RequestMapping("/updateUser")
public class UpdateUserController {

	@Autowired
	private UpdateUserService updateUserService;

	/**
	 * ユーザー情報の更新時に使用するメソッド.
	 * 
	 * @param form 更新後のユーザー情報
	 * @return 全従業員のユーザー情報
	 */
	@RequestMapping("")
	public List<User> updateUser(@RequestBody UpdateUserForm form) {
		UpdateUserForm updateUserForm = reMakeUserName(form);
		
		List<User> EmployeeList= updateUserService.updateUser(updateUserForm);
		return EmployeeList;

	}

	/**
	 * ユーザフォームの名前とふりがなからスペースを取り除くメソッド.
	 * 
	 * @param form 更新後のユーザフォーム
	 * @return 編集したユーザフォーム
	 */
	public UpdateUserForm reMakeUserName(UpdateUserForm form) {
		String userName = form.getUserName();
		String userNameKana = form.getUserNameKana();
		if (userName.contains(" ")) {
			userName.replace(" ", "");
			form.setUserName(userName);
		}
		if (userNameKana.contains(" ")) {
			userNameKana.replace(" ", "");
			form.setUserNameKana(userNameKana);
		}
		return form;
	}

}
